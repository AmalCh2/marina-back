package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
