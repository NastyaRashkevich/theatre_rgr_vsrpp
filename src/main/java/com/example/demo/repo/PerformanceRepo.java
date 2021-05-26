package com.example.demo.repo;

import com.example.demo.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<Performance, Long> {

    Performance findPerformanceById (Long id);

    Performance findPerformanceByDate (String date);
}
