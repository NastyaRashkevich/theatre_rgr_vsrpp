package com.example.demo.serice.impl;

import com.example.demo.entity.Repetition;
import com.example.demo.repo.RepetitionRepo;
import com.example.demo.serice.RepetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepetitionServiceImpl implements RepetitionService {
    @Autowired
    RepetitionRepo repetitionRepo;

    @Override
    public Repetition findByPlace(String place) {
        return repetitionRepo.findRepetitionByPlace(place);
    }

    @Override
    public void save(Repetition repetition) {
        repetitionRepo.save(repetition);
    }

    @Override
    public List<Repetition> findAll() {
        return repetitionRepo.findAll();
    }

    @Override
    public Repetition findById(Long id) {
        return repetitionRepo.findRepetitionById(id);
    }

    @Override
    public void delete(Long id) {
        repetitionRepo.deleteById(id);
    }
}
