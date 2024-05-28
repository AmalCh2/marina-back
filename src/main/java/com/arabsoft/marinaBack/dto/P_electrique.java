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
@Table(name = "P_electrique")
public class P_electrique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_p_elec;

    private String designation;
}
