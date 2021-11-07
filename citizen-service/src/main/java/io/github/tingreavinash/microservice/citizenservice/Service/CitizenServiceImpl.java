package io.github.tingreavinash.microservice.citizenservice.Service;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import io.github.tingreavinash.microservice.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Component
public class CitizenServiceImpl implements CitizenService {
    @Autowired
    CitizenRepo citizenRepo;

    @Override
    public Citizen getCitizenById(Integer id) {
        Optional<Citizen> citizen = citizenRepo.findById(id);
        return citizen.orElse(null);
    }

    @Override
    public List<Citizen> getCitizenByVaccinationCenterId(Integer id) {
        return citizenRepo.findByVaccinationCenterId(id);
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepo.findAll();
    }

    @Override
    public Citizen updateCitizen(Citizen citizen) {
        return citizenRepo.save(citizen);
    }

    @Override
    public Citizen patchCitizen(Integer id, Citizen citizen) {
        Optional<Citizen> result = citizenRepo.findById(id);

        if (result.isPresent()) {
            Citizen updatedCitizen = result.get();
            boolean needsUpdate = false;
            if (StringUtils.hasLength(citizen.getName())) {
                updatedCitizen.setName(citizen.getName());
                needsUpdate = true;
            }

            if (citizen.getVaccinationCenterId() > 0) {
                updatedCitizen.setVaccinationCenterId(citizen.getVaccinationCenterId());
                needsUpdate = true;
            }

            if (needsUpdate) {
                return citizenRepo.save(updatedCitizen);
            }

        }

        return null;

    }

    @Override
    public void deleteCitizenById(Integer id) {
        citizenRepo.deleteById(id);
    }

    @Override
    public Citizen addCitizen(Citizen citizen) {
        return citizenRepo.save(citizen);
    }


}
