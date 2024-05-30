package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Reservation;
import com.arabsoft.marinaBack.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        System.out.println("getReservationById result : " + reservation);
        return reservation;
    }

    public Reservation addReservation(Reservation reservation) {
        Reservation reservationCreated = reservationRepository.save(reservation);
        return reservationCreated;
    }

    public void deleteReservationByEmail(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {

        Reservation oldReservationFound;

        Optional<Reservation> oldReservation = reservationRepository.findById(id);

        if(oldReservation.isPresent()) {
            oldReservationFound = oldReservation.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(reservation.getDeb_sej()!= null ) { oldReservationFound.setDeb_sej(reservation.getDeb_sej());}
        if(reservation.getNum_jours()!= 0 ) { oldReservationFound.setNum_jours(reservation.getNum_jours());}
        if(reservation.getId_reservation()!= 0 ) { oldReservationFound.setId_reservation(reservation.getId_reservation());}


        return reservationRepository.save(oldReservationFound);
    }

}
