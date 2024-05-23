package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Sejour;
import com.arabsoft.marinaBack.service.SejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sejour")
public class SejourController {

    @Autowired
    SejourService sejourService;

    //http://localhost:8080/sejour/get-all-sejours
    @GetMapping("/get-all-sejours")
    @ResponseBody
    public List<Sejour> getAllSejours() {
        return sejourService.getAllSejours();
    }

    //http://localhost:8080/sejour/get-sejour-by-id/2
    @GetMapping("/get-sejour-by-id/{sejourId}")
    @ResponseBody
    public Sejour getSejourById(@PathVariable("sejourId") Long sejourId) {
        return sejourService.getSejourById(sejourId);
    }

    //http://localhost:8080/sejour/add-sejour
    @PostMapping("/add-sejour")
    @ResponseBody
    public Sejour addSejour(@RequestBody Sejour sejour) {
        Sejour sejourCreated = sejourService.addSejour(sejour);
        return sejourCreated;
    }

    //http://localhost:8080/sejour/delete-sejour/2
    @DeleteMapping("/delete-sejour/{id}")
    public ResponseEntity<Void> deleteSejourById(@PathVariable("id") Long id) {
        //public void deleteSejourById(@PathVariable("id") Long id) {

        sejourService.deleteSejourByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/sejour/update-sejour/4
    @PutMapping("/update-sejour/{id}")
    public ResponseEntity<?> updateSejour(@PathVariable("id") Long id, @RequestBody Sejour sejour) {
        try {
            Sejour sejourUpdated = sejourService.updateSejour(id, sejour);
            return ResponseEntity.ok(sejourUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

