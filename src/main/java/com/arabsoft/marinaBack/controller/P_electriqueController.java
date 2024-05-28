package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.P_electrique;
import com.arabsoft.marinaBack.service.P_electriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/p_electrique")
public class P_electriqueController {

    @Autowired
    P_electriqueService p_electriqueService;

    //http://localhost:8080/p_electrique/get-all-p_electriques
    @GetMapping("/get-all-p_electriques")
    @ResponseBody
    public List<P_electrique> getAllP_electriquex() {
        return p_electriqueService.getAllP_electriques();
    }

    //http://localhost:8080/p_electrique/get-p_electrique-by-id/2
    @GetMapping("/get-p_electrique-by-id/{p_electriqueId}")
    @ResponseBody
    public P_electrique getP_electriqueById(@PathVariable("p_electriqueId") Long p_electriqueId) {
        return p_electriqueService.getP_electriqueById(p_electriqueId);
    }

    //http://localhost:8080/p_electrique/add-p_electrique
    @PostMapping("/add-p_electrique")
    @ResponseBody
    public P_electrique addP_electrique(@RequestBody P_electrique p_electrique) {
        P_electrique p_electriqueCreated = p_electriqueService.addP_electrique(p_electrique);
        return p_electriqueCreated;
    }

    //http://localhost:8080/p_electrique/delete-p_electrique/2
    @DeleteMapping("/delete-p_electrique/{id}")
    public ResponseEntity<Void> deleteP_electriqueById(@PathVariable("id") Long id) {
        p_electriqueService.deleteP_electriqueByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/p_electrique/update-p_electrique/4
    @PutMapping("/update-p_electrique/{id}")
    public ResponseEntity<?> updateP_electrique(@PathVariable("id") Long id, @RequestBody P_electrique p_electrique) {
        try {
            P_electrique p_electriqueUpdated = p_electriqueService.updateP_electrique(id, p_electrique);
            return ResponseEntity.ok(p_electriqueUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

