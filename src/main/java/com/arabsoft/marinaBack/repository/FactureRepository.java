package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
