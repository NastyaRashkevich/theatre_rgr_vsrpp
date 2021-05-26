package com.example.demo.serice.impl;

import com.example.demo.entity.Actor;
import com.example.demo.repo.ActorRepo;
import com.example.demo.serice.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepo actorRepo;

    @Override
    public Actor findByName(String name) {
        return actorRepo.findActorByName(name);
    }

    @Override
    public void save(Actor actor) {
        actorRepo.save(actor);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepo.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepo.findActorById(id);
    }

    @Override
    public void delete(Long id) {
        actorRepo.deleteById(id);
    }
}
