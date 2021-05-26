package com.example.demo.serice.impl;

import com.example.demo.entity.Performance;
import com.example.demo.repo.PerformanceRepo;
import com.example.demo.serice.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    PerformanceRepo performanceRepo;

    @Override
    public Performance findByDate(String date) {
        return performanceRepo.findPerformanceByDate(date);
    }

    @Override
    public void save(Performance performance) {
        performanceRepo.save(performance);
    }

    @Override
    public List<Performance> findAll() {
        return performanceRepo.findAll();
    }

    @Override
    public Performance findById(Long id) {
        return performanceRepo.findPerformanceById(id);
    }

    @Override
    public void delete(Long id) {
        performanceRepo.deleteById(id);
    }
}
