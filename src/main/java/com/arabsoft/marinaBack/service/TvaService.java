package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Tva;
import com.arabsoft.marinaBack.repository.TvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvaService {

    @Autowired
    TvaRepository tvaRepository;

    public List<Tva> getAllTvas() {
        return tvaRepository.findAll();
    }
    public Tva getTvaById(Long id) {
        Tva tva = tvaRepository.findById(id).orElse(null);
        System.out.println("getTvaById result : " + tva);
        return tva;
    }

    public Tva addTva(Tva tva) {
        Tva tvaCreated = tvaRepository.save(tva);
        return tvaCreated;
    }

    public void deleteTvaByEmail(Long id) {
        tvaRepository.deleteById(id);
    }

    public Tva updateTva(Long id, Tva tva) {

        Tva oldTvaFound;

        Optional<Tva> oldTva = tvaRepository.findById(id);

        if(oldTva.isPresent()) {
            oldTvaFound = oldTva.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(tva.getId_tva() != 0 ) { oldTvaFound.setId_tva(tva.getId_tva());}
        if(tva.getCpt_tva()!= null ) { oldTvaFound.setCpt_tva(tva.getCpt_tva());}
        if(tva.getDate_tva()!= null ) { oldTvaFound.setDate_tva(tva.getDate_tva());}
        if(tva.getTaux_tva()!= 0 ) { oldTvaFound.setTaux_tva(tva.getTaux_tva());}

        return tvaRepository.save(oldTvaFound);
    }

}
