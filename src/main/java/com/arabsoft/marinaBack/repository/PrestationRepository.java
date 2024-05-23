package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {

}
