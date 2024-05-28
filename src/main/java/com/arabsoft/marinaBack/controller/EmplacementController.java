package com.arabsoft.marinaBack.controller;

        import com.arabsoft.marinaBack.dto.Emplacement;
        import com.arabsoft.marinaBack.service.EmplacementService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emplacement")
public class EmplacementController {

    @Autowired
    EmplacementService emplacementService;

    //http://localhost:8080/emplacement/get-all-emplacements
    @GetMapping("/get-all-emplacements")
    @ResponseBody
    public List<Emplacement> getAllEmplacementx() {
        return emplacementService.getAllEmplacements();
    }

    //http://localhost:8080/emplacement/get-emplacement-by-id/2
    @GetMapping("/get-emplacement-by-id/{emplacementId}")
    @ResponseBody
    public Emplacement getEmplacementById(@PathVariable("emplacementId") Long emplacementId) {
        return emplacementService.getEmplacementById(emplacementId);
    }

    //http://localhost:8080/emplacement/add-emplacement
    @PostMapping("/add-emplacement")
    @ResponseBody
    public Emplacement addEmplacement(@RequestBody Emplacement emplacement) {
        Emplacement emplacementCreated = emplacementService.addEmplacement(emplacement);
        return emplacementCreated;
    }

    //http://localhost:8080/emplacement/delete-emplacement/2
    @DeleteMapping("/delete-emplacement/{id}")
    public ResponseEntity<Void> deleteEmplacementById(@PathVariable("id") Long id) {
        emplacementService.deleteEmplacementByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/emplacement/update-emplacement/4
    @PutMapping("/update-emplacement/{id}")
    public ResponseEntity<?> updateEmplacement(@PathVariable("id") Long id, @RequestBody Emplacement emplacement) {
        try {
            Emplacement emplacementUpdated = emplacementService.updateEmplacement(id, emplacement);
            return ResponseEntity.ok(emplacementUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }

}

