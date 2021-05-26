package com.example.demo.controller;

import com.example.demo.entity.Repetition;
import com.example.demo.serice.RepetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepetitionController {

    @Qualifier("repetitionServiceImpl")
    @Autowired
    RepetitionService repetitionService;

    @RequestMapping(value = "/repetition/findRepetitionByPlace",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Repetition> getRepetitionByStage(@RequestParam("place") String place) {
        if (place == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Repetition repetition = this.repetitionService.findByPlace(place);

        if (repetition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(repetition, HttpStatus.OK);
    }

    @RequestMapping(value = "/repetition/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Repetition> getRepetition(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Repetition repetition = this.repetitionService.findById(id);

        if (repetition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(repetition, HttpStatus.OK);
    }

    @RequestMapping(value = "/repetition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Repetition> addRepetition(@RequestBody Repetition repetition) {
        HttpHeaders headers = new HttpHeaders();
        if (repetition == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.repetitionService.save(repetition);
        return new ResponseEntity<>(repetition, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/repetition/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Repetition> deleteRepetition(@PathVariable("id") Long id) {
        Repetition repetition = this.repetitionService.findById(id);

        if (repetition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.repetitionService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/repetitions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Repetition>>getAllRepetitions() {
        List<Repetition> repetitions = this.repetitionService.findAll();

        if (repetitions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(repetitions, HttpStatus.OK);
    }

}
