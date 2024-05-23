package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
