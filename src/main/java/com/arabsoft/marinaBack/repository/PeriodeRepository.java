package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodeRepository extends JpaRepository<Periode, Long> {

}