package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Carte;
import com.arabsoft.marinaBack.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carte")
public class CarteController {

    @Autowired
    CarteService carteService;

    //http://localhost:8080/carte/get-all-cartes
    @GetMapping("/get-all-cartes")
    @ResponseBody
    public List<Carte> getAllCartex() {
        return carteService.getAllCartes();
    }

    //http://localhost:8080/carte/get-carte-by-id/2
    @GetMapping("/get-carte-by-id/{carteId}")
    @ResponseBody
    public Carte getCarteById(@PathVariable("carteId") Long carteId) {
        return carteService.getCarteById(carteId);
    }

    //http://localhost:8080/carte/add-carte
    @PostMapping("/add-carte")
    @ResponseBody
    public Carte addCarte(@RequestBody Carte carte) {
        Carte carteCreated = carteService.addCarte(carte);
        return carteCreated;
    }

    //http://localhost:8080/carte/delete-carte/2
    @DeleteMapping("/delete-carte/{id}")
    public ResponseEntity<Void> deleteCarteById(@PathVariable("id") Long id) {
        carteService.deleteCarteByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/carte/update-carte/4
    @PutMapping("/update-carte/{id}")
    public ResponseEntity<?> updateCarte(@PathVariable("id") Long id, @RequestBody Carte carte) {
        try {
            Carte carteUpdated = carteService.updateCarte(id, carte);
            return ResponseEntity.ok(carteUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

