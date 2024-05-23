package com.arabsoft.marinaBack.controller;

import com.arabsoft.marinaBack.dto.Role;
import com.arabsoft.marinaBack.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    //http://localhost:8080/role/get-all-roles
    @GetMapping("/get-all-roles")
    @ResponseBody
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    //http://localhost:8080/role/get-role-by-id/2
    @GetMapping("/get-role-by-id/{roleId}")
    @ResponseBody
    public Role getRoleById(@PathVariable("roleId") Long roleId) {
        return roleService.getRoleById(roleId);
    }

    //http://localhost:8080/role/add-role
    @PostMapping("/add-role")
    @ResponseBody
    public Role addRole(@RequestBody Role role) {
        Role roleCreated = roleService.addRole(role);
        return roleCreated;
    }

    //http://localhost:8080/role/delete-role/2
    @DeleteMapping("/delete-role/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Long id) {
        //public void deleteRoleById(@PathVariable("id") Long id) {

        roleService.deleteRoleByEmail(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/role/update-role/4
    @PutMapping("/update-role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
        try {
            Role roleUpdated = roleService.updateRole(id, role);
            return ResponseEntity.ok(roleUpdated); // Retourne un statut 200 OK avec l'utilisateur mis à jour
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found, No update !!.");
        }
    }


    //http://localhost:8080/role/get-getRole-Details/2
    /*
    @GetMapping("/get-getRole-Details/{roleId}")
    public ResponseEntity<Role> getRoleDetails(@PathVariable("roleId") Long roleId) {
        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            return new ResponseEntity<>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    */
}

