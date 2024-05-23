package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Consommation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsommationRepository extends JpaRepository<Consommation, Long> {

}
