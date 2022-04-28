package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/usuario/rol")
@RestController
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<UsuarioRol> obtenerRoles() {
        return rolService.obtenerRoles();
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioRol> obtenerRolPorId(@PathVariable("id") Long id) {
        return this.rolService.obtenerRolPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioRol> obtenerRolPorNombre(@RequestParam("nombre") String nombre) {
        return this.rolService.obtenerPorNombre(nombre);
    }

    @PostMapping()
    public UsuarioRol guardarRol(@RequestBody UsuarioRol usuarioRol) {
        return this.rolService.guardarRol(usuarioRol);
    }

    @PutMapping(path = "/actualizar")
    public UsuarioRol editarRol(@RequestBody UsuarioRol usuarioRol) {
        return this.rolService.guardarRol(usuarioRol);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarRolPorId(@PathVariable("id") Long id) {
        boolean ok = this.rolService.eliminarRol(id);
        if (ok) {
            return "Se eliminó el rol con id " + id;
        } else {
            return "No pudo eliminar el rol con id" + id;
        }
    }

}
