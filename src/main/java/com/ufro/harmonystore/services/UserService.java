package com.ufro.harmonystore.services;

import com.ufro.harmonystore.models.Admin;
import com.ufro.harmonystore.models.Client;
import com.ufro.harmonystore.models.User;
import com.ufro.harmonystore.repository.usuarios.AdminRepository;
import com.ufro.harmonystore.repository.usuarios.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Service
public class UserService {

    final ClienteRepository clienteRepository;
    final AdminRepository adminRepository;

    public UserService(ClienteRepository clienteRepository, AdminRepository adminRepository) {
        this.clienteRepository = clienteRepository;
        this.adminRepository = adminRepository;
    }

    public void createUsuario(HashMap<String, String> atributos, boolean isAdmin){
        if(isAdmin){
            Admin admin = (Admin) ObjectService.buildObject(new Admin(), atributos);
            saveUsuario(admin, true);
        }
        else {
            Client cliente = (Client) ObjectService.buildObject(new Client(), atributos);
            saveUsuario(cliente, false);
        }
    }
    public String getActualDAte(){
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaActual.format(formatter);
    }

    private boolean validateRut(String rut) {
        rut = rut.replace(".", "").replace("-", "");
        if (rut.length() < 9) {
            return false;
        }
        char dv = rut.charAt(rut.length() - 1);
        String rutNumeros = rut.substring(0, rut.length() - 1);

        try {
            int rutParsed = Integer.parseInt(rutNumeros);
            int m = 0, s = 1;
            for (; rutParsed != 0; rutParsed /= 10) {
                s = (s + rutParsed % 10 * (9 - m++ % 6)) % 11;
            }
            char dvEsperado = (char) (s != 0 ? s + 47 : 75);

            return Character.toUpperCase(dv) == Character.toUpperCase(dvEsperado);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //CRUD
    public User getUserByRut(String rut, boolean isAdmin){
        if(isAdmin){ return adminRepository.findByRut(rut); }
        else{ return clienteRepository.findByRut(rut); }
    }

    public void saveUsuario(User usuario, boolean isAdmin){
        if(isAdmin){ adminRepository.save((Admin) usuario); }
        else{ clienteRepository.save((Client) usuario); }
    }
    public Iterable<Client> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public void deleteClient(int id) {
        clienteRepository.deleteById(id);
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

    public Iterable<Admin> obtenerAdmins(){
        return adminRepository.findAll();
    }
}
