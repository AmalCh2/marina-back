package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Quai;
import com.arabsoft.marinaBack.repository.QuaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuaiService {

    @Autowired
    QuaiRepository quaiRepository;

    public List<Quai> getAllQuais() {
        return quaiRepository.findAll();
    }
    public Quai getQuaiById(Long id) {
        Quai quai = quaiRepository.findById(id).orElse(null);
        System.out.println("getQuaiById result : " + quai);
        return quai;
    }

    public Quai addQuai(Quai quai) {
        Quai quaiCreated = quaiRepository.save(quai);
        return quaiCreated;
    }

    public void deleteQuaiByEmail(Long id) {
        quaiRepository.deleteById(id);
    }

    public Quai updateQuai(Long id, Quai quai) {

        Quai oldQuaiFound;

        Optional<Quai> oldQuai = quaiRepository.findById(id);

        if(oldQuai.isPresent()) {
            oldQuaiFound = oldQuai.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(quai.getId_quai() != 0 ) { oldQuaiFound.setId_quai(quai.getId_quai());}
        if(quai.getDesig_quai()!= null ) { oldQuaiFound.setDesig_quai(quai.getDesig_quai());}
        if(quai.getRang_quai()!= 0 ) { oldQuaiFound.setRang_quai(quai.getRang_quai());}

        return quaiRepository.save(oldQuaiFound);
    }

}
