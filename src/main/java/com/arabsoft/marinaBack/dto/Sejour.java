package com.arabsoft.marinaBack.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
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
@Table(name = "Sejour")
public class Sejour implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sej;


    private Date deb_sej;
    private Date fin_sej;
    private int num_jours;
    private int archived;


    @ManyToOne
    @JoinColumn(name = "id_tarif", nullable = false)
    private Tarif tarif;

    @ManyToOne
    @JoinColumn(name = "id_type_sej", nullable = false)
    private TypeSejour type_sej;

    @ManyToOne
    @JoinColumn(name = "id_emp", nullable = false)
    private Emplacement emp;

    @ManyToOne
    @JoinColumn(name = "id_bat", nullable = false)
    private Bateau bat;




}