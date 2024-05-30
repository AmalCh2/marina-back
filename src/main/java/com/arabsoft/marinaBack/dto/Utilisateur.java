package com.arabsoft.marinaBack.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;

    private String nom_utilisateur;
    private String mot_de_passe;

    private Long id_port;




    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role Role;


}
