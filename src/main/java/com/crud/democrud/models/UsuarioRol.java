package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = UsuarioModel.class)
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference
    private UsuarioModel usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public UsuarioRol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public UsuarioRol() {
    }
}
