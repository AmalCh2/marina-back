package com.arabsoft.marinaBack.dto;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
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




    @ManyToOne
    @JoinColumn(name = "id_fact", nullable = false)
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "id_prest", nullable = false)
    private Prestation prestation;

    @ManyToOne
    @JoinColumn(name = "id_sej", nullable = false)
    private Sejour sejour;



    @PrePersist
    protected void onCreate() {
        date_sys = new Date();
    }
}