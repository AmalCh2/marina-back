package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.TypeBateau;
import com.arabsoft.marinaBack.service.TypeBateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/typeBateau")
public class TypeBateauController {

    @Autowired
    TypeBateauService typeBateauService;

    //http://localhost:8080/typeBateau/get-all-typesBateaux
    @GetMapping("/get-all-typesBateaux")
    @ResponseBody
    public List<TypeBateau> getAllTypesBateaux() {
        return typeBateauService.getAllTypesBateaux();
    }

    //http://localhost:8080/typeBateau/get-typeBateau-by-id/2
    @GetMapping("/get-typeBateau-by-id/{typeBateauId}")
    @ResponseBody
    public TypeBateau getTypeBateauById(@PathVariable("typeBateauId") Long typeBateauId) {
        return typeBateauService.getTypeBateauById(typeBateauId);
    }

    //http://localhost:8080/typeBateau/add-typeBateau
    @PostMapping("/add-typeBateau")
    @ResponseBody
    public TypeBateau addTypeBateau(@RequestBody TypeBateau typeBateau) {
        TypeBateau typeBateauCreated = typeBateauService.addTypeBateau(typeBateau);
        return typeBateauCreated;
    }

    //http://localhost:8080/typeBateau/delete-typeBateau/2
    @DeleteMapping("/delete-typeBateau/{id}")
    public ResponseEntity<Void> deleteTypeBateauById(@PathVariable("id") Long id) {
        //public void deleteTypeBateauById(@PathVariable("id") Long id) {

        typeBateauService.deleteTypeBateauByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/typeBateau/update-typeBateau/4
    @PutMapping("/update-typeBateau/{id}")
    public ResponseEntity<?> updateTypeBateau(@PathVariable("id") Long id, @RequestBody TypeBateau typeBateau) {
        try {
            TypeBateau typeBateauUpdated = typeBateauService.updateTypeBateau(id, typeBateau);
            return ResponseEntity.ok(typeBateauUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

/*
    //http://localhost:8080/typeBateau/get-getTypeBateau-Details/2
    @GetMapping("/get-getTypeBateau-Details/{typeBateauId}")
    public ResponseEntity<TypeBateau> getTypeBateauDetails(@PathVariable("typeBateauId") Long typeBateauId) {
        TypeBateau typeBateau = typeBateauService.getTypeBateauById(typeBateauId);
        if (typeBateau != null) {
            return new ResponseEntity<>(typeBateau, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
*/
}

