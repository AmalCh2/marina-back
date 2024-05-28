package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {

}
