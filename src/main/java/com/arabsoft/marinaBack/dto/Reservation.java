package com.arabsoft.marinaBack.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservation")
public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reservation;


    private Date deb_sej;
    private Date fin_sej;
    private int num_jours;
    private int id_tarif;
    private int id_type_sej;
    private int id_emp;
    private int id_bat;
    private String nom_bat;
    private int id_cli;
    private String nom_cli;
}