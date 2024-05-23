package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {

}