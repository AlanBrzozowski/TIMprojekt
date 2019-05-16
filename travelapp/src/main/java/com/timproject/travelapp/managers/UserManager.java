package com.timproject.travelapp.managers;


import com.timproject.travelapp.dao.entities.User;
import com.timproject.travelapp.dao.repositories.UserRepo;
import com.timproject.travelapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserManager {

    private UserRepo userRepo;

    @Autowired
    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOS= new ArrayList<>(users.size());
        for (User user: users) {
            userDTOS.add(new UserDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getActive()
            ));
        }
        return userDTOS;
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }
}
