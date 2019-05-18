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


}
