package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Tarif;
import com.arabsoft.marinaBack.service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tarif")
public class TarifController {

    @Autowired
    TarifService tarifService;

    //http://localhost:8080/tarif/get-all-tarifs
    @GetMapping("/get-all-tarifs")
    @ResponseBody
    public List<Tarif> getAllTarifs() {
        return tarifService.getAllTarifs();
    }

    //http://localhost:8080/tarif/get-tarif-by-id/2
    @GetMapping("/get-tarif-by-id/{tarifId}")
    @ResponseBody
    public Tarif getTarifById(@PathVariable("tarifId") Long tarifId) {
        return tarifService.getTarifById(tarifId);
    }

    //http://localhost:8080/tarif/add-tarif
    @PostMapping("/add-tarif")
    @ResponseBody
    public Tarif addTarif(@RequestBody Tarif tarif) {
        Tarif tarifCreated = tarifService.addTarif(tarif);
        return tarifCreated;
    }

    //http://localhost:8080/tarif/delete-tarif/2
    @DeleteMapping("/delete-tarif/{id}")
    public ResponseEntity<Void> deleteTarifById(@PathVariable("id") Long id) {
        //public void deleteTarifById(@PathVariable("id") Long id) {

        tarifService.deleteTarifByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/tarif/update-tarif/4
    @PutMapping("/update-tarif/{id}")
    public ResponseEntity<?> updateTarif(@PathVariable("id") Long id, @RequestBody Tarif tarif) {
        try {
            Tarif tarifUpdated = tarifService.updateTarif(id, tarif);
            return ResponseEntity.ok(tarifUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

