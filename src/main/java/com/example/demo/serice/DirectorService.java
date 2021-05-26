package com.example.demo.serice;

import com.example.demo.entity.Director;

public interface DirectorService extends IService<Director>{

    Director findByExperience (String experience);
}
