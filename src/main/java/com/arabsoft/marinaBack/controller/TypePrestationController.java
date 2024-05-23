package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.TypePrestation;
import com.arabsoft.marinaBack.service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/typePrestation")
public class TypePrestationController {

    @Autowired
    TypePrestationService typePrestationService;

    //http://localhost:8080/typePrestation/get-all-typesPrestations
    @GetMapping("/get-all-typesPrestations")
    @ResponseBody
    public List<TypePrestation> getAllTypePrestations() {
        return typePrestationService.getAllTypesPrestations();
    }

    //http://localhost:8080/typePrestation/get-typePrestation-by-id/2
    @GetMapping("/get-typePrestation-by-id/{typePrestationId}")
    @ResponseBody
    public TypePrestation getTypePrestationById(@PathVariable("typePrestationId") Long typePrestationId) {
        return typePrestationService.getTypePrestationById(typePrestationId);
    }

    //http://localhost:8080/typePrestation/add-typePrestation
    @PostMapping("/add-typePrestation")
    @ResponseBody
    public TypePrestation addTypePrestation(@RequestBody TypePrestation typePrestation) {
        TypePrestation typePrestationCreated = typePrestationService.addTypePrestation(typePrestation);
        return typePrestationCreated;
    }

    //http://localhost:8080/typePrestation/delete-typePrestation/2
    @DeleteMapping("/delete-typePrestation/{id}")
    public ResponseEntity<Void> deleteTypePrestationById(@PathVariable("id") Long id) {
        //public void deleteTypePrestationById(@PathVariable("id") Long id) {

        typePrestationService.deleteTypePrestationByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/typePrestation/update-typePrestation/4
    @PutMapping("/update-typePrestation/{id}")
    public ResponseEntity<?> updateTypePrestation(@PathVariable("id") Long id, @RequestBody TypePrestation typePrestation) {
        try {
            TypePrestation typePrestationUpdated = typePrestationService.updateTypePrestation(id, typePrestation);
            return ResponseEntity.ok(typePrestationUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

