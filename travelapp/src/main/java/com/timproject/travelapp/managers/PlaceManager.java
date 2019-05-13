package com.timproject.travelapp.managers;


import com.timproject.travelapp.dao.entities.PlaceEntity;
import com.timproject.travelapp.dao.repositories.PlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PlaceManager {

    private PlaceRepo placeRepo;

    @Autowired
    public PlaceManager(PlaceRepo placeRepo) {
        this.placeRepo = placeRepo;
    }


    public Iterable<PlaceEntity> findAll() {
        return  placeRepo.findAll();
    }

    public Optional<PlaceEntity> findById(Long id) {
        return placeRepo.findById(id);
    }

    public void save(PlaceEntity placeEntity) {
        placeRepo.save(placeEntity);
    }

    public void deleteById(Long id) {
        placeRepo.deleteById(id);
    }


}
