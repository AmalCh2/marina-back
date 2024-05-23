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
@Table(name = "Tarif")
public class Tarif implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tarif;

    private int annee;
    private int jour_hs;
    private int jour_ms;
    private int jour_bs;
    private int mois_hs;
    private int mois_ms;
    private int mois_bs;
    private String type_tarif;
    private float largeur_bat;
    private float longueur_bat;
    private float tarif_hivernage;
    private float tarif_annuel;


}

