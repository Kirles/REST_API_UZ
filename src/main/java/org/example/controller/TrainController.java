package org.example.controller;

import org.example.dto.TrainDTO;
import org.example.model.Train;
import org.example.service.TrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    public ResponseEntity<Train> create(@RequestBody TrainDTO dto) {
        return new ResponseEntity<>(trainService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Train>> readAll() {
        return new ResponseEntity<>(trainService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Train> update(@RequestBody Train train) {
        return new ResponseEntity<>(trainService.update(train), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        trainService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/code/{number}")
    public ResponseEntity<List<Train>> findByNumber(@PathVariable String number) {
        return new ResponseEntity<>(trainService.findByNumber(number), HttpStatus.OK);
    }
}
