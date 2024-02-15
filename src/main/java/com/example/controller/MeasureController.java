package com.example.controller;

import com.example.models.Measure;
import com.example.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measure")
public class MeasureController {

    @Autowired
    private MeasureRepository measureRepository;

    @GetMapping(value = "/{licensePlate}")
    public Page<Measure> getMeasureByLicensePlate(
            @PathVariable("licensePlate") String licensePlate,
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return measureRepository.findByLicensePlate(licensePlate, pageable);
    }

    @PutMapping
    public ResponseEntity<Measure> addMeasure(@RequestBody Measure measure) {
        Measure savedMeasure = measureRepository.save(measure);
        return new ResponseEntity<>(savedMeasure, HttpStatus.CREATED);
    }

}
