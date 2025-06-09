package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.TripDTO;
import org.example.model.Trip;
import org.example.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity<Trip> create(@Valid @RequestBody TripDTO dto) {
        return new ResponseEntity<>(tripService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> readAll() {
        return new ResponseEntity<>(tripService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Trip> update(@RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.update(trip), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        tripService.delete(id);
        return HttpStatus.OK;
    }

}
