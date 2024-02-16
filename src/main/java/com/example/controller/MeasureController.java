package com.example.controller;

import com.example.models.Measure;
import com.example.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measure")
public class MeasureController {

    @Autowired
    private MeasureRepository measureRepository;

    @GetMapping(value = "/{licensePlate}")
    public ResponseEntity<String> getMeasureByLicensePlate(@PathVariable("licensePlate") String licensePlate) {
        Measure plateMeasure = measureRepository.findByLicensePlate(licensePlate);
        if (plateMeasure == null) {
            return new ResponseEntity<>("Nothing found", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Found : " + plateMeasure, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<String> addMeasure(@RequestBody Measure measure) {
        try {
            Measure savedMeasure = measureRepository.save(measure);
            return new ResponseEntity<>("Measure created with ID: " + savedMeasure.getId(), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Failed to create measure: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
