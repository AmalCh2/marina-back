package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Port;
import com.arabsoft.marinaBack.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/port")
public class PortController {

    @Autowired
    PortService portService;

    //http://localhost:8080/port/get-all-ports
    @GetMapping("/get-all-ports")
    @ResponseBody
    public List<Port> getAllPorts() {
        return portService.getAllPorts();
    }

    //http://localhost:8080/port/get-port-by-id/2
    @GetMapping("/get-port-by-id/{portId}")
    @ResponseBody
    public Port getPortById(@PathVariable("portId") Long portId) {
        return portService.getPortById(portId);
    }

    //http://localhost:8080/port/add-port
    @PostMapping("/add-port")
    @ResponseBody
    public Port addPort(@RequestBody Port port) {
        Port portCreated = portService.addPort(port);
        return portCreated;
    }

    //http://localhost:8080/port/delete-port/2
    @DeleteMapping("/delete-port/{id}")
    public ResponseEntity<Void> deletePortById(@PathVariable("id") Long id) {
        //public void deletePortById(@PathVariable("id") Long id) {

        portService.deletePortByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/port/update-port/4
    @PutMapping("/update-port/{id}")
    public ResponseEntity<?> updatePort(@PathVariable("id") Long id, @RequestBody Port port) {
        try {
            Port portUpdated = portService.updatePort(id, port);
            return ResponseEntity.ok(portUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }


    //http://localhost:8080/port/get-getPort-Details/2
    @GetMapping("/get-getPort-Details/{portId}")
    public ResponseEntity<Port> getPortDetails(@PathVariable("portId") Long portId) {
        Port port = portService.getPortById(portId);
        if (port != null) {
            return new ResponseEntity<>(port, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

