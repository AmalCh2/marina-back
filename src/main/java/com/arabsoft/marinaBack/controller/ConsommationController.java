package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Consommation;
import com.arabsoft.marinaBack.service.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/consommation")
public class ConsommationController {

    @Autowired
    ConsommationService consommationService;

    //http://localhost:8080/consommation/get-all-consommations
    @GetMapping("/get-all-consommations")
    @ResponseBody
    public List<Consommation> getAllConsommationx() {
        return consommationService.getAllConsommations();
    }

    //http://localhost:8080/consommation/get-consommation-by-id/2
    @GetMapping("/get-consommation-by-id/{consommationId}")
    @ResponseBody
    public Consommation getConsommationById(@PathVariable("consommationId") Long consommationId) {
        return consommationService.getConsommationById(consommationId);
    }

    //http://localhost:8080/consommation/add-consommation
    @PostMapping("/add-consommation")
    @ResponseBody
    public Consommation addConsommation(@RequestBody Consommation consommation) {
        Consommation consommationCreated = consommationService.addConsommation(consommation);
        return consommationCreated;
    }

    //http://localhost:8080/consommation/delete-consommation/2
    @DeleteMapping("/delete-consommation/{id}")
    public ResponseEntity<Void> deleteConsommationById(@PathVariable("id") Long id) {
        consommationService.deleteConsommationByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/consommation/update-consommation/4
    @PutMapping("/update-consommation/{id}")
    public ResponseEntity<?> updateConsommation(@PathVariable("id") Long id, @RequestBody Consommation consommation) {
        try {
            Consommation consommationUpdated = consommationService.updateConsommation(id, consommation);
            return ResponseEntity.ok(consommationUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

