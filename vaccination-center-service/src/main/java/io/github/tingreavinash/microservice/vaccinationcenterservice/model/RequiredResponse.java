package io.github.tingreavinash.microservice.vaccinationcenterservice.model;

import io.github.tingreavinash.microservice.vaccinationcenterservice.entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;
}
