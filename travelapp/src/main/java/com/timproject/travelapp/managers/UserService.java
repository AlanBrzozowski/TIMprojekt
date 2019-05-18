package com.timproject.travelapp.managers;


import com.timproject.travelapp.dao.entities.UserEntity;
import com.timproject.travelapp.dao.repositories.UserRepository;
import com.timproject.travelapp.dao.repositories.UserRoleRepository;
import com.timproject.travelapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import javax.security.sasl.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public List<UserDTO> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS= new ArrayList<>(userEntities.size());
        for (UserEntity userEntity : userEntities) {
            userDTOS.add(new UserDTO(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getActive(),
                    userEntity.getUserRoleId()
            ));
        }
        return userDTOS;
    }

    public boolean isAdmin(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        System.out.println(userRoleRepository.findById(userEntity.getUserRoleId()));
        return userEntity != null && userRoleRepository.findById(userEntity.getUserRoleId()).getLabel().equals("Administrator");
    }

    public boolean isAdmin(UserEntity userEntity) {
        return userRoleRepository.findById(userEntity.getUserRoleId()).getLabel().equals("Administrator");
    }


    public String getUserIdByUsername(String username) {
        return String.valueOf(userRepository.findByUsername(username).getId());
    }

    public String isAdminToString(String username) {
        if (isAdmin(username)) {
            return "true";
        } else {
            return "false";
        }
    }

    public boolean isActive(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity != null && userEntity.getActive();
    }

    public String register(UserEntity userEntity) throws AuthenticationException {
        if (userEntity.getUserRoleId() == 0) {
            userEntity.setUserRoleId(2);
        }
            if (userRepository.findByUsername(userEntity.getUsername()) != null) {
                return "username taken";
            } else {
                if (isStringCorrect(userEntity.getUsername())) {
                    if (isStringCorrect(userEntity.getPassword())) {
                        userEntity.setPassword(BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt()));
                        userEntity.setActive(true);
                        userRepository.save(userEntity);
                        return null;
                    } else {
                        return "emptyPassword";
                    }
                } else {
                    return "emptyUsername";
                }
            }
    }


    private boolean isStringCorrect(String string) {
        if (string.equals("")) {
            return false;
        } else {
            return !string.replaceAll(" ", "").equals("");
        }
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }
}
