package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Quai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuaiRepository extends JpaRepository<Quai, Long>{
}
