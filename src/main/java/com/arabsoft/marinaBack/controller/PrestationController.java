package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Prestation;
import com.arabsoft.marinaBack.service.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/prestation")
public class PrestationController {

    @Autowired
    PrestationService prestationService;

    //http://localhost:8080/prestation/get-all-prestations
    @GetMapping("/get-all-prestations")
    @ResponseBody
    public List<Prestation> getAllPrestations() {
        return prestationService.getAllPrestations();
    }

    //http://localhost:8080/prestation/get-prestation-by-id/2
    @GetMapping("/get-prestation-by-id/{prestationId}")
    @ResponseBody
    public Prestation getPrestationById(@PathVariable("prestationId") Long prestationId) {
        return prestationService.getPrestationById(prestationId);
    }

    //http://localhost:8080/prestation/add-prestation
    @PostMapping("/add-prestation")
    @ResponseBody
    public Prestation addPrestation(@RequestBody Prestation prestation) {
        Prestation prestationCreated = prestationService.addPrestation(prestation);
        return prestationCreated;
    }

    //http://localhost:8080/prestation/delete-prestation/2
    @DeleteMapping("/delete-prestation/{id}")
    public ResponseEntity<Void> deletePrestationById(@PathVariable("id") Long id) {
        //public void deletePrestationById(@PathVariable("id") Long id) {

        prestationService.deletePrestationByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/prestation/update-prestation/4
    @PutMapping("/update-prestation/{id}")
    public ResponseEntity<?> updatePrestation(@PathVariable("id") Long id, @RequestBody Prestation prestation) {
        try {
            Prestation prestationUpdated = prestationService.updatePrestation(id, prestation);
            return ResponseEntity.ok(prestationUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }



}

