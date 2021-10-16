package com.avinash.microservice.vaccinationcenterservice.controller;

import com.avinash.microservice.vaccinationcenterservice.entity.VaccinationCenter;
import com.avinash.microservice.vaccinationcenterservice.model.Citizen;
import com.avinash.microservice.vaccinationcenterservice.model.RequiredResponse;
import com.avinash.microservice.vaccinationcenterservice.repository.CenterRepo;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable("id") Integer id){
        RequiredResponse response = new RequiredResponse();
        VaccinationCenter center = repo.findById(id).get();
        response.setVaccinationCenter(center);
        List<Citizen> citizens = new ArrayList<>();
        try{
            citizens = restTemplate.getForObject("http://localhost:8082/citizen/centerid/"+center.getId(), List.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        response.setCitizens(citizens);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
