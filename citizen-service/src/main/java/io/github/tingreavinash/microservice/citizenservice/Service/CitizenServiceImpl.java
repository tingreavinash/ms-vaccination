package io.github.tingreavinash.microservice.citizenservice.Service;

import io.github.tingreavinash.microservice.citizenservice.Exception.BusinessException;
import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import io.github.tingreavinash.microservice.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class CitizenServiceImpl implements CitizenService {
    @Autowired
    CitizenRepo citizenRepo;

    @Override
    public Citizen getCitizenById(Integer id) {
        try {
            return citizenRepo.findById(id).get();
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("101", "The id that you requested is invalid - "+ex.getMessage());
        } catch (NoSuchElementException ex) {
            throw new BusinessException("102", "No such element found - "+ex.getMessage());
        }
    }

    @Override
    public List<Citizen> getCitizenByVaccinationCenterId(Integer id) {
        try {
            return citizenRepo.findByVaccinationCenterId(id);
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("103", "The id that you requested is invalid - "+ex.getMessage());
        }
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepo.findAll();
    }

    @Override
    public Citizen updateCitizen(Citizen citizen) {

        try {
            return citizenRepo.save(citizen);
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("104", "The entity that you passed is invalid - "+ex.getMessage());
        }
    }

    @Override
    public Citizen patchCitizen(Integer id, Citizen citizen) {

        try {
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
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("105", "The id/entity that you passed is invalid - "+ex.getMessage());
        } catch (NoSuchElementException ex) {
            throw new BusinessException("106", "No such element found - "+ex.getMessage());
        }

        return null;
    }

    @Override
    public void deleteCitizenById(Integer id) {
        try {
            citizenRepo.deleteById(id);
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("107", "The id/entity that you passed is invalid - "+ex.getMessage());
        }
    }

    @Override
    public Citizen addCitizen(Citizen citizen) {
        try {
            return citizenRepo.save(citizen);
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("108", "The id/entity that you passed is invalid - "+ex.getMessage());
        }
    }


}
