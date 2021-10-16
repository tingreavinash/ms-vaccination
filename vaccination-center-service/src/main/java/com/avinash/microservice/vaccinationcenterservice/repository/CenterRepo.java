package com.avinash.microservice.vaccinationcenterservice.repository;

import com.avinash.microservice.vaccinationcenterservice.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
