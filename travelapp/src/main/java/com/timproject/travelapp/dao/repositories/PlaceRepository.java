package com.timproject.travelapp.dao.repositories;

import com.timproject.travelapp.dao.entities.PlaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaceRepository extends CrudRepository<PlaceEntity, Long> {

    List<PlaceEntity> findAll();

    PlaceEntity findById(long id);
}
