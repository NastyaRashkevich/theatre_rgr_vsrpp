package com.example.demo.serice;

import com.example.demo.entity.Director;
import com.example.demo.entity.Performance;

public interface PerformanceService extends IService<Performance>{

    Performance findByDate (String date);
    Performance findByName(String name);

}
