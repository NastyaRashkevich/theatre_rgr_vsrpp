package com.example.demo.serice;

import com.example.demo.entity.Actor;

public interface ActorService extends IService<Actor> {

    Actor findByName(String name);
}
