package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglementRepository extends JpaRepository<Reglement, Long> {

}
