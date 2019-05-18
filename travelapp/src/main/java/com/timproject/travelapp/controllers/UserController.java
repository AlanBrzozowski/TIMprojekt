package com.timproject.travelapp.controllers;

import com.timproject.travelapp.dao.entities.UserEntity;
import com.timproject.travelapp.managers.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.Optional;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="travelapp/user/all")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public Optional<UserEntity> getUserById(@RequestParam Long id){
        return userService.findById(id);
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.OPTIONS)
    public ResponseEntity getOptions() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/user/register")
    public ResponseEntity register(@RequestBody UserEntity userEntity) {
        try {
            String abc = userService.register(userEntity);
            if (abc == null) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(abc, HttpStatus.CONFLICT);
            }
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
