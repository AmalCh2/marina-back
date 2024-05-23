package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Tarif;
import com.arabsoft.marinaBack.repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TarifService {

    @Autowired
    TarifRepository tarifRepository;

    public List<Tarif> getAllTarifs() {
        return tarifRepository.findAll();
    }
    public Tarif getTarifById(Long id) {
        Tarif tarif = tarifRepository.findById(id).orElse(null);
        System.out.println("getTarifById result : " + tarif);
        return tarif;
    }

    public Tarif addTarif(Tarif tarif) {
        Tarif tarifCreated = tarifRepository.save(tarif);
        return tarifCreated;
    }

    public void deleteTarifByEmail(Long id) {
        tarifRepository.deleteById(id);
    }

    public Tarif updateTarif(Long id, Tarif tarif) {

        Tarif oldTarifFound;

        Optional<Tarif> oldTarif = tarifRepository.findById(id);

        if(oldTarif.isPresent()) {
            oldTarifFound = oldTarif.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(tarif.getId_tarif() != 0 ) { oldTarifFound.setId_tarif(tarif.getId_tarif());}
        if(tarif.getAnnee()!= 0 ) { oldTarifFound.setAnnee(tarif.getAnnee());}
        if(tarif.getJour_hs()!= 0 ) { oldTarifFound.setJour_hs(tarif.getJour_hs());}
        if(tarif.getJour_bs()!= 0 ) { oldTarifFound.setJour_bs(tarif.getJour_bs());}
        if(tarif.getJour_ms()!= 0 ) { oldTarifFound.setJour_ms(tarif.getJour_ms());}
        if(tarif.getMois_bs()!= 0 ) { oldTarifFound.setMois_bs(tarif.getMois_bs());}
        if(tarif.getMois_hs()!= 0 ) { oldTarifFound.setMois_hs(tarif.getMois_hs());}
        if(tarif.getMois_bs()!= 0 ) { oldTarifFound.setMois_bs(tarif.getMois_bs());}
        if(tarif.getType_tarif() != null ) { oldTarifFound.setType_tarif(tarif.getType_tarif());}
        if(tarif.getLargeur_bat() != 0 ) { oldTarifFound.setLargeur_bat(tarif.getLargeur_bat());}
        if(tarif.getLongueur_bat() != 0 ) { oldTarifFound.setLongueur_bat(tarif.getLongueur_bat());}
        if(tarif.getTarif_hivernage() != 0 ) { oldTarifFound.setTarif_hivernage(tarif.getTarif_hivernage());}
        if(tarif.getTarif_annuel() != 0 ) { oldTarifFound.setTarif_annuel(tarif.getTarif_annuel());}

        return tarifRepository.save(oldTarifFound);
    }

}
