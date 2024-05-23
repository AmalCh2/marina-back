package com.arabsoft.marinaBack.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.PrePersist;
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
@Table(name = "Consommation")
public class Consommation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cons;

    private float prix_unit;
    private int qte;
    private Date deb_cons;
    private Date fin_cons;
    private Date date_sys;
    private String offre;
    private int num_reçu;

    @PrePersist
    protected void onCreate() {
        date_sys = new Date();
    }

}
