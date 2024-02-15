package com.example.repository;

import com.example.models.Measure;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MeasureRepository extends CrudRepository<Measure, Long>, JpaSpecificationExecutor<Measure> {

    /**
     * Returns a page of {@link Measure}s with the given licensePlate.
     *
     * @param licensePlate
     * @return
     */
    Measure findByLicensePlate(String licensePlate);
}
