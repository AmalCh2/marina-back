package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.P_electrique;
import com.arabsoft.marinaBack.repository.P_electriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class P_electriqueService {

    @Autowired
    P_electriqueRepository p_electriqueRepository;

    public List<P_electrique> getAllP_electriques() {
        return p_electriqueRepository.findAll();
    }
    public P_electrique getP_electriqueById(Long id) {
        P_electrique p_electrique = p_electriqueRepository.findById(id).orElse(null);
        System.out.println("getP_electriqueById result : " + p_electrique);
        return p_electrique;
    }

    public P_electrique addP_electrique(P_electrique p_electrique) {
        P_electrique p_electriqueCreated = p_electriqueRepository.save(p_electrique);
        return p_electriqueCreated;
    }

    public void deleteP_electriqueByEmail(Long id) {
        p_electriqueRepository.deleteById(id);
    }

    public P_electrique updateP_electrique(Long id, P_electrique p_electrique) {

        P_electrique oldP_electriqueFound;

        Optional<P_electrique> oldP_electrique = p_electriqueRepository.findById(id);

        if(oldP_electrique.isPresent()) {
            oldP_electriqueFound = oldP_electrique.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(p_electrique.getId_p_elec() != 0 ) { oldP_electriqueFound.setId_p_elec(p_electrique.getId_p_elec());}
        if(p_electrique.getDesignation()!= null ) { oldP_electriqueFound.setDesignation(p_electrique.getDesignation());}

        return p_electriqueRepository.save(oldP_electriqueFound);
    }

}

