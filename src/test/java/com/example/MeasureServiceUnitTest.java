package com.example;

import com.example.models.Measure;
import com.example.services.MeasureService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringBootTest
public class MeasureServiceUnitTest {

    @Autowired
    private MeasureService measureService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Measure> measures = measureService.list();
        assertEquals(measures.size(), 687);
    }
}