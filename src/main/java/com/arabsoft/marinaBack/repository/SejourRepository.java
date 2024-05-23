package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SejourRepository extends JpaRepository<Sejour, Long> {

}
