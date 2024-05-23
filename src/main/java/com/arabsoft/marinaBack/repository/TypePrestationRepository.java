

package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.TypePrestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePrestationRepository extends JpaRepository<TypePrestation, Long> {

}
