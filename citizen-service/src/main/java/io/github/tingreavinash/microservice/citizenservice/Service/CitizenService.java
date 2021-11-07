package io.github.tingreavinash.microservice.citizenservice.Service;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CitizenService {

    Citizen getCitizenById(Integer id);

    List<Citizen> getCitizenByVaccinationCenterId(Integer id);

    List<Citizen> getAllCitizens();

    Citizen updateCitizen(Citizen citizen);

    void deleteCitizenById(Integer id);

    Citizen addCitizen(Citizen citizen);

    Citizen patchCitizen(Integer id, Citizen citizen);


}
