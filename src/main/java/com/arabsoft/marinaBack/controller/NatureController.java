package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Nature;
import com.arabsoft.marinaBack.service.NatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/nature")
public class NatureController {

    @Autowired
    NatureService natureService;

    //http://localhost:8080/nature/get-all-natures
    @GetMapping("/get-all-natures")
    @ResponseBody
    public List<Nature> getAllNatures() {
        return natureService.getAllNatures();
    }

    //http://localhost:8080/nature/get-nature-by-id/2
    @GetMapping("/get-nature-by-id/{natureId}")
    @ResponseBody
    public Nature getNatureById(@PathVariable("natureId") Long natureId) {
        return natureService.getNatureById(natureId);
    }

    //http://localhost:8080/nature/add-nature
    @PostMapping("/add-nature")
    @ResponseBody
    public Nature addNature(@RequestBody Nature nature) {
        Nature natureCreated = natureService.addNature(nature);
        return natureCreated;
    }

    //http://localhost:8080/nature/delete-nature/2
    @DeleteMapping("/delete-nature/{id}")
    public ResponseEntity<Void> deleteNatureById(@PathVariable("id") Long id) {
        natureService.deleteNatureByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/nature/update-nature/4
    @PutMapping("/update-nature/{id}")
    public ResponseEntity<?> updateNature(@PathVariable("id") Long id, @RequestBody Nature nature) {
        try {
            Nature natureUpdated = natureService.updateNature(id, nature);
            return ResponseEntity.ok(natureUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

