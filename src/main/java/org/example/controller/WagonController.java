package org.example.controller;

import org.example.dto.WagonDTO;
import org.example.model.Wagon;
import org.example.service.WagonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wagon")
public class WagonController {

    private final WagonService wagonService;

    public WagonController(WagonService wagonService) {
        this.wagonService = wagonService;
    }

    @PostMapping
    public ResponseEntity<Wagon> create(@RequestBody WagonDTO dto) {
        return new ResponseEntity<>(wagonService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Wagon>> readAll() {
        return new ResponseEntity<>(wagonService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Wagon> update(@RequestBody Wagon wagon) {
        return new ResponseEntity<>(wagonService.update(wagon), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        wagonService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/wagon_number/{number}")
    public ResponseEntity<List<Wagon>> findByWagonNumber(@PathVariable String wagonNumber) {
        return new ResponseEntity<>(wagonService.findByNumber(wagonNumber), HttpStatus.OK);
    }
}

