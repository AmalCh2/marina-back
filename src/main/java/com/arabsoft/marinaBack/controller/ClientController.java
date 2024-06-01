package com.arabsoft.marinaBack.controller;
import com.arabsoft.marinaBack.dto.Client;
import com.arabsoft.marinaBack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    //http://localhost:8080/client/get-all-clients
    @GetMapping("/get-all-clients")
    @ResponseBody
    public List<Client> getAllClients() {
            return clientService.getAllClients();
        }
        //http://localhost:8080/client/get-clients
        @GetMapping("/get-clients")
        @ResponseBody
        public List<Client> getClients() {
            return clientService.getClients();
        }

        //http://localhost:8080/client/get-archieved-clients
        @GetMapping("/get-archieved-clients")
        @ResponseBody
        public List<Client> getArchievedClientx() {
            return clientService.getArchievedClients();
        }

        //http://localhost:8080/client/get-client-by-id/2
        @GetMapping("/get-client-by-id/{clientId}")
        @ResponseBody
        public Client getClientById(@PathVariable("clientId") Long clientId) {
            return clientService.getClientById(clientId);
        }
        //http://localhost:8080/client/add-client
        @PostMapping("/add-client")
        @ResponseBody
        public Client addClient(@RequestBody Client client) {
            Client clientCreated = clientService.addClient(client);
            return clientCreated;
        }
        //http://localhost:8080/client/delete-client/2
        @DeleteMapping("/delete-client/{id}")
        public ResponseEntity<Void> deleteClientById(@PathVariable("id") Long id) {
            clientService.deleteClientByEmail(id);
            return ResponseEntity.ok().build();
        }
        //http://localhost:8080/client/update-client/4
        @PutMapping("/update-client/{id}")
        public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
            try {
                Client clientUpdated = clientService.updateClient(id, client);
                return ResponseEntity.ok(clientUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
            }
        }

        // http://localhost:8080/client/archive/1
        @PutMapping("/archive/{id}")
        public ResponseEntity<Void> archiveClient(@PathVariable long id) {
            clientService.archiveClient(id);
            return ResponseEntity.ok().build();
        }

    }