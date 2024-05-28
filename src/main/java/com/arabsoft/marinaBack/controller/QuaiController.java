package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Quai;
import com.arabsoft.marinaBack.service.QuaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/quai")
public class QuaiController {

    @Autowired
    QuaiService quaiService;

    //http://localhost:8080/quai/get-all-quais
    @GetMapping("/get-all-quais")
    @ResponseBody
    public List<Quai> getAllQuaix() {
        return quaiService.getAllQuais();
    }

    //http://localhost:8080/quai/get-quai-by-id/2
    @GetMapping("/get-quai-by-id/{quaiId}")
    @ResponseBody
    public Quai getQuaiById(@PathVariable("quaiId") Long quaiId) {
        return quaiService.getQuaiById(quaiId);
    }

    //http://localhost:8080/quai/add-quai
    @PostMapping("/add-quai")
    @ResponseBody
    public Quai addQuai(@RequestBody Quai quai) {
        Quai quaiCreated = quaiService.addQuai(quai);
        return quaiCreated;
    }

    //http://localhost:8080/quai/delete-quai/2
    @DeleteMapping("/delete-quai/{id}")
    public ResponseEntity<Void> deleteQuaiById(@PathVariable("id") Long id) {
        quaiService.deleteQuaiByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/quai/update-quai/4
    @PutMapping("/update-quai/{id}")
    public ResponseEntity<?> updateQuai(@PathVariable("id") Long id, @RequestBody Quai quai) {
        try {
            Quai quaiUpdated = quaiService.updateQuai(id, quai);
            return ResponseEntity.ok(quaiUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}


