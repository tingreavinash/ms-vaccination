package io.github.tingreavinash.microservice.vaccinationcenterservice.repository;

import io.github.tingreavinash.microservice.vaccinationcenterservice.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
