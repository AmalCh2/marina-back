package com.arabsoft.marinaBack.service;

        import com.arabsoft.marinaBack.dto.Emplacement;
        import com.arabsoft.marinaBack.repository.EmplacementRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

@Service
public class EmplacementService {

    @Autowired
    EmplacementRepository emplacementRepository;

    public List<Emplacement> getAllEmplacements() {
        return emplacementRepository.findAll();
    }
    public Emplacement getEmplacementById(Long id) {
        Emplacement emplacement = emplacementRepository.findById(id).orElse(null);
        System.out.println("getEmplacementById result : " + emplacement);
        return emplacement;
    }

    public Emplacement addEmplacement(Emplacement emplacement) {
        Emplacement emplacementCreated = emplacementRepository.save(emplacement);
        return emplacementCreated;
    }

    public void deleteEmplacementByEmail(Long id) {
        emplacementRepository.deleteById(id);
    }

    public Emplacement updateEmplacement(Long id, Emplacement emplacement) {

        Emplacement oldEmplacementFound;

        Optional<Emplacement> oldEmplacement = emplacementRepository.findById(id);

        if(oldEmplacement.isPresent()) {
            oldEmplacementFound = oldEmplacement.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(emplacement.getId_emp() != 0 ) { oldEmplacementFound.setId_emp(emplacement.getId_emp());}
        if(emplacement.getLargeur_emp()!= 0 ) { oldEmplacementFound.setLargeur_emp(emplacement.getLargeur_emp());}
        if(emplacement.getLongueur_emp()!= 0 ) { oldEmplacementFound.setLongueur_emp(emplacement.getLongueur_emp());}
        if(emplacement.getTirant_eau_emp()!= 0 ) { oldEmplacementFound.setTirant_eau_emp(emplacement.getTirant_eau_emp());}
        if(emplacement.getTel_port()!= null ) { oldEmplacementFound.setTel_port(emplacement.getTel_port());}
        if(emplacement.getDirection_emp()!= null ) { oldEmplacementFound.setDirection_emp(emplacement.getDirection_emp());}
        if(emplacement.getType_cord_emp()!= null ) { oldEmplacementFound.setType_cord_emp(emplacement.getType_cord_emp());}
        if(emplacement.getCommentaire()!= null ) { oldEmplacementFound.setCommentaire(emplacement.getCommentaire());}
        if(emplacement.getNbr_mouillage_emp()!= 0 ) { oldEmplacementFound.setNbr_mouillage_emp(emplacement.getNbr_mouillage_emp());}
        if(emplacement.getRang()!= 0 ) { oldEmplacementFound.setRang(emplacement.getRang());}
        //if(emplacement.getBlockage()!= null ) { oldEmplacementFound.setBlockage(emplacement.getBlockage());}


        return emplacementRepository.save(oldEmplacementFound);
    }

}
