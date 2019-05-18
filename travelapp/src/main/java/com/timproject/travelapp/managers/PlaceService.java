package com.timproject.travelapp.managers;


import com.timproject.travelapp.dao.entities.PlaceEntity;
import com.timproject.travelapp.dao.repositories.PlaceRepository;
import com.timproject.travelapp.dto.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    private PlaceDTO convertPlaceToPlaceDTO(PlaceEntity placeEntity) {
        return new PlaceDTO(
                placeEntity.getId(),
                placeEntity.getName(),
                placeEntity.getAddress(),
                placeEntity.getInfo(),
                placeEntity.getLatitude(),
                placeEntity.getLongitude(),
                placeEntity.getAccepted(),
                placeEntity.getActive(),
                placeEntity.getUserId()
               );
    }

    private ArrayList<PlaceDTO> convertPlaceListToPlaceDTOList(List<PlaceEntity> placeEntities) {
        ArrayList<PlaceDTO> placeDTOS = new ArrayList<>(placeEntities.size());
        for (PlaceEntity placeEntity : placeEntities) {
            placeDTOS.add(new PlaceDTO(
                    placeEntity.getId(),
                    placeEntity.getName(),
                    placeEntity.getAddress(),
                    placeEntity.getInfo(),
                    placeEntity.getLatitude(),
                    placeEntity.getLongitude(),
                    placeEntity.getAccepted(),
                    placeEntity.getActive(),
                    placeEntity.getUserId()
            ));
        }
        return placeDTOS;
    }

    public PlaceDTO findById(long id) {
        PlaceEntity placeEntity = placeRepository.findById(id);
            return convertPlaceToPlaceDTO(placeEntity);
    }

    public List<PlaceDTO> findAll() {
        return  convertPlaceListToPlaceDTOList(placeRepository.findAll());
    }

    public Optional<PlaceEntity> findById(Long id) {
        return placeRepository.findById(id);
    }

    public void save(PlaceEntity placeEntity) {
        placeRepository.save(placeEntity);
    }

    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }


}
