package com.timproject.travelapp.managers;

import com.timproject.travelapp.dao.entities.VisitEntity;
import com.timproject.travelapp.dao.repositories.PlaceRepository;
import com.timproject.travelapp.dao.repositories.VisitRepository;
import com.timproject.travelapp.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.sasl.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitService{

    private VisitRepository visitRepository;
    private AuthenticationService authenticationService;
    private PlaceRepository placeRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository,  AuthenticationService authenticationService, PlaceRepository placeRepository) {
        this.visitRepository = visitRepository;

        this.authenticationService = authenticationService;
        this.placeRepository = placeRepository;
    }

    private List<VisitDTO> findMyPlaces(long userId, boolean visited) {
        List<VisitEntity> visitEntities = visitRepository.findAllByUserIdAndVisitedAndVisible(userId, visited, true);
        List<VisitDTO> visitDTOS = new ArrayList<>(visitEntities.size());
        for (VisitEntity visitEntity : visitEntities) {
            visitDTOS.add(new VisitDTO(
                    visitEntity.getId(),
                    visitEntity.getDate(),
                    visitEntity.getVisited(),
                    visitEntity.getVisible(),
                    visitEntity.getUserId(),
                    visitEntity.getPlaceId()
            ));
        }
        return visitDTOS;
    }


    public List<VisitDTO> findMyVisitedPlaces(long userId, HttpHeaders httpHeaders) throws AuthenticationException {
        if (authenticationService.authenticate(httpHeaders, userId)) {
            return findMyPlaces(userId, true);
        } else {
            throw new AuthenticationException();
        }
    }

    public List<VisitDTO> findMyNotVisitedPlaces(long userId, HttpHeaders httpHeaders) throws AuthenticationException {
        if (authenticationService.authenticate(httpHeaders, userId)) {
            return findMyPlaces(userId, false);
        } else {
            throw new AuthenticationException();
        }
    }



    public List<VisitDTO> findMyNotVisitedPlaces(long userId) {
        return findMyPlaces(userId, false);
    }



    public String newVisit(VisitEntity visitEntity, HttpHeaders httpHeaders) throws AuthenticationException {
        if (authenticationService.authenticate(httpHeaders, visitEntity.getUserId())) {
            VisitEntity visitEntityTemp = visitRepository.findByUserIdAndPlaceIdAndVisited(visitEntity.getUserId(), visitEntity.getPlaceId(), false);
            if (visitEntityTemp != null) {
                return "visitAlreadyExist";
            } else {
                if (placeRepository.findById(visitEntity.getPlaceId()) != null) {
                    visitEntity.setVisited(false);
                    visitEntity.setVisible(true);
                    visitEntity.setDate(null);
                    visitRepository.save(visitEntity);
                    return null;
                } else {
                    return"placeNotFound";
                }
            }
        } else {
            throw new AuthenticationException();
        }
    }


    public String deleteVisit(long visitId, long userId, HttpHeaders httpHeaders) throws AuthenticationException {
        if (authenticationService.authenticate(httpHeaders, userId)) {
            VisitEntity visitEntity = visitRepository.findById(visitId);
            if (visitEntity != null) {
                    if (userId == visitEntity.getUserId()) {
                        visitRepository.deleteById(visitId);
                        return null;
                    } else {
                        throw new AuthenticationException();
                    }
            }
            return "visitNotFound";
        } else {
            throw new AuthenticationException();
        }
    }

    public String selectPlaceAsVisited(HttpHeaders httpHeaders, long userId, long visitId) throws AuthenticationException {
        if (authenticationService.authenticate(httpHeaders, userId)){
            VisitEntity visitEntity = visitRepository.findById(visitId);
            if (visitEntity != null) {
                if (visitEntity.getUserId() == userId) {
                    if (!visitEntity.getVisited()) {
                        visitEntity.setVisited(true);
                        visitRepository.save(visitEntity);
                        return null;
                    } else {
                        return "placeAlreadyVisited";
                    }
                } else {
                    throw new AuthenticationException();
                }
            } else {
                return"visitNotFound";
            }
        } else {
            throw new AuthenticationException();
        }
    }

    public List<VisitDTO> findMyVisitedPlaces(long userId) {
        return findMyPlaces(userId, true);
    }


}