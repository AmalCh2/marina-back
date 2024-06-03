package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Utilisateur;
import com.arabsoft.marinaBack.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    //http://localhost:8080/utilisateur/get-all-utilisateurs
    @GetMapping("/get-all-utilisateurs")
    @ResponseBody
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    //http://localhost:8080/utilisateur/get-utilisateur-by-id/2
    @GetMapping("/get-utilisateur-by-id/{utilisateurId}")
    @ResponseBody
    public Utilisateur getUtilisateurById(@PathVariable("utilisateurId") Long utilisateurId) {
        return utilisateurService.getUtilisateurById(utilisateurId);
    }

    //http://localhost:8080/utilisateur/add-utilisateur
    @PostMapping("/add-utilisateur")
    @ResponseBody
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurCreated = utilisateurService.addUtilisateur(utilisateur);
        return utilisateurCreated;
    }

    //http://localhost:8080/utilisateur/delete-utilisateur/2
    @DeleteMapping("/delete-utilisateur/{id}")
    public ResponseEntity<Void> deleteUtilisateurById(@PathVariable("id") Long id) {
        //public void deleteUtilisateurById(@PathVariable("id") Long id) {

        utilisateurService.deleteUtilisateurByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/utilisateur/verifyUserPassword/7/1234
    @GetMapping("/verifyUserPassword/{id}/{password}")
    @ResponseBody
    public int getuserPasswordById(@PathVariable("id") Long id, @PathVariable("password") String password) {
        return utilisateurService.verifyuserPassword(id,password);
    }

    //http://localhost:8080/utilisateur/resetpassword/zz
    @PutMapping("/resetpassword/{username}")
    @ResponseBody
    public void resetPassword(@PathVariable("username") String username) {
        utilisateurService.resetPassword(username);
    }

    //http://localhost:8080/utilisateur/update-utilisateur/4
    @PutMapping("/update-utilisateur/{id}")
    public ResponseEntity<?> updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur utilisateurUpdated = utilisateurService.updateUtilisateur(id, utilisateur);
            return ResponseEntity.ok(utilisateurUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }


    //http://localhost:8080/utilisateur/get-getUtilisateur-Details/2
    /*
    @GetMapping("/get-getUtilisateur-Details/{utilisateurId}")
    public ResponseEntity<Utilisateur> getUtilisateurDetails(@PathVariable("utilisateurId") Long utilisateurId) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(utilisateurId);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    */
}

