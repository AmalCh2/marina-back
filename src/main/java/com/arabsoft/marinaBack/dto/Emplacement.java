package com.arabsoft.marinaBack.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Emplacement")
public class Emplacement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emp;

    private float largeur_emp;
    private float longueur_emp;
    private float tirant_eau_emp;
    private String tel_port;
    private String direction_emp;
    private String type_cord_emp;
    private String commentaire;
    private int nbr_mouillage_emp;
    private int rang;
    private boolean blockage;

    private int id_pelectrique;
    private int id_quai;
    private String desig_quai;
    private int rang_quai;

}
