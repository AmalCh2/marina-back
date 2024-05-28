package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Reglement;
import com.arabsoft.marinaBack.service.ReglementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reglement")
public class ReglementController {

    @Autowired
    ReglementService reglementService;

    //http://localhost:8080/reglement/get-all-reglements
    @GetMapping("/get-all-reglements")
    @ResponseBody
    public List<Reglement> getAllReglementx() {
        return reglementService.getAllReglements();
    }

    //http://localhost:8080/reglement/get-reglement-by-id/2
    @GetMapping("/get-reglement-by-id/{reglementId}")
    @ResponseBody
    public Reglement getReglementById(@PathVariable("reglementId") Long reglementId) {
        return reglementService.getReglementById(reglementId);
    }

    //http://localhost:8080/reglement/add-reglement
    @PostMapping("/add-reglement")
    @ResponseBody
    public Reglement addReglement(@RequestBody Reglement reglement) {
        Reglement reglementCreated = reglementService.addReglement(reglement);
        return reglementCreated;
    }

    //http://localhost:8080/reglement/delete-reglement/2
    @DeleteMapping("/delete-reglement/{id}")
    public ResponseEntity<Void> deleteReglementById(@PathVariable("id") Long id) {
        reglementService.deleteReglementByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/reglement/update-reglement/4
    @PutMapping("/update-reglement/{id}")
    public ResponseEntity<?> updateReglement(@PathVariable("id") Long id, @RequestBody Reglement reglement) {
        try {
            Reglement reglementUpdated = reglementService.updateReglement(id, reglement);
            return ResponseEntity.ok(reglementUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

