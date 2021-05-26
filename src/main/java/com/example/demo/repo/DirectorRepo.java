package com.example.demo.repo;

import com.example.demo.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "director", path = "director")
public interface DirectorRepo extends JpaRepository<Director, Long> {

    Director findDirectorById(Long id);

    Director findDirectorByExperience(String experience);
}
