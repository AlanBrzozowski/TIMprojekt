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
    private UserRepo userRepo;

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
//                username
               );
    }

    private ArrayList<PlaceDTO> convertPlaceListToPlaceDTOList(List<Place> places) {
        ArrayList<PlaceDTO> placeDTOS = new ArrayList<>(places.size());
        User user;
        String username;
//        System.out.println("DUPA");
        for (Place place: places) {
//            user = userRepo.findById(place.getUserId());
//            if (user == null) {
//                username = "-";
//            } else {
//                username = user.getUsername();
//            }
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
//                    username = user.getUsername()
            ));
        }
        return placeDTOS;
    }

    public PlaceDTO findById(long id) {
        Place place = placeRepo.findById(id);
//        if (place != null) {
//            User user = userRepo.findById(place.getUserId());
//            String username;
//            if (user == null) {
//                username = "-";
//            } else {
//                username = user.getUsername();
//            }
            return convertPlaceToPlaceDTO(place);
//        } else {
//            return null;
//        }
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
