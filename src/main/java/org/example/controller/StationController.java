package org.example.controller;

import org.example.dto.StationDTO;
import org.example.model.Station;
import org.example.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<Station> create(@RequestBody StationDTO dto) {
        return new ResponseEntity<>(stationService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Station>> readAll() {
        return new ResponseEntity<>(stationService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Station> update(@RequestBody Station station) {
        return new ResponseEntity<>(stationService.update(station), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        stationService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<List<String>> getStationNamesByCode(@PathVariable String code) {
        return new ResponseEntity<>(stationService.getStationNameByCode(code), HttpStatus.OK);
    }
}
