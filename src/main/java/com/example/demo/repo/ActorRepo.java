package com.example.demo.repo;

import com.example.demo.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "actor", path = "actor")
public interface ActorRepo extends JpaRepository<Actor, Long> {

    Actor findActorById(Long id);

    Actor findActorByName(String name);

}
