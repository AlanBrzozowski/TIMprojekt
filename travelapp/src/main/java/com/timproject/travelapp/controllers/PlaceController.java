package com.timproject.travelapp.controllers;



        import com.timproject.travelapp.dao.entities.PlaceEntity;
        import com.timproject.travelapp.dto.PlaceDTO;
        import com.timproject.travelapp.managers.PlaceService;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }


    @GetMapping(value="travelapp/place/all")
    public ResponseEntity getAllPlaces() {
        return new ResponseEntity<>(placeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "travelapp/place/{id}")
    public ResponseEntity getPlaceById(@PathVariable long id) {
        PlaceDTO placeDTO = placeService.findById(id);
        return new ResponseEntity<>(placeDTO, HttpStatus.OK);
    }

    @PostMapping
    public void addPlace(@RequestBody PlaceEntity placeEntity) {
        placeService.save(placeEntity);
    }

    @PutMapping
    public void updatePlace(@RequestBody PlaceEntity placeEntity) {
        placeService.save(placeEntity);
    }

    @DeleteMapping
    public void deletePlace(@RequestParam Long id) {
        placeService.deleteById(id);
    }
}
