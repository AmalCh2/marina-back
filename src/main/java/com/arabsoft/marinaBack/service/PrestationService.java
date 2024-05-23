package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Prestation;
import com.arabsoft.marinaBack.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrestationService {

    @Autowired
    PrestationRepository prestationRepository;

    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }
    public Prestation getPrestationById(Long id) {
        Prestation prestation = prestationRepository.findById(id).orElse(null);
        System.out.println("getPrestationById result : " + prestation);
        return prestation;
    }

    public Prestation addPrestation(Prestation prestation) {
        Prestation prestationCreated = prestationRepository.save(prestation);
        return prestationCreated;
    }

    public void deletePrestationByEmail(Long id) {
        prestationRepository.deleteById(id);
    }

    public Prestation updatePrestation(Long id, Prestation prestation) {

        Prestation oldPrestationFound;

        Optional<Prestation> oldPrestation = prestationRepository.findById(id);

        if(oldPrestation.isPresent()) {
            oldPrestationFound = oldPrestation.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(prestation.getId_prest() != 0 ) { oldPrestationFound.setId_prest(prestation.getId_prest());}
        if(prestation.getLib_prest()!= null ) { oldPrestationFound.setLib_prest(prestation.getLib_prest());}
        if(prestation.getPrix_unit_prest()!= 0 ) { oldPrestationFound.setPrix_unit_prest(prestation.getPrix_unit_prest());}
        if(prestation.getSecteur_prest()!= null ) { oldPrestationFound.setSecteur_prest(prestation.getSecteur_prest());}
        if(prestation.getRang_prest()!= 0 ) { oldPrestationFound.setRang_prest(prestation.getRang_prest());}

        return prestationRepository.save(oldPrestationFound);
    }

}
