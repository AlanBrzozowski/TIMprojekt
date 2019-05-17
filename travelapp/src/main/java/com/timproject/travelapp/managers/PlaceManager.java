package com.timproject.travelapp.managers;


import com.timproject.travelapp.dao.entities.Place;
import com.timproject.travelapp.dao.entities.User;
import com.timproject.travelapp.dao.repositories.PlaceRepo;
import com.timproject.travelapp.dao.repositories.UserRepo;
import com.timproject.travelapp.dto.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlaceManager {

    private PlaceRepo placeRepo;

    @Autowired
    public PlaceManager(PlaceRepo placeRepo) {
        this.placeRepo = placeRepo;
    }


    private PlaceDTO convertPlaceToPlaceDTO(Place place) {
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getInfo(),
                place.getLatitude(),
                place.getLongitude(),
                place.getAccepted(),
                place.getActive(),
                place.getUserId()
               );
    }

    private ArrayList<PlaceDTO> convertPlaceListToPlaceDTOList(List<Place> places) {
        ArrayList<PlaceDTO> placeDTOS = new ArrayList<>(places.size());
        for (Place place: places) {
            placeDTOS.add(new PlaceDTO(
                    place.getId(),
                    place.getName(),
                    place.getAddress(),
                    place.getInfo(),
                    place.getLatitude(),
                    place.getLongitude(),
                    place.getAccepted(),
                    place.getActive(),
                    place.getUserId()
            ));
        }
        return placeDTOS;
    }

    public PlaceDTO findById(long id) {
        Place place = placeRepo.findById(id);
            return convertPlaceToPlaceDTO(place);
    }

    public List<PlaceDTO> findAll() {
        return  convertPlaceListToPlaceDTOList(placeRepo.findAll());
    }

    public Optional<Place> findById(Long id) {
        return placeRepo.findById(id);
    }

    public void save(Place place) {
        placeRepo.save(place);
    }

    public void deleteById(Long id) {
        placeRepo.deleteById(id);
    }


}
