package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CitizenController {
    @GetMapping("/test")
    ResponseEntity<String> test();

    @RequestMapping(value = "/centerid/{id}", method = RequestMethod.GET)
    ResponseEntity<List<Citizen>> getById(@PathVariable Integer id);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ResponseEntity<Citizen> add(@RequestBody Citizen citizen);

    @RequestMapping(value = "/update/v1", method = RequestMethod.PUT)
    ResponseEntity<Citizen> update(@RequestBody Citizen citizen);

    @RequestMapping(value = "/update/v2/{id}", method = RequestMethod.PATCH)
    ResponseEntity<Citizen> patch(@PathVariable Integer id, @RequestBody Citizen citizen);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> update(@PathVariable("id") Integer citizenId);
}
