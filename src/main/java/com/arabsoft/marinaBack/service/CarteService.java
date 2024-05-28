package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Carte;
import com.arabsoft.marinaBack.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    @Autowired
    CarteRepository carteRepository;

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }
    public Carte getCarteById(Long id) {
        Carte carte = carteRepository.findById(id).orElse(null);
        System.out.println("getCarteById result : " + carte);
        return carte;
    }

    public Carte addCarte(Carte carte) {
        Carte carteCreated = carteRepository.save(carte);
        return carteCreated;
    }

    public void deleteCarteByEmail(Long id) {
        carteRepository.deleteById(id);
    }

    public Carte updateCarte(Long id, Carte carte) {

        Carte oldCarteFound;

        Optional<Carte> oldCarte = carteRepository.findById(id);

        if(oldCarte.isPresent()) {
            oldCarteFound = oldCarte.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(carte.getId_carte() != 0 ) { oldCarteFound.setId_carte(carte.getId_carte());}
        if(carte.getCpt_carte()!= 0 ) { oldCarteFound.setCpt_carte(carte.getCpt_carte());}
        if(carte.getLib_carte()!= null ) { oldCarteFound.setLib_carte(carte.getLib_carte());}

        return carteRepository.save(oldCarteFound);
    }

}
