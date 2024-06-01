package com.arabsoft.marinaBack.dto;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private String direction_emp;
    private String type_cord_emp;
    private String commentaire;
    private int nbr_mouillage_emp;
    private int rang;
    private boolean blockage;

    @ManyToOne
    @JoinColumn(name = "id_pelectrique", nullable = false)
    private P_electrique p_electrique;

    @ManyToOne
    @JoinColumn(name = "id_quai", nullable = false)
    private Quai quai;



}
