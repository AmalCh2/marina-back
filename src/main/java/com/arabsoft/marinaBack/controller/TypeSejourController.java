package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.TypeSejour;
import com.arabsoft.marinaBack.service.TypeSejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/typeSejour")
public class TypeSejourController {

    @Autowired
    TypeSejourService typeSejourService;

    //http://localhost:8080/typeSejour/get-all-typesSejours
    @GetMapping("/get-all-typesSejours")
    @ResponseBody
    public List<TypeSejour> getAllTypesSejours() {
        return typeSejourService.getAllTypesSejours();
    }

    //http://localhost:8080/typeSejour/get-typeSejour-by-id/2
    @GetMapping("/get-typeSejour-by-id/{typeSejourId}")
    @ResponseBody
    public TypeSejour getTypeSejourById(@PathVariable("typeSejourId") Long typeSejourId) {
        return typeSejourService.getTypeSejourById(typeSejourId);
    }

    //http://localhost:8080/typeSejour/add-typeSejour
    @PostMapping("/add-typeSejour")
    @ResponseBody
    public TypeSejour addTypeSejour(@RequestBody TypeSejour typeSejour) {
        TypeSejour typeSejourCreated = typeSejourService.addTypeSejour(typeSejour);
        return typeSejourCreated;
    }

    //http://localhost:8080/typeSejour/delete-typeSejour/2
    @DeleteMapping("/delete-typeSejour/{id}")
    public ResponseEntity<Void> deleteTypeSejourById(@PathVariable("id") Long id) {
        //public void deleteTypeSejourById(@PathVariable("id") Long id) {

        typeSejourService.deleteTypeSejourByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/typeSejour/update-typeSejour/4
    @PutMapping("/update-typeSejour/{id}")
    public ResponseEntity<?> updateTypeSejour(@PathVariable("id") Long id, @RequestBody TypeSejour typeSejour) {
        try {
            TypeSejour typeSejourUpdated = typeSejourService.updateTypeSejour(id, typeSejour);
            return ResponseEntity.ok(typeSejourUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

