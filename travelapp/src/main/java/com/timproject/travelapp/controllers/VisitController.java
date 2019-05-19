package com.timproject.travelapp.controllers;


import com.timproject.travelapp.dao.entities.VisitEntity;
import com.timproject.travelapp.managers.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@Controller
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @GetMapping(value = "/visit/myVisitedPlaces/{userId}")
    public ResponseEntity findMyVisitedPlaces(@PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        try {
            return new ResponseEntity<>(visitService.findMyVisitedPlaces(userId, httpHeaders), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/visit/myNotVisitedPlaces/{userId}")
    public ResponseEntity findMyNotVisitedPlaces(@PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        try {
            return new ResponseEntity<>(visitService.findMyNotVisitedPlaces(userId, httpHeaders), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/visit/add")
    public ResponseEntity newVisit(@RequestBody VisitEntity visitEntity, @RequestHeader HttpHeaders httpHeaders) {
        try {
            String abc = visitService.newVisit(visitEntity, httpHeaders);
            if (abc == null) {
                return new ResponseEntity<>(visitService.findMyNotVisitedPlaces(visitEntity.getUserId()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(abc, HttpStatus.CONFLICT);
            }
        } catch (AuthenticationException e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(value = "/visit/deleteVisit/{visitId}/{userId}")
    public ResponseEntity deleteVisit(@PathVariable long visitId, @PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        try {
            String abc = visitService.deleteVisit(visitId, userId, httpHeaders);
            if (abc == null) {
                return new ResponseEntity<>(visitService.findMyNotVisitedPlaces(userId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(abc, HttpStatus.CONFLICT);
            }
        } catch (AuthenticationException e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value = "/visit/setAsVisited/{visitId}/{userId}")
    public ResponseEntity setVisitAsVisited(@PathVariable long visitId, @PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        try {
            String abc = visitService.selectPlaceAsVisited(httpHeaders, userId, visitId);
            if (abc == null) {
                return new ResponseEntity<>(visitService.findMyVisitedPlaces(userId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(abc, HttpStatus.CONFLICT);
            }
        } catch (AuthenticationException e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }


}
