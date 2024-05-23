package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Tva;
import com.arabsoft.marinaBack.service.TvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tva")
public class TvaController {

    @Autowired
    TvaService tvaService;

    //http://localhost:8080/tva/get-all-tvas
    @GetMapping("/get-all-tvas")
    @ResponseBody
    public List<Tva> getAllTvas() {
        return tvaService.getAllTvas();
    }

    //http://localhost:8080/tva/get-tva-by-id/2
    @GetMapping("/get-tva-by-id/{tvaId}")
    @ResponseBody
    public Tva getTvaById(@PathVariable("tvaId") Long tvaId) {
        return tvaService.getTvaById(tvaId);
    }

    //http://localhost:8080/tva/add-tva
    @PostMapping("/add-tva")
    @ResponseBody
    public Tva addTva(@RequestBody Tva tva) {
        Tva tvaCreated = tvaService.addTva(tva);
        return tvaCreated;
    }

    //http://localhost:8080/tva/delete-tva/2
    @DeleteMapping("/delete-tva/{id}")
    public ResponseEntity<Void> deleteTvaById(@PathVariable("id") Long id) {
        //public void deleteTvaById(@PathVariable("id") Long id) {

        tvaService.deleteTvaByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/tva/update-tva/4
    @PutMapping("/update-tva/{id}")
    public ResponseEntity<?> updateTva(@PathVariable("id") Long id, @RequestBody Tva tva) {
        try {
            Tva tvaUpdated = tvaService.updateTva(id, tva);
            return ResponseEntity.ok(tvaUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

