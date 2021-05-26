package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.serice.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Qualifier("actorServiceImpl")
    @Autowired
    ActorService actorService;

    @RequestMapping(value = "/actor/findActorByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> getActorByName(@RequestParam("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Actor actor =this.actorService.findByName(name);

        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> getActor(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Actor actor = this.actorService.findById(id);

        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @RequestMapping(value = "/actor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
        HttpHeaders headers = new HttpHeaders();
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.actorService.save(actor);
        return new ResponseEntity<>(actor, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/actor/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> deleteActor(@PathVariable("id") Long id) {
        Actor actor =this.actorService.findById(id);

        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.actorService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/actors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.List<Actor>>getAllActors() {
        List<Actor> actors = this.actorService.findAll();

        if (actors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

}
