package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Periode;
import com.arabsoft.marinaBack.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodeService {

    @Autowired
    PeriodeRepository periodeRepository;

    public List<Periode> getAllPeriodes() {
        return periodeRepository.findAll();
    }
    public Periode getPeriodeById(Long id) {
        Periode periode = periodeRepository.findById(id).orElse(null);
        System.out.println("getPeriodeById result : " + periode);
        return periode;
    }

    public Periode addPeriode(Periode periode) {
        Periode periodeCreated = periodeRepository.save(periode);
        return periodeCreated;
    }

    public void deletePeriodeByEmail(Long id) {
        periodeRepository.deleteById(id);
    }

    public Periode updatePeriode(Long id, Periode periode) {

        Periode oldPeriodeFound;

        Optional<Periode> oldPeriode = periodeRepository.findById(id);

        if(oldPeriode.isPresent()) {
            oldPeriodeFound = oldPeriode.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(periode.getId_periode() != 0 ) { oldPeriodeFound.setId_periode(periode.getId_periode());}
        if(periode.getDeb_periode()!= null ) { oldPeriodeFound.setDeb_periode(periode.getDeb_periode());}
        if(periode.getFin_periode()!= null ) { oldPeriodeFound.setFin_periode(periode.getFin_periode());}

        return periodeRepository.save(oldPeriodeFound);
    }

}
