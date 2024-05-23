package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Bateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BateauRepository extends JpaRepository<Bateau, Long> {

}
