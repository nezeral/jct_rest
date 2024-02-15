package com.example;

import com.example.models.Measure;
import com.example.repository.MeasureRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class MeasureServiceUnitTest {

    @Autowired
    private MeasureRepository measureService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        Pageable pageable = PageRequest.of(1, 1);
        Page<Measure> measures = measureService.getByLicensePlate("QPP263", pageable);
        assertEquals(measures.getTotalElements(), 1);
    }
}