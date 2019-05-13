package com.timproject.travelapp.controllers;


import com.timproject.travelapp.dao.entities.PlaceEntity;
import com.timproject.travelapp.managers.PlaceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/travelapp/place")
public class PlaceController {

    private PlaceManager placeManager;

    @Autowired
    public PlaceController(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }


    @GetMapping("/all")
    public Iterable<PlaceEntity> getAllPlaces() {
        return placeManager.findAll();
    }

    @GetMapping
    public Optional<PlaceEntity> getPlaceById(@RequestParam Long id) {
        return placeManager.findById(id);
    }

    @PostMapping
    public void addPlace(@RequestBody PlaceEntity placeEntity) {
        placeManager.save(placeEntity);
    }

    @PutMapping
    public void updatePlace(@RequestBody PlaceEntity placeEntity) {
        placeManager.save(placeEntity);
    }

    @DeleteMapping
    public void deletePlace(@RequestParam Long id) {
        placeManager.deleteById(id);
    }
}
