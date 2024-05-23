package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureRepository extends JpaRepository<Nature, Long> {

}
