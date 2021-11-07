package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CitizenController {

    @RequestMapping(value = "/centerid/{id}", method = RequestMethod.GET)
    ResponseEntity<List<Citizen>> getCitizensByCenterId(@PathVariable Integer id);

    @RequestMapping(value = "/getAllCitizens", method = RequestMethod.GET)
    ResponseEntity<List<Citizen>> getAllCitizens();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen);

    @RequestMapping(value = "/update/v1", method = RequestMethod.PUT)
    ResponseEntity<Citizen> addOrUpdateCitizen(@RequestBody Citizen citizen);

    @RequestMapping(value = "/update/v2/{id}", method = RequestMethod.PATCH)
    ResponseEntity<Citizen> patchCitizen(@PathVariable Integer id, @RequestBody Citizen citizen);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteCitizenById(@PathVariable("id") Integer citizenId);
}
