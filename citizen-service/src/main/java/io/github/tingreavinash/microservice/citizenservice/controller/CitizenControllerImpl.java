package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.Exception.BusinessException;
import io.github.tingreavinash.microservice.citizenservice.Exception.ControllerException;
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
    public ResponseEntity<?> getCitizensByCenterId(@PathVariable Integer id) {
        try {
            List<Citizen> citizens = citizenService.getCitizenByVaccinationCenterId(id);
            return new ResponseEntity<List<Citizen>>(citizens, HttpStatus.OK);
        } catch (BusinessException ex) {
            ControllerException ce = new ControllerException(ex.getErrorCode(), ex.getDescription());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ControllerException ce = new ControllerException("201", "Something went wrong in controller - " + ex.getMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getAllCitizens() {
        try {
            List<Citizen> citizens = citizenService.getAllCitizens();
            return new ResponseEntity<>(citizens, HttpStatus.OK);
        } catch (BusinessException ex) {
            ControllerException ce = new ControllerException(ex.getErrorCode(), ex.getDescription());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ControllerException ce = new ControllerException("202", "Something went wrong in controller - " + ex.getMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> addCitizen(@RequestBody Citizen citizen) {
        Citizen result = citizenService.addCitizen(citizen); // Here we are not catching any exception, so it will be handled by global exception handler
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addOrUpdateCitizen(@RequestBody Citizen citizen) {
        try {
            Citizen result = citizenService.updateCitizen(citizen);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException ex) {
            ControllerException ce = new ControllerException(ex.getErrorCode(), ex.getDescription());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ControllerException ce = new ControllerException("204", "Something went wrong in controller - " + ex.getMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> patchCitizen(@PathVariable Integer id, @RequestBody Citizen citizen) {

        try {
            Citizen result = citizenService.patchCitizen(id, citizen);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException ex) {
            ControllerException ce = new ControllerException(ex.getErrorCode(), ex.getDescription());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ControllerException ce = new ControllerException("205", "Something went wrong in controller - " + ex.getMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteCitizenById(@PathVariable("id") Integer citizenId) {
        citizenService.deleteCitizenById(citizenId);
        return new ResponseEntity<>("Citizen record deleted with id " + citizenId, HttpStatus.ACCEPTED);
    }
}
