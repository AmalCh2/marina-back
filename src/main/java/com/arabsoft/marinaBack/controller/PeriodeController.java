package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Periode;
import com.arabsoft.marinaBack.service.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/period")
public class PeriodeController {

    @Autowired
    PeriodeService periodService;

    //http://localhost:8080/period/get-all-periodes
    @GetMapping("/get-all-periodes")
    @ResponseBody
    public List<Periode> getAllPeriodes() {
        return periodService.getAllPeriodes();
    }

    //http://localhost:8080/period/get-period-by-id/2
    @GetMapping("/get-period-by-id/{periodId}")
    @ResponseBody
    public Periode getPeriodeById(@PathVariable("periodId") Long periodId) {
        return periodService.getPeriodeById(periodId);
    }

    //http://localhost:8080/period/add-period
    @PostMapping("/add-period")
    @ResponseBody
    public Periode addPeriode(@RequestBody Periode period) {
        Periode periodCreated = periodService.addPeriode(period);
        return periodCreated;
    }

    //http://localhost:8080/period/delete-period/2
    @DeleteMapping("/delete-period/{id}")
    public ResponseEntity<Void> deletePeriodeById(@PathVariable("id") Long id) {
        periodService.deletePeriodeByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/period/update-period/4
    @PutMapping("/update-period/{id}")
    public ResponseEntity<?> updatePeriode(@PathVariable("id") Long id, @RequestBody Periode period) {
        try {
            Periode periodUpdated = periodService.updatePeriode(id, period);
            return ResponseEntity.ok(periodUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

