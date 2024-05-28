package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Facture;
import com.arabsoft.marinaBack.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    FactureService factureService;

    //http://localhost:8080/facture/get-all-factures
    @GetMapping("/get-all-factures")
    @ResponseBody
    public List<Facture> getAllFacturex() {
        return factureService.getAllFactures();
    }

    //http://localhost:8080/facture/get-facture-by-id/2
    @GetMapping("/get-facture-by-id/{factureId}")
    @ResponseBody
    public Facture getFactureById(@PathVariable("factureId") Long factureId) {
        return factureService.getFactureById(factureId);
    }

    //http://localhost:8080/facture/add-facture
    @PostMapping("/add-facture")
    @ResponseBody
    public Facture addFacture(@RequestBody Facture facture) {
        Facture factureCreated = factureService.addFacture(facture);
        return factureCreated;
    }

    //http://localhost:8080/facture/delete-facture/2
    @DeleteMapping("/delete-facture/{id}")
    public ResponseEntity<Void> deleteFactureById(@PathVariable("id") Long id) {
        factureService.deleteFactureByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/facture/update-facture/4
    @PutMapping("/update-facture/{id}")
    public ResponseEntity<?> updateFacture(@PathVariable("id") Long id, @RequestBody Facture facture) {
        try {
            Facture factureUpdated = factureService.updateFacture(id, facture);
            return ResponseEntity.ok(factureUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

