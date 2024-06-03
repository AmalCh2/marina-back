package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SejourRepository extends JpaRepository<Sejour, Long> {
    @Query(value = "SELECT * FROM sejour WHERE archived = 0", nativeQuery = true)
    List<Sejour> afficher_sejour();

    @Query(value = "SELECT * FROM sejour WHERE archived = 1", nativeQuery = true)
    List<Sejour> afficher_archived_sejour();
}
