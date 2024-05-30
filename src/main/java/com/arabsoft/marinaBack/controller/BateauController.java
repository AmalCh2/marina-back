package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Bateau;
import com.arabsoft.marinaBack.service.BateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bateau")
public class BateauController {

    @Autowired
    BateauService bateauService;

    //http://localhost:8080/bateau/get-all-bateaux
    @GetMapping("/get-all-bateaux")
    @ResponseBody
    public List<Bateau> getAllBateaux() {
        return bateauService.getAllBateaux();
    }

    //http://localhost:8080/bateau/get-bateau-by-id/2
    @GetMapping("/get-bateau-by-id/{bateauId}")
    @ResponseBody
    public Bateau getBateauById(@PathVariable("bateauId") Long bateauId) {
        return bateauService.getBateauById(bateauId);
    }

    //http://localhost:8080/bateau/total-bateau/{portId}
    @GetMapping("/total-bateau/{portId}")
    public int getTotalBateauDansPort(@PathVariable long portId) {
        return bateauService.getTotalBateauDansPort(portId);
    }

    //http://localhost:8080/bateau/add-bateau
    @PostMapping("/add-bateau")
    @ResponseBody
    public Bateau addBateau(@RequestBody Bateau bateau) {
        Bateau bateauCreated = bateauService.addBateau(bateau);
        return bateauCreated;
    }

    //http://localhost:8080/bateau/delete-bateau/2
    @DeleteMapping("/delete-bateau/{id}")
    public ResponseEntity<Void> deleteBateauById(@PathVariable("id") Long id) {
        bateauService.deleteBateauByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/bateau/update-bateau/4
    @PutMapping("/update-bateau/{id}")
    public ResponseEntity<?> updateBateau(@PathVariable("id") Long id, @RequestBody Bateau bateau) {
        try {
            Bateau bateauUpdated = bateauService.updateBateau(id, bateau);
            return ResponseEntity.ok(bateauUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

