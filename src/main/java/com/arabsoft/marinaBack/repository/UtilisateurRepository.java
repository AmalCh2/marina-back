package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT u.mot_de_passe FROM Utilisateur u WHERE u.id_utilisateur = :id_utilisateur")
    String getuserPasswordById(@Param("id_utilisateur") long id_utilisateur);

    @Query("SELECT u.id_utilisateur FROM Utilisateur u WHERE u.nom_utilisateur = :username")
    Long getUseridByUsername(@Param("username") String username);
}
