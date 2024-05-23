package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.TypeBateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBateauRepository extends JpaRepository<TypeBateau, Long> {

}
