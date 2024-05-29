package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Sejour;
import com.arabsoft.marinaBack.repository.SejourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SejourService {

    @Autowired
    SejourRepository sejourRepository;

    public List<Sejour> getAllSejours() {
        return sejourRepository.findAll();
    }
    public Sejour getSejourById(Long id) {
        Sejour sejour = sejourRepository.findById(id).orElse(null);
        System.out.println("getSejourById result : " + sejour);
        return sejour;
    }

    public Sejour addSejour(Sejour sejour) {
        Sejour sejourCreated = sejourRepository.save(sejour);
        return sejourCreated;
    }

    public void deleteSejourByEmail(Long id) {
        sejourRepository.deleteById(id);
    }

    public Sejour updateSejour(Long id, Sejour sejour) {

        Sejour oldSejourFound;

        Optional<Sejour> oldSejour = sejourRepository.findById(id);

        if(oldSejour.isPresent()) {
            oldSejourFound = oldSejour.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(sejour.getId_sej() != 0 ) { oldSejourFound.setId_sej(sejour.getId_sej());}
        if(sejour.getDeb_sej()!= null ) { oldSejourFound.setDeb_sej(sejour.getDeb_sej());}
        if(sejour.getNum_jours()!= 0 ) { oldSejourFound.setNum_jours(sejour.getNum_jours());}
        if(sejour.getId_tarif()!= 0 ) { oldSejourFound.setId_tarif(sejour.getId_tarif());}
        if(sejour.getId_type_sej()!= 0 ) { oldSejourFound.setId_type_sej(sejour.getId_type_sej());}
        if(sejour.getId_emp()!= 0 ) { oldSejourFound.setId_emp(sejour.getId_emp());}
        if(sejour.getId_bat()!= 0 ) { oldSejourFound.setId_bat(sejour.getId_bat());}
        if(sejour.getNom_bat()!= null ) { oldSejourFound.setNom_bat(sejour.getNom_bat());}
        if(sejour.getId_cli()!= 0 ) { oldSejourFound.setId_cli(sejour.getId_cli());}
        if(sejour.getNom_cli()!= null ) { oldSejourFound.setNom_cli(sejour.getNom_cli());}
        if(sejour.getId_reservation()!= 0 ) { oldSejourFound.setId_cli(sejour.getId_cli());}


        return sejourRepository.save(oldSejourFound);
    }

}
