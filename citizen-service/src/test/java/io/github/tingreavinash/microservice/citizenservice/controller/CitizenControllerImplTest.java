package io.github.tingreavinash.microservice.citizenservice.controller;

import io.github.tingreavinash.microservice.citizenservice.Service.CitizenService;
import io.github.tingreavinash.microservice.citizenservice.Service.CitizenServiceImpl;
import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CitizenControllerImplTest {

    @InjectMocks
    CitizenControllerImpl citizenController;

    @Mock
    CitizenService citizenService;

    public static Citizen getDummyCitizen() {
        Citizen citizen = new Citizen();
        citizen.setId(1);
        citizen.setName("Avinash");
        citizen.setVaccinationCenterId(100);

        return citizen;
    }

    public static List<Citizen> getListOfCitizens() {
        List<Citizen> listOfCitizens = new ArrayList<>();
        listOfCitizens.add(getDummyCitizen());
        return listOfCitizens;
    }

    @BeforeEach
    public void createMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCitizensByCenterIdTest() {
        List<Citizen> listOfDummyCitizens = getListOfCitizens();
        Mockito.when(citizenService.getCitizenByVaccinationCenterId(100)).thenReturn(listOfDummyCitizens);
        assertEquals(new ResponseEntity<>(listOfDummyCitizens, HttpStatus.OK),
                citizenController.getCitizensByCenterId(100));

        verify(citizenService, Mockito.times(1)).getCitizenByVaccinationCenterId(100);
    }

}
