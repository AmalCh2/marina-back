package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Long>{
}
