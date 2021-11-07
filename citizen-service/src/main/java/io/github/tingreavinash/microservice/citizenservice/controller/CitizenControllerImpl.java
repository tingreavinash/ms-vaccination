package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.Service.CitizenService;
import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenControllerImpl implements CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Override
    public ResponseEntity<List<Citizen>> getCitizensByCenterId(@PathVariable Integer id) {
        List<Citizen> citizens = citizenService.getCitizenByVaccinationCenterId(id);
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        List<Citizen> citizens = citizenService.getAllCitizens();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        Citizen result = citizenService.addCitizen(citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> addOrUpdateCitizen(@RequestBody Citizen citizen) {
        Citizen result = citizenService.updateCitizen(citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Citizen> patchCitizen(@PathVariable Integer id, @RequestBody Citizen citizen) {
        Citizen result = citizenService.patchCitizen(id, citizen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCitizenById(@PathVariable("id") Integer citizenId) {
        citizenService.deleteCitizenById(citizenId);
        return new ResponseEntity<>("Citizen record deleted with id " + citizenId, HttpStatus.ACCEPTED);

    }
}
