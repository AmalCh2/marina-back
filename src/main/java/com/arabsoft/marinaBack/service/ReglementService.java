package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Reglement;
import com.arabsoft.marinaBack.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReglementService {

    @Autowired
    ReglementRepository reglementRepository;

    public List<Reglement> getAllReglements() {
        return reglementRepository.findAll();
    }
    public Reglement getReglementById(Long id) {
        Reglement reglement = reglementRepository.findById(id).orElse(null);
        System.out.println("getReglementById result : " + reglement);
        return reglement;
    }

    public Reglement addReglement(Reglement reglement) {
        Reglement reglementCreated = reglementRepository.save(reglement);
        return reglementCreated;
    }

    public void deleteReglementByEmail(Long id) {
        reglementRepository.deleteById(id);
    }

    public Reglement updateReglement(Long id, Reglement reglement) {

        Reglement oldReglementFound;

        Optional<Reglement> oldReglement = reglementRepository.findById(id);

        if(oldReglement.isPresent()) {
            oldReglementFound = oldReglement.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(reglement.getId_regle() != 0 ) { oldReglementFound.setId_regle(reglement.getId_regle());}
        if(reglement.getType_regl()!= null ) { oldReglementFound.setType_regl(reglement.getType_regl());}
        if(reglement.getDate_regl()!= null ) { oldReglementFound.setDate_regl(reglement.getDate_regl());}
        if(reglement.getMnt_regle()!= 0 ) { oldReglementFound.setMnt_regle(reglement.getMnt_regle());}

        if(reglement.getId_carte()!= 0 ) { oldReglementFound.setId_carte(reglement.getId_carte());}
        if(reglement.getId_fact()!= 0 ) { oldReglementFound.setId_fact(reglement.getId_fact());}

        return reglementRepository.save(oldReglementFound);
    }

}
