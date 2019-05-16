package com.timproject.travelapp.controllers;

import com.timproject.travelapp.dao.entities.User;
import com.timproject.travelapp.managers.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/travelapp/user")
public class UserController {

    private UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping(value="/all")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity<>(userManager.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public Optional<User> getUserById(@RequestParam Long id){
        return userManager.findById(id);
    }


//    @GetMapping("/all")
//    public Iterable<Place> getAllPlaces() {
//        return placeManager.findAll();
//    }
//
//    @GetMapping
//    public Optional<Place> getPlaceById(@RequestParam Long id) {
//        return placeManager.findById(id);
//    }
}
