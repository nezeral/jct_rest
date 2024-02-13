package com.example.services;

import com.example.models.Measure;
import com.example.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureService {

    @Autowired
    private MeasureRepository measureRepository;

    public List<Measure> list() {
        return measureRepository.findAll();
    }
}
