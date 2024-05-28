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
@Table(name = "Bateau")
public class Bateau implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_bat;

    private String immatriculation_bat;
    private String autre_ident_nom_bat;
    private String nom_bat;
    private float largeur_bat;
    private float longueur_bat;
    private float tirant_eau_bat;
    private float tonnage_bat;
    private String pavillon_bat;
    private String marque_bat;
    private int num_assur;
    private String nom_assur;
    private Date date_exp;
    private String adresse_bat;
    private int code_postal_bat;
    private String ville_bat;
    private String pays;
    private String tel_bat;
    private String fax_bat;
    private String mobile_bat;
    private String email_bat;
    private String observation;
    private Date date_mvt;
    private Date depart_mvt;
    private Date arrivee_mvt;

    private int id_type_bat;
    private int id_cli;
    private int id_port;

}
