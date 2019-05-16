package com.timproject.travelapp.controllers;


import com.timproject.travelapp.dao.entities.Place;
import com.timproject.travelapp.dto.PlaceDTO;
import com.timproject.travelapp.managers.PlaceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class PlaceController {

    private PlaceManager placeManager;

    @Autowired
    public PlaceController(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }


    @GetMapping(value="travelapp/place/all")
    public ResponseEntity getAllPlaces() {
        return new ResponseEntity<>(placeManager.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "travelapp/place/{id}")
    public ResponseEntity getPlaceById(@PathVariable long id) {
        PlaceDTO placeDTO = placeManager.findById(id);
        return new ResponseEntity<>(placeDTO, HttpStatus.OK);
    }

    @PostMapping
    public void addPlace(@RequestBody Place place) {
        placeManager.save(place);
    }

    @PutMapping
    public void updatePlace(@RequestBody Place place) {
        placeManager.save(place);
    }

    @DeleteMapping
    public void deletePlace(@RequestParam Long id) {
        placeManager.deleteById(id);
    }
}
