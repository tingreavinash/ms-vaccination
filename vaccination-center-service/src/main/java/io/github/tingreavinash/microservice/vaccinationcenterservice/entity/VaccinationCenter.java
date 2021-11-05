package io.github.tingreavinash.microservice.vaccinationcenterservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.persistence.*;

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
