package com.timproject.travelapp.dao.repositories;

import com.timproject.travelapp.dao.entities.VisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<VisitEntity, Integer> {


    List<VisitEntity> findAllByUserIdAndVisitedAndVisible(long id, boolean visited, boolean visible);

    VisitEntity findById(long id);

    VisitEntity findByUserIdAndPlaceIdAndVisited(long userId, long placeId, boolean visited);

    void deleteById(long id);

    List<VisitEntity> findAllByPlaceId(long placeId);
}