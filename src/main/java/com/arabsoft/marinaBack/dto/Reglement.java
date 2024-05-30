package com.arabsoft.marinaBack.dto;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Reglement")
public class Reglement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_regle;
    private float mnt_regle;
    private String type_regl;
    private Date date_regl;


    @ManyToOne
    @JoinColumn(name = "id_fact", nullable = false)
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "id_carte", nullable = false)
    private Carte carte;


}
