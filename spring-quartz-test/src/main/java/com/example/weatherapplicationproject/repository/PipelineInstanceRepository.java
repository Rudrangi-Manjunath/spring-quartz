package com.example.weatherapplicationproject.repository;

import com.example.weatherapplicationproject.entity.PipelineInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipelineInstanceRepository extends JpaRepository<PipelineInstance, Long> {
    Iterable<PipelineInstance> findByQuartzScheduleNotNullAndIsActiveTrue();
}
