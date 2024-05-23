package com.arabsoft.marinaBack.dto;

import java.io.Serializable;

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
@Table(name = "TypePrestation")
public class TypePrestation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_prest;

    private String lib_type_prest;
    private int rang_type_prest;
}
