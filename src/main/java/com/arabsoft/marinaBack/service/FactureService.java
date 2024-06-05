package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Facture;
import com.arabsoft.marinaBack.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
    public Facture getFactureById(Long id) {
        Facture facture = factureRepository.findById(id).orElse(null);
        System.out.println("getFactureById result : " + facture);
        return facture;
    }

    public Facture addFacture(Facture facture) {
        Facture factureCreated = factureRepository.save(facture);
        return factureCreated;
    }

    public void deleteFactureByEmail(Long id) {
        factureRepository.deleteById(id);
    }

    public Facture updateFacture(Long id, Facture facture) {

        Facture oldFactureFound;

        Optional<Facture> oldFacture = factureRepository.findById(id);

        if(oldFacture.isPresent()) {
            oldFactureFound = oldFacture.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(facture.getId_fact() != 0 ) { oldFactureFound.setId_fact(facture.getId_fact());}
        if(facture.getEtat_fact()!= null ) { oldFactureFound.setEtat_fact(facture.getEtat_fact());}
        if(facture.getEtat_paiement()!= null ) { oldFactureFound.setEtat_paiement(facture.getEtat_paiement());}
        if(facture.getMontant_ttl()!= 0 ) { oldFactureFound.setMontant_ttl(facture.getMontant_ttl());}
        if(facture.getLib_exo()!= null ) { oldFactureFound.setLib_exo(facture.getLib_exo());}
        //if(facture.getExo_cli()!= null ) { oldFactureFound.setExo_cli(facture.getExo_cli());}
        if(facture.getTbre_fiscale()!= null ) { oldFactureFound.setTbre_fiscale(facture.getTbre_fiscale());}
        if(facture.getDate_fact()!= null ) { oldFactureFound.setDate_fact(facture.getDate_fact());}
        if(facture.getLib_carte()!= null ) { oldFactureFound.setLib_carte(facture.getLib_carte());}
        if(facture.getCpt_carte()!= 0 ) { oldFactureFound.setCpt_carte(facture.getCpt_carte());}

        return factureRepository.save(oldFactureFound);
    }

}
