package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Port;
import com.arabsoft.marinaBack.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortService {

    @Autowired
    PortRepository userRepository;

    public List<Port> getAllPorts() {
        return userRepository.findAll();
    }
    public Port getPortById(Long id) {
        Port user = userRepository.findById(id).orElse(null);
        System.out.println("getPortById result : " + user);
        return user;
    }

    public Port addPort(Port user) {
        Port userCreated = userRepository.save(user);
        return userCreated;
    }

    public void deletePortByEmail(Long id) {
        userRepository.deleteById(id);
    }

    public Port updatePort(Long id, Port user) {

        Port oldPortFound;

        Optional<Port> oldPort = userRepository.findById(id);

        if(oldPort.isPresent()) {
            oldPortFound = oldPort.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(user.getId_port() != null ) { oldPortFound.setId_port(user.getId_port());}
        if(user.getAdr1_port() != null ) { oldPortFound.setAdr1_port(user.getAdr1_port());}
        if(user.getAdr2_port() != null ) { oldPortFound.setAdr2_port(user.getAdr2_port());}
        if(user.getAdr3_port() != null ) { oldPortFound.setAdr3_port(user.getAdr3_port());}
        if(user.getTel_port() != null ) { oldPortFound.setTel_port(user.getTel_port());}
        if(user.getFax_port() != null ) { oldPortFound.setFax_port(user.getFax_port());}
        if(user.getEmail_port() != null ) { oldPortFound.setEmail_port(user.getEmail_port());}
        if(user.getSigle_port() != null ) { oldPortFound.setSigle_port(user.getSigle_port());}
        return userRepository.save(oldPortFound);
    }
}
