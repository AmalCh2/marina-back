package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.TypeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSejourRepository extends JpaRepository<TypeSejour, Long> {

}