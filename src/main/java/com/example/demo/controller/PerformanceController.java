package com.example.demo.controller;

import com.example.demo.entity.Performance;
import com.example.demo.serice.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerformanceController {

    @Qualifier("performanceServiceImpl")
    @Autowired
    PerformanceService performanceService;

    @RequestMapping(value = "/performance/findPerformanceByDate",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Performance> getPerformanceByDate(@RequestParam("date") String date) {
        if (date == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Performance performance = this.performanceService.findByDate(date);

        if (performance == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(performance, HttpStatus.OK);
    }

    @RequestMapping(value = "/performance/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Performance> getPerformance(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Performance performance = this.performanceService.findById(id);

        if (performance == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(performance, HttpStatus.OK);
    }

    @RequestMapping(value = "/performance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Performance> addPerformance(@RequestBody Performance performance) {
        HttpHeaders headers = new HttpHeaders();
        if (performance == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.performanceService.save(performance);
        return new ResponseEntity<>(performance, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/performance/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Performance> deletePerformance(@PathVariable("id") Long id) {
        Performance performance = this.performanceService.findById(id);

        if (performance == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.performanceService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/performances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Performance>>getAllPerformances() {
        List<Performance> performances = this.performanceService.findAll();

        if (performances.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(performances, HttpStatus.OK);
    }

}
