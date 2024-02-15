package com.example.controller;

import com.example.models.Measure;
import com.example.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return measureRepository.getByLicensePlate(licensePlate, pageable);
    }

}
