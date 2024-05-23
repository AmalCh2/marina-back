package com.arabsoft.marinaBack.service;

import com.arabsoft.marinaBack.dto.Role;
import com.arabsoft.marinaBack.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Role getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        System.out.println("getRoleById result : " + role);
        return role;
    }

    public Role addRole(Role role) {
        Role roleCreated = roleRepository.save(role);
        return roleCreated;
    }

    public void deleteRoleByEmail(Long id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Long id, Role role) {

        Role oldRoleFound;

        Optional<Role> oldRole = roleRepository.findById(id);

        if(oldRole.isPresent()) {
            oldRoleFound = oldRole.get();
        } else {
            throw new RuntimeException("id not present in database -> No update to be done !!");
        }

        if(role.getId_role() != null ) { oldRoleFound.setId_role(role.getId_role());}
        if(role.getLib_role() != null ) { oldRoleFound.setLib_role(role.getLib_role());}
        return roleRepository.save(oldRoleFound);
    }
}
