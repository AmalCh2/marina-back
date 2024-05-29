package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Reservation;
import com.arabsoft.marinaBack.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    //http://localhost:8080/reservation/get-all-reservations
    @GetMapping("/get-all-reservations")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    //http://localhost:8080/reservation/get-reservation-by-id/2
    @GetMapping("/get-reservation-by-id/{reservationId}")
    @ResponseBody
    public Reservation getReservationById(@PathVariable("reservationId") Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    //http://localhost:8080/reservation/add-reservation
    @PostMapping("/add-reservation")
    @ResponseBody
    public Reservation addReservation(@RequestBody Reservation reservation) {
        Reservation reservationCreated = reservationService.addReservation(reservation);
        return reservationCreated;
    }

    //http://localhost:8080/reservation/delete-reservation/2
    @DeleteMapping("/delete-reservation/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable("id") Long id) {
        //public void deleteReservationById(@PathVariable("id") Long id) {

        reservationService.deleteReservationByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/reservation/update-reservation/4
    @PutMapping("/update-reservation/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        try {
            Reservation reservationUpdated = reservationService.updateReservation(id, reservation);
            return ResponseEntity.ok(reservationUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

