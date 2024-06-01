package com.arabsoft.marinaBack.service;
import com.arabsoft.marinaBack.dto.TarifForfait;
import com.arabsoft.marinaBack.repository.TarifForfaitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TarifForfaitService {
    @Autowired
    TarifForfaitRepository TarifForfaitRepository;
    public List<TarifForfait> getAllTarifsForfaits() {
        return TarifForfaitRepository.findAll();
    }
    public TarifForfait getTarifForfaitById(Long id) {
        TarifForfait TarifForfait = TarifForfaitRepository.findById(id).orElse(null);
        System.out.println("getTarifForfaitById result : " + TarifForfait);
        return TarifForfait;
    }
    public TarifForfait addTarifForfait(TarifForfait TarifForfait) {
        TarifForfait TarifForfaitCreated = TarifForfaitRepository.save(TarifForfait);
        return TarifForfaitCreated;
    }
    public void deleteTarifForfaitByEmail(Long id) {
        TarifForfaitRepository.deleteById(id);
    }
    public TarifForfait updateTarifForfait(Long id, TarifForfait TarifForfait) {
        TarifForfait oldTarifForfaitFound;
        Optional<TarifForfait> oldTarifForfait = TarifForfaitRepository.findById(id);
        if(oldTarifForfait.isPresent()) {
            oldTarifForfaitFound = oldTarifForfait.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(TarifForfait.getId_tarif_forfait() != 0 ) { oldTarifForfaitFound.setId_tarif_forfait(TarifForfait.getId_tarif_forfait());}
        if(TarifForfait.getType()!= null ) { oldTarifForfaitFound.setType(TarifForfait.getType());}
        if(TarifForfait.getAnnee()!= 0 ) { oldTarifForfaitFound.setAnnee(TarifForfait.getAnnee());}
        if(TarifForfait.getLargeur_bat()!= 0 ) { oldTarifForfaitFound.setLargeur_bat(TarifForfait.getLargeur_bat());}
        if(TarifForfait.getLongueur_bat()!= 0 ) { oldTarifForfaitFound.setLongueur_bat(TarifForfait.getLongueur_bat());}
        return TarifForfaitRepository.save(oldTarifForfaitFound);
    }
}