package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.TypePrestation;
import com.arabsoft.marinaBack.repository.TypePrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TypePrestationService {

    @Autowired
    TypePrestationRepository typePrestationRepository;

    public List<TypePrestation> getAllTypesPrestations() {
        return typePrestationRepository.findAll();
    }

    public TypePrestation getTypePrestationById(Long id) {
        TypePrestation typePrestation = typePrestationRepository.findById(id).orElse(null);
        System.out.println("getTypePrestationById result : " + typePrestation);
        return typePrestation;
    }

    public TypePrestation addTypePrestation(TypePrestation typePrestation) {
        TypePrestation typePrestationCreated = typePrestationRepository.save(typePrestation);
        return typePrestationCreated;
    }

    public void deleteTypePrestationByEmail(Long id) {
        typePrestationRepository.deleteById(id);
    }

    public TypePrestation updateTypePrestation(Long id, TypePrestation typePrestation) {

        TypePrestation oldTypePrestationFound;

        Optional<TypePrestation> oldTypePrestation = typePrestationRepository.findById(id);

        if (oldTypePrestation.isPresent()) {
            oldTypePrestationFound = oldTypePrestation.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if (typePrestation.getId_type_prest() != 0) {
            oldTypePrestationFound.setId_type_prest(typePrestation.getId_type_prest());
        }
        if (typePrestation.getLib_type_prest() != null) {
            oldTypePrestationFound.setLib_type_prest(typePrestation.getLib_type_prest());
        }
        if (typePrestation.getRang_type_prest() != 0) {
            oldTypePrestationFound.setRang_type_prest(typePrestation.getRang_type_prest());
        }


        return typePrestationRepository.save(oldTypePrestationFound);
    }
}
