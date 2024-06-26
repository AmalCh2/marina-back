package com.arabsoft.marinaBack.service;
import com.arabsoft.marinaBack.dto.Sejour;
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



    public List<Sejour> getSejours() {
        return sejourRepository.afficher_sejour();
    }

    public List<Sejour> getArchievedSejours() {
        return sejourRepository.afficher_archived_sejour();
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

        if(sejour.getFin_sej()!= null ) { oldSejourFound.setFin_sej(sejour.getFin_sej());}


        return sejourRepository.save(oldSejourFound);
    }

    public void archiveSejour(long id) {
        Optional<Sejour> optionalSejour = sejourRepository.findById(id);
        if (optionalSejour.isPresent()) {
            Sejour sejour = optionalSejour.get();
            sejour.setArchived(1);
            sejourRepository.save(sejour);
        } else {
            throw new RuntimeException("Sejour not found");
        }
    }
}