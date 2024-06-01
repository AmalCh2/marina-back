package com.arabsoft.marinaBack.dto;

import java.io.Serializable;

import jakarta.persistence.*;
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
@Table(name = "Client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cli;
    private String nom_cli;
    private String prenom_cli;
    private String etat_civil;
    private String adresse_cli;
    private String ville_cli;
    private String tel_cli;
    private String fax_cli;
    private String mobile_cli;
    private String email_cli;
    private boolean exo_cli;
    private int archived;
    private int code_postal_cliii;

    @ManyToOne
    @JoinColumn(name = "id_pays", nullable = false)
    private Pays pays;



}