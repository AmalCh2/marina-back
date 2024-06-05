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
@Table(name = "Prestation")
public class Prestation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prest;

    private String lib_prest;
    private float prix_unit_prest;
    private String secteur_prest;
    private int rang_prest;

    @ManyToOne
    @JoinColumn(name = "id_tva", nullable = false)
    private Tva tva;

    @ManyToOne
    @JoinColumn(name = "id_type_prest", nullable = false)
    private TypePrestation type_prest;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Nature nature;

}