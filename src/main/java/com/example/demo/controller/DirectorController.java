package com.example.demo.controller;

import com.example.demo.entity.Director;
import com.example.demo.serice.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {

    @Qualifier("directorServiceImpl")
    @Autowired
    DirectorService directorService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> getDirectorByExperience(@RequestParam("experience") String experience) {
        if (experience == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Director director = this.directorService.findByExperience(experience);

        if (director == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @RequestMapping(value = "/director/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> getDirector(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Director director = this.directorService.findById(id);

        if (director == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @RequestMapping(value = "/director", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        HttpHeaders headers = new HttpHeaders();
        if (director == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.directorService.save(director);
        return new ResponseEntity<>(director, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/director/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> deleteDirector(@PathVariable("id") Long id) {
        Director director = this.directorService.findById(id);

        if (director == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.directorService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/directors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Director>>getAllDirectors() {
        List<Director> directors = this.directorService.findAll();

        if (directors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

}
