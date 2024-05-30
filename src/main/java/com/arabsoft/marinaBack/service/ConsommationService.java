package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Consommation;
import com.arabsoft.marinaBack.repository.ConsommationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsommationService {

    @Autowired
    ConsommationRepository consommationRepository;

    public List<Consommation> getAllConsommations() {
        return consommationRepository.findAll();
    }
    public Consommation getConsommationById(Long id) {
        Consommation consommation = consommationRepository.findById(id).orElse(null);
        System.out.println("getConsommationById result : " + consommation);
        return consommation;
    }

    public Consommation addConsommation(Consommation consommation) {
        Consommation consommationCreated = consommationRepository.save(consommation);
        return consommationCreated;
    }

    public void deleteConsommationByEmail(Long id) {
        consommationRepository.deleteById(id);
    }

    public Consommation updateConsommation(Long id, Consommation consommation) {

        Consommation oldConsommationFound;

        Optional<Consommation> oldConsommation = consommationRepository.findById(id);

        if(oldConsommation.isPresent()) {
            oldConsommationFound = oldConsommation.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(consommation.getId_cons() != 0 ) { oldConsommationFound.setId_cons(consommation.getId_cons());}
        if(consommation.getPrix_unit()!= 0 ) { oldConsommationFound.setPrix_unit(consommation.getPrix_unit());}
        if(consommation.getQte()!= 0 ) { oldConsommationFound.setQte(consommation.getQte());}
        if(consommation.getDeb_cons()!= null ) { oldConsommationFound.setDeb_cons(consommation.getDeb_cons());}
        if(consommation.getFin_cons()!= null ) { oldConsommationFound.setFin_cons(consommation.getFin_cons());}
        if(consommation.getOffre()!= null ) { oldConsommationFound.setOffre(consommation.getOffre());}
        if(consommation.getNum_reçu()!= 0 ) { oldConsommationFound.setNum_reçu(consommation.getNum_reçu());}


        return consommationRepository.save(oldConsommationFound);
    }

}
