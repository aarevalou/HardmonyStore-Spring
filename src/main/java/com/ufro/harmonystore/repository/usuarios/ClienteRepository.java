package com.ufro.harmonystore.repository.usuarios;

import com.ufro.harmonystore.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Client, Integer> {
    Client findByRut(String rut);
}
