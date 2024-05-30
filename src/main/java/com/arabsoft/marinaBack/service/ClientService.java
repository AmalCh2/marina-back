package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Client;
import com.arabsoft.marinaBack.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        System.out.println("getClientById result : " + client);
        return client;
    }

    public List<Client> getClients() {
        return clientRepository.afficher_client();
    }

    public List<Client> getArchievedClients() {
        return clientRepository.afficher_archived_client();
    }




    public Client addClient(Client client) {
        Client clientCreated = clientRepository.save(client);
        return clientCreated;
    }

    public void deleteClientByEmail(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client client) {

        Client oldClientFound;

        Optional<Client> oldClient = clientRepository.findById(id);

        if(oldClient.isPresent()) {
            oldClientFound = oldClient.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }


        if(client.getId_cli() != 0 ) { oldClientFound.setId_cli(client.getId_cli());}
        if(client.getNom_cli()!= null ) { oldClientFound.setNom_cli(client.getNom_cli());}
        if(client.getPrenom_cli()!= null ) { oldClientFound.setPrenom_cli(client.getPrenom_cli());}
        if(client.getEtat_civil()!= null ) { oldClientFound.setEtat_civil(client.getEtat_civil());}
        if(client.getAdresse_cli()!= null ) { oldClientFound.setAdresse_cli(client.getAdresse_cli());}
        if(client.getCode_postal_cli()!= 0 ) { oldClientFound.setCode_postal_cli(client.getCode_postal_cli());}
        if(client.getVille_cli()!= null ) { oldClientFound.setVille_cli(client.getVille_cli());}
        if(client.getTel_cli()!= null ) { oldClientFound.setTel_cli(client.getTel_cli());}
        if(client.getFax_cli()!= null ) { oldClientFound.setFax_cli(client.getFax_cli());}
        if(client.getMobile_cli()!= null ) { oldClientFound.setMobile_cli(client.getMobile_cli());}

        /*
        if(client.getExo_cli() != null ) { oldClientFound.setExo_cli(client.getExo_cli());}
        */

        if(client.getEmail_cli() != null ) { oldClientFound.setEmail_cli(client.getEmail_cli());}

        return clientRepository.save(oldClientFound);
    }


    public void archiveClient(long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setArchived(1);
            clientRepository.save(client);
        } else {
            throw new RuntimeException("Client not found");
        }
    }

}
