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
@Table(name = "TypeSejour")
public class TypeSejour implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_sej;

    private String lib_sej;
    private Boolean loc_sej;
    private String titulaire_sej;
    private Boolean sej_annuel;
    private float sej_majoration;

}
