package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.TypeSejour;
import com.arabsoft.marinaBack.repository.TypeSejourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeSejourService {

    @Autowired
    TypeSejourRepository typeSejourRepository;

    public List<TypeSejour> getAllTypesSejours() {
        return typeSejourRepository.findAll();
    }
    public TypeSejour getTypeSejourById(Long id) {
        TypeSejour typeSejour = typeSejourRepository.findById(id).orElse(null);
        System.out.println("getTypeSejourById result : " + typeSejour);
        return typeSejour;
    }

    public TypeSejour addTypeSejour(TypeSejour typeSejour) {
        TypeSejour typeSejourCreated = typeSejourRepository.save(typeSejour);
        return typeSejourCreated;
    }

    public void deleteTypeSejourByEmail(Long id) {
        typeSejourRepository.deleteById(id);
    }

    public TypeSejour updateTypeSejour(Long id, TypeSejour typeSejour) {

        TypeSejour oldTypeSejourFound;

        Optional<TypeSejour> oldTypeSejour = typeSejourRepository.findById(id);

        if(oldTypeSejour.isPresent()) {
            oldTypeSejourFound = oldTypeSejour.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(typeSejour.getId_type_sej() != 0 ) { oldTypeSejourFound.setId_type_sej(typeSejour.getId_type_sej());}
        if(typeSejour.getLib_sej()!= null ) { oldTypeSejourFound.setLib_sej(typeSejour.getLib_sej());}
        if(typeSejour.getSej_majoration()!= 0 ) { oldTypeSejourFound.setSej_majoration(typeSejour.getSej_majoration());}
        return typeSejourRepository.save(oldTypeSejourFound);
    }

}
