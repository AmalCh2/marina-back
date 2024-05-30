package com.arabsoft.marinaBack.repository;

import com.arabsoft.marinaBack.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client WHERE archived = 0", nativeQuery = true)
    List<Client> afficher_client();

    @Query(value = "SELECT * FROM client WHERE archived = 1", nativeQuery = true)
    List<Client> afficher_archived_client();

}
