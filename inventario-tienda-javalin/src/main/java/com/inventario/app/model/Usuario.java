package com.inventario.app.model;

public class Usuario {
    private String id;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private String rolId;

    public Usuario(String id, String nombreUsuario, String contrasena, String email, String rolId) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.rolId = rolId;
    }

    public String getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public String getRolId() {
        return rolId;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }
}