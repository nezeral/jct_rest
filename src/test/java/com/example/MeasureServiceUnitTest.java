package com.example;

import com.example.controller.MeasureController;
import com.example.models.Measure;
import com.example.repository.MeasureRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
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
        long nMeasures = measureRepository.count();
        assertEquals(nMeasures, 687);
    }

    @Test
    public void measureFindByLicensePlate() {
        Measure plateMeasures = measureRepository.findByLicensePlate("QPP263");
        assertEquals(plateMeasures.getLicensePlate(), "QPP263");
    }

/*    @Test
    public void saveMeasure() {
        Measure measure = new Measure();
        ResponseEntity<Measure> response = measureController.addMeasure(measure);
        // assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertTrue(true);
    }*/
}