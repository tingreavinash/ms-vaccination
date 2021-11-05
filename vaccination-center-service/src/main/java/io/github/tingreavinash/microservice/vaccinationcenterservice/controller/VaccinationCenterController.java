package io.github.tingreavinash.microservice.vaccinationcenterservice.controller;

import io.github.tingreavinash.microservice.vaccinationcenterservice.entity.VaccinationCenter;
import io.github.tingreavinash.microservice.vaccinationcenterservice.model.Citizen;
import io.github.tingreavinash.microservice.vaccinationcenterservice.model.RequiredResponse;
import io.github.tingreavinash.microservice.vaccinationcenterservice.repository.CenterRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private CenterRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        VaccinationCenter result = repo.save(vaccinationCenter);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "handleCitizenDowntime")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable("id") Integer id){
        RequiredResponse response = new RequiredResponse();
        VaccinationCenter center = repo.findById(id).get();
        response.setVaccinationCenter(center);

        List<Citizen> citizens = citizens = restTemplate.getForObject("http://citizen-service/citizen/centerid/"+center.getId(), List.class);
        response.setCitizens(citizens);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<RequiredResponse> handleCitizenDowntime(@PathVariable("id") Integer id){
        RequiredResponse response = new RequiredResponse();
        VaccinationCenter center = repo.findById(id).get();
        response.setVaccinationCenter(center);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
