package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.TarifForfait;
import com.arabsoft.marinaBack.service.TarifForfaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tarifForfait")
public class TarifForfaitController {

    @Autowired
    TarifForfaitService tarifForfaitService;

    //http://localhost:8080/tarifForfait/get-all-tarifsForfaits
    @GetMapping("/get-all-tarifsForfaits")
    @ResponseBody
    public List<TarifForfait> getAllTarifsForfaits() {
        return tarifForfaitService.getAllTarifsForfaits();
    }

    //http://localhost:8080/tarifForfait/get-tarifForfait-by-id/2
    @GetMapping("/get-tarifForfait-by-id/{tarifForfaitId}")
    @ResponseBody
    public TarifForfait getTarifForfaitById(@PathVariable("tarifForfaitId") Long tarifForfaitId) {
        return tarifForfaitService.getTarifForfaitById(tarifForfaitId);
    }

    //http://localhost:8080/tarifForfait/add-tarifForfait
    @PostMapping("/add-tarifForfait")
    @ResponseBody
    public TarifForfait addTarifForfait(@RequestBody TarifForfait tarifForfait) {
        TarifForfait tarifForfaitCreated = tarifForfaitService.addTarifForfait(tarifForfait);
        return tarifForfaitCreated;
    }

    //http://localhost:8080/tarifForfait/delete-tarifForfait/2
    @DeleteMapping("/delete-tarifForfait/{id}")
    public ResponseEntity<Void> deleteTarifForfaitById(@PathVariable("id") Long id) {
        //public void deleteTarifForfaitById(@PathVariable("id") Long id) {

        tarifForfaitService.deleteTarifForfaitByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/tarifForfait/update-tarifForfait/4
    @PutMapping("/update-tarifForfait/{id}")
    public ResponseEntity<?> updateTarifForfait(@PathVariable("id") Long id, @RequestBody TarifForfait tarifForfait) {
        try {
            TarifForfait tarifForfaitUpdated = tarifForfaitService.updateTarifForfait(id, tarifForfait);
            return ResponseEntity.ok(tarifForfaitUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

