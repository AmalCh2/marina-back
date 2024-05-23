package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Pays;
import com.arabsoft.marinaBack.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pays")
public class PaysController {

    @Autowired
    PaysService paysService;

    //http://localhost:8080/pays/get-all-pays
    @GetMapping("/get-all-pays")
    @ResponseBody
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    //http://localhost:8080/pays/get-pays-by-id/2
    @GetMapping("/get-pays-by-id/{paysId}")
    @ResponseBody
    public Pays getPaysById(@PathVariable("paysId") Long paysId) {
        return paysService.getPaysById(paysId);
    }

    //http://localhost:8080/pays/add-pays
    @PostMapping("/add-pays")
    @ResponseBody
    public Pays addPays(@RequestBody Pays pays) {
        Pays paysCreated = paysService.addPays(pays);
        return paysCreated;
    }

    //http://localhost:8080/pays/delete-pays/2
    @DeleteMapping("/delete-pays/{id}")
    public ResponseEntity<Void> deletePaysById(@PathVariable("id") Long id) {
        paysService.deletePaysByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/pays/update-pays/4
    @PutMapping("/update-pays/{id}")
    public ResponseEntity<?> updatePays(@PathVariable("id") Long id, @RequestBody Pays pays) {
        try {
            Pays paysUpdated = paysService.updatePays(id, pays);
            return ResponseEntity.ok(paysUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

