package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Bateau;
import com.arabsoft.marinaBack.repository.BateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BateauService {

    @Autowired
    BateauRepository bateauRepository;

    public List<Bateau> getAllBateaux() {
        return bateauRepository.findAll();
    }
    public Bateau getBateauById(Long id) {
        Bateau bateau = bateauRepository.findById(id).orElse(null);
        System.out.println("getBateauById result : " + bateau);
        return bateau;
    }


    public int getTotalBateauDansPort(Long id_port){
        return bateauRepository.getTotalBateauDansPort(id_port);
    }
    public Bateau addBateau(Bateau bateau) {
        Bateau bateauCreated = bateauRepository.save(bateau);
        return bateauCreated;
    }

    public void deleteBateauByEmail(Long id) {
        bateauRepository.deleteById(id);
    }

    public Bateau updateBateau(Long id, Bateau bateau) {

        Bateau oldBateauFound;

        Optional<Bateau> oldBateau = bateauRepository.findById(id);

        if(oldBateau.isPresent()) {
            oldBateauFound = oldBateau.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(bateau.getId_bat() != 0 ) { oldBateauFound.setId_bat(bateau.getId_bat());}
        if(bateau.getImmatriculation_bat()!= null ) { oldBateauFound.setImmatriculation_bat(bateau.getImmatriculation_bat());}
        if(bateau.getAutre_ident_nom_bat() != null ) { oldBateauFound.setAutre_ident_nom_bat(bateau.getAutre_ident_nom_bat());}
        if(bateau.getNom_bat() != null ) { oldBateauFound.setNom_bat(bateau.getNom_bat());}
        if(bateau.getLargeur_bat() != 0 ) { oldBateauFound.setLargeur_bat(bateau.getLargeur_bat());}
        if(bateau.getLongueur_bat() != 0 ) { oldBateauFound.setLongueur_bat(bateau.getLongueur_bat());}
        if(bateau.getTirant_eau_bat() != 0 ) { oldBateauFound.setTirant_eau_bat(bateau.getTirant_eau_bat());}
        if(bateau.getTonnage_bat() != 0 ) { oldBateauFound.setTonnage_bat(bateau.getTonnage_bat());}
        if(bateau.getPavillon_bat() != null ) { oldBateauFound.setPavillon_bat(bateau.getPavillon_bat());}
        if(bateau.getMarque_bat() != null ) { oldBateauFound.setPavillon_bat(bateau.getPavillon_bat());}
        if(bateau.getNum_assur() != 0 ) { oldBateauFound.setNum_assur(bateau.getNum_assur());}
        if(bateau.getNom_assur() != null ) { oldBateauFound.setNom_assur(bateau.getNom_assur());}
        if(bateau.getDate_exp() != null ) { oldBateauFound.setDate_exp(bateau.getDate_exp());}/***************************************************************/
        if(bateau.getAdresse_bat()!= null ) { oldBateauFound.setAdresse_bat(bateau.getAdresse_bat());}
        if(bateau.getCode_postal_bat() != 0 ) { oldBateauFound.setCode_postal_bat(bateau.getCode_postal_bat());}
        if(bateau.getVille_bat()!= null ) { oldBateauFound.setVille_bat(bateau.getVille_bat());}
        if(bateau.getPays()!= null ) { oldBateauFound.setPays(bateau.getPays());}
        if(bateau.getTel_bat()!= null ) { oldBateauFound.setTel_bat(bateau.getTel_bat());}
        if(bateau.getFax_bat()!= null ) { oldBateauFound.setFax_bat(bateau.getFax_bat());}
        if(bateau.getMobile_bat()!= null ) { oldBateauFound.setMobile_bat(bateau.getMobile_bat());}
        if(bateau.getEmail_bat()!= null ) { oldBateauFound.setEmail_bat(bateau.getEmail_bat());}
        if(bateau.getObservation()!= null ) { oldBateauFound.setObservation(bateau.getObservation());}
        if(bateau.getDate_mvt() != null ) { oldBateauFound.setDate_mvt(bateau.getDate_mvt());}/***************************************************************/
        if(bateau.getDepart_mvt() != null ) { oldBateauFound.setDepart_mvt(bateau.getDepart_mvt());}/***************************************************************/
        if(bateau.getArrivee_mvt() != null ) { oldBateauFound.setArrivee_mvt(bateau.getArrivee_mvt());}/***************************************************************/


        return bateauRepository.save(oldBateauFound);
    }

}
