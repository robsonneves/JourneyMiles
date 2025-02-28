package com.journeymiles.controller;

import com.journeymiles.entity.TestimonyEntity;
import com.journeymiles.service.PersistenceException;
import com.journeymiles.service.TestimonyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestimonyController {

    private final TestimonyService testimonyService;

    public TestimonyController(TestimonyService testimonyService) {
        this.testimonyService = testimonyService;
    }

    @PostMapping("/testimony")
    public ResponseEntity<TestimonyEntity> create(@RequestBody TestimonyEntity testimonyEntity) throws PersistenceException {
        return ResponseEntity.ok(testimonyService.save(testimonyEntity));
    }

    @GetMapping("/testimony")
    public ResponseEntity<List<TestimonyEntity>> read() throws PersistenceException {
        return ResponseEntity.ok(testimonyService.findAll());
    }

    @GetMapping("/testimony/{id}")
    public ResponseEntity<TestimonyEntity> read(@PathVariable("id") Long id) throws PersistenceException {
        return ResponseEntity.ok(testimonyService.findById(id).get());
    }

    @PutMapping("/testimony")
    public ResponseEntity<TestimonyEntity> update(@RequestBody TestimonyEntity testimonyEntity) throws PersistenceException {
        return ResponseEntity.ok(testimonyService.update(testimonyEntity));
    }

    @GetMapping("/testimony/random")
    public ResponseEntity<List<TestimonyEntity>> readRandom() throws PersistenceException {
        return ResponseEntity.ok(testimonyService.findRandomTestimony());
    }

    @DeleteMapping("/testimony/{id}")
    public void delete(@PathVariable("id") Long id) throws PersistenceException {
        testimonyService.delete(id);
        ResponseEntity.ok();
    }
}
