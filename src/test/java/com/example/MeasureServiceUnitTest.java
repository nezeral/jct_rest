package com.example;

import com.example.controller.MeasureController;
import com.example.models.Measure;
import com.example.repository.MeasureRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class MeasureServiceUnitTest {

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private MeasureController measureController;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        Pageable pageable = PageRequest.of(1, 1);
        long nMeasures = measureRepository.count();
        assertEquals(nMeasures, 687);
    }

    @Test
    public void findMeasuresByLicensePlate() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<Measure> plateMeasures = measureRepository.findByLicensePlate("QPP263", pageable);
        assertEquals(plateMeasures.getTotalElements(), 1);
        assertFalse(plateMeasures.isEmpty());
    }

    @Test
    public void saveMeasure() {
        Measure measure = new Measure();
        ResponseEntity<Measure> response = measureController.addMeasure(measure);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }
}