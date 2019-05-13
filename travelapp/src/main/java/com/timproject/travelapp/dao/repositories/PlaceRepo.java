package com.timproject.travelapp.dao.repositories;

import com.timproject.travelapp.dao.entities.PlaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepo extends CrudRepository<PlaceEntity, Long> {
}
