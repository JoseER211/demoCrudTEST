package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public ArrayList<UsuarioRol> obtenerRoles() {
        return (ArrayList<UsuarioRol>) rolRepository.findAll();
    }


    public UsuarioRol guardarRol(UsuarioRol usuarioRol) {
        return rolRepository.save(usuarioRol);
    }

    public Optional<UsuarioRol> obtenerRolPorId(Long id) {
        return rolRepository.findById(id);
    }

    public ArrayList<UsuarioRol> obtenerPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    public boolean eliminarRol(Long id) {
        try {
            rolRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}


