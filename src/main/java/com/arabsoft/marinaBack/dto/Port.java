package com.arabsoft.marinaBack.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Port implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_port;

    private String nom_port;
    private  String adr1_port;
    private  String adr2_port;
    private  String adr3_port;
    private  String tel_port;
    private  String fax_port;
    private  String email_port;
    private  String sigle_port;

}
