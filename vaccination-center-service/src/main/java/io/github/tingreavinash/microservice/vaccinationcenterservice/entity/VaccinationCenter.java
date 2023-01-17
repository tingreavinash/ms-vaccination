package io.github.tingreavinash.microservice.vaccinationcenterservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCenter {

    @Id
    private int id;

    @Column
    private String centerName;

    @Column
    private String centerAddress;


}
