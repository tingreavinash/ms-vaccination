package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import io.github.tingreavinash.microservice.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepo repo;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hello Citizen", HttpStatus.OK);
    }

    @RequestMapping(value = "/centerid/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
        List<Citizen> list = repo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Citizen> add(@RequestBody Citizen citizen){
        Citizen result = repo.save(citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
