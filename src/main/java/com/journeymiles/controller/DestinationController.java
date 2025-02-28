package com.journeymiles.controller;

import com.journeymiles.entity.DestinationEntity;
import com.journeymiles.service.DestinationService;
import com.journeymiles.service.PersistenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/destination")
    public ResponseEntity<DestinationEntity> create(@RequestBody DestinationEntity destinationEntity) throws PersistenceException {
        return ResponseEntity.ok(destinationService.save(destinationEntity));
    }

    @GetMapping("/destinationAll")
    public ResponseEntity<List<DestinationEntity>> read() throws PersistenceException {
        return ResponseEntity.ok(destinationService.findAll());
    }

    @GetMapping("/destination")
    public ResponseEntity read(@RequestParam("name") String name) throws PersistenceException {

        List<DestinationEntity> list = destinationService.findByNameContains(name);
        return ResponseEntity.ok( list.isEmpty() ? "No destinations found!" : list);
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<DestinationEntity> read(@PathVariable("id") Long id) throws PersistenceException {
        return ResponseEntity.ok(destinationService.findById(id).get());
    }

    @PutMapping("/destination")
    public ResponseEntity<DestinationEntity> update(@RequestBody DestinationEntity destinationEntity) throws PersistenceException {
        DestinationEntity destinationEntityResult = destinationService.update(destinationEntity);
        return ResponseEntity.ok(destinationEntityResult);
    }

    @DeleteMapping("/destination/{id}")
    public void delete(@PathVariable("id") Long id) throws PersistenceException {
        destinationService.delete(id);
        ResponseEntity.ok();
    }
}
