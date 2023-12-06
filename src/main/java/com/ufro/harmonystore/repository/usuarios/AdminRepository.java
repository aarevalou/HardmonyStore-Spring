package com.ufro.harmonystore.repository.usuarios;

import com.ufro.harmonystore.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Admin findByRut(String rut);

}
