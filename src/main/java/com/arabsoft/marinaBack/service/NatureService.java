package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Nature;
import com.arabsoft.marinaBack.repository.NatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NatureService {

    @Autowired
    NatureRepository natureRepository;

    public List<Nature> getAllNatures() {
        return natureRepository.findAll();
    }
    public Nature getNatureById(Long id) {
        Nature nature = natureRepository.findById(id).orElse(null);
        System.out.println("getNatureById result : " + nature);
        return nature;
    }

    public Nature addNature(Nature nature) {
        Nature natureCreated = natureRepository.save(nature);
        return natureCreated;
    }

    public void deleteNatureByEmail(Long id) {
        natureRepository.deleteById(id);
    }

    public Nature updateNature(Long id, Nature nature) {

        Nature oldNatureFound;

        Optional<Nature> oldNature = natureRepository.findById(id);

        if(oldNature.isPresent()) {
            oldNatureFound = oldNature.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(nature.getId_nature() != 0 ) { oldNatureFound.setId_nature(nature.getId_nature());}
        if(nature.getLib_nature()!= null ) { oldNatureFound.setLib_nature(nature.getLib_nature());}


        return natureRepository.save(oldNatureFound);
    }

}
