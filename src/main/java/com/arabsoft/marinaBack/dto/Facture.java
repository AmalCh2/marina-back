package com.arabsoft.marinaBack.dto;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Facture")
public class Facture implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fact;

    private Date date_fact;
    private String etat_fact;
    private String etat_paiement;
    private float montant_ttl;
    private String lib_exo;
    private boolean exo_cli;
    private String tbre_fiscale;
    private String lib_carte;
    private int cpt_carte;


}
