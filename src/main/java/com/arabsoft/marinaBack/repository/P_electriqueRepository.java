package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.P_electrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface P_electriqueRepository extends JpaRepository<P_electrique, Long>{
}
