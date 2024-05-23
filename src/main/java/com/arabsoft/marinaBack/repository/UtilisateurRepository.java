package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT u.mot_de_passe FROM Utilisateur u WHERE u.id = :id_utilisateur")
    String findPasswordById(@Param("id_utilisateur") long id_utilisateur);
}
