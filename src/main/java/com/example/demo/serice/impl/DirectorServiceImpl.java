package com.example.demo.serice.impl;

import com.example.demo.entity.Director;
import com.example.demo.repo.DirectorRepo;
import com.example.demo.serice.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    @Override
    public Director findByExperience(String experience) {
        return directorRepo.findDirectorByExperience(experience);
    }

    @Override
    public void save(Director director) {
        directorRepo.save(director);
    }

    @Override
    public List<Director> findAll() {
        return directorRepo.findAll();
    }

    @Override
    public Director findById(Long id) {
        return directorRepo.findDirectorById(id);
    }

    @Override
    public void delete(Long id) {
        directorRepo.deleteById(id);
    }
}
