package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import io.github.tingreavinash.microservice.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
public class CitizenControllerImpl implements CitizenController {

    @Autowired
    private CitizenRepo repo;

    @Override
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hello Citizen", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
        List<Citizen> list = repo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> add(@RequestBody Citizen citizen){
        Citizen result = repo.save(citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> update(@RequestBody Citizen citizen){
        Citizen result = repo.save(citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> patch(@PathVariable Integer id, @RequestBody Citizen citizen){
        Optional<Citizen> result = repo.findById(id);

        if(result.isPresent()){
            Citizen updatedCitizen = result.get();
            boolean needsUpdate = false;
            if(StringUtils.hasLength(citizen.getName())){
                updatedCitizen.setName(citizen.getName());
                needsUpdate = true;
            }

            if(citizen.getVaccinationCenterId() > 0){
                updatedCitizen.setVaccinationCenterId(citizen.getVaccinationCenterId());
                needsUpdate = true;
            }

            if(needsUpdate){
                repo.save(updatedCitizen);
                return new ResponseEntity<>(updatedCitizen, HttpStatus.OK);
            }

        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> update(@PathVariable("id") Integer citizenId){
        try{
            repo.deleteById(citizenId);
            return new ResponseEntity<>("Citizen record deleted with id "+citizenId, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>("Record not found.", HttpStatus.NOT_FOUND);
        }

    }
}
