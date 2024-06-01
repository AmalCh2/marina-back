package com.arabsoft.marinaBack.service;
import com.arabsoft.marinaBack.dto.Utilisateur;
import com.arabsoft.marinaBack.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    public Utilisateur getUtilisateurById(Long id_utilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(id_utilisateur).orElse(null);
        System.out.println("getUtilisateurById result : " + utilisateur);
        return utilisateur;
    }
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurCreated = utilisateurRepository.save(utilisateur);
        return utilisateurCreated;
    }
    public void deleteUtilisateurByEmail(Long id_utilisateur) {
        utilisateurRepository.deleteById(id_utilisateur);
    }
    public Utilisateur updateUtilisateur(Long id_utilisateur, Utilisateur utilisateur) {
        Utilisateur oldUtilisateurFound;
        Optional<Utilisateur> oldUtilisateur = utilisateurRepository.findById(id_utilisateur);
        if(oldUtilisateur.isPresent()) {
            oldUtilisateurFound = oldUtilisateur.get();
        } else {
            throw new RuntimeException("id_utilisateur not present in database -> No update to be done !!");
        }
        if(utilisateur.getId_utilisateur() != null ) { oldUtilisateurFound.setId_utilisateur(utilisateur.getId_utilisateur());}
        if(utilisateur.getNom_utilisateur() != null ) { oldUtilisateurFound.setNom_utilisateur(utilisateur.getNom_utilisateur());}
        if(utilisateur.getMot_de_passe() != null ) { oldUtilisateurFound.setMot_de_passe(utilisateur.getMot_de_passe());}

        if(utilisateur.getId_port() != null ) { oldUtilisateurFound.setId_port(utilisateur.getId_port());}
        return utilisateurRepository.save(oldUtilisateurFound);
    }

    public String getUtilisateurMot_de_passe(long id_utilisateur) {
        String mot_de_passe = utilisateurRepository.findPasswordById(id_utilisateur);
        return mot_de_passe;
    }
}