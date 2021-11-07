package io.github.tingreavinash.microservice.citizenservice.repository;

import io.github.tingreavinash.microservice.citizenservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

    List<Citizen> findByVaccinationCenterId(Integer id);
}
