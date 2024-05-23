package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.TarifForfait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifForfaitRepository extends JpaRepository<TarifForfait, Long> {

}
