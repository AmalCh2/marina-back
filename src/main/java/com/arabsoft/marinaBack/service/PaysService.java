package com.arabsoft.marinaBack.service;
import com.arabsoft.marinaBack.dto.Pays;
import com.arabsoft.marinaBack.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PaysService {
    @Autowired
    PaysRepository paysRepository;
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }
    public Pays getPaysById(Long id) {
        Pays pays = paysRepository.findById(id).orElse(null);
        System.out.println("getPaysById result : " + pays);
        return pays;
    }
    public Pays addPays(Pays pays) {
        Pays paysCreated = paysRepository.save(pays);
        return paysCreated;
    }
    public void deletePaysByEmail(Long id) {
        paysRepository.deleteById(id);
    }
    public Pays updatePays(Long id, Pays pays) {
        Pays oldPaysFound;
        Optional<Pays> oldPays = paysRepository.findById(id);
        if(oldPays.isPresent()) {
            oldPaysFound = oldPays.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(pays.getId_pays() != 0 ) { oldPaysFound.setId_pays(pays.getId_pays());}
        if(pays.getNom_pays()!= null ) { oldPaysFound.setNom_pays(pays.getNom_pays());}
        if(pays.getPavillon()!= null ) { oldPaysFound.setPavillon(pays.getPavillon());}
        if(pays.getNationnalite()!= null ) { oldPaysFound.setNationnalite(pays.getNationnalite());}

        return paysRepository.save(oldPaysFound);
    }
}