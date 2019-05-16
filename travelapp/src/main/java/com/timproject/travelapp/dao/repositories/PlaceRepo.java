package com.timproject.travelapp.dao.repositories;

import com.timproject.travelapp.dao.entities.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaceRepo extends CrudRepository<Place, Long> {

    List<Place> findAll();

    Place findById(long id);
}
