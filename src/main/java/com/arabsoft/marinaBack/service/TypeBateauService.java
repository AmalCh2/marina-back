package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.TypeBateau;
import com.arabsoft.marinaBack.repository.TypeBateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeBateauService {

    @Autowired
    TypeBateauRepository typeBateauRepository;

    public List<TypeBateau> getAllTypesBateaux() {
        return typeBateauRepository.findAll();
    }
    public TypeBateau getTypeBateauById(Long id) {
        TypeBateau typeBateau = typeBateauRepository.findById(id).orElse(null);
        System.out.println("getTypeBateauById result : " + typeBateau);
        return typeBateau;
    }

    public TypeBateau addTypeBateau(TypeBateau typeBateau) {
        TypeBateau typeBateauCreated = typeBateauRepository.save(typeBateau);
        return typeBateauCreated;
    }

    public void deleteTypeBateauByEmail(Long id) {
        typeBateauRepository.deleteById(id);
    }

    public TypeBateau updateTypeBateau(Long id, TypeBateau typeBateau) {

        TypeBateau oldTypeBateauFound;

        Optional<TypeBateau> oldTypeBateau = typeBateauRepository.findById(id);

        if(oldTypeBateau.isPresent()) {
            oldTypeBateauFound = oldTypeBateau.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(typeBateau.getId_type_bat() != 0 ) { oldTypeBateauFound.setId_type_bat(typeBateau.getId_type_bat());}
        if(typeBateau.getType_bat() != null ) { oldTypeBateauFound.setType_bat(typeBateau.getType_bat());}
        if(typeBateau.getDesignation_bat() != null ) { oldTypeBateauFound.setDesignation_bat(typeBateau.getDesignation_bat());}
        if(typeBateau.getMajoration_bat() != 0 ) { oldTypeBateauFound.setMajoration_bat(typeBateau.getMajoration_bat());}



        return typeBateauRepository.save(oldTypeBateauFound);
    }
}
