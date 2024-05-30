package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Bateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BateauRepository extends JpaRepository<Bateau, Long> {
    @Query(value = "SELECT COUNT(*) FROM bateau WHERE id_port = :portId", nativeQuery = true)
int getTotalBateauDansPort(@Param("portId") long portId);
}
