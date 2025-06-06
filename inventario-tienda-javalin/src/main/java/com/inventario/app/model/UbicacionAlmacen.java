package com.inventario.app.model;

public class UbicacionAlmacen {
    private String id;
    private String nombre;
    private String descripcion;
    private String sucursalId;

    public UbicacionAlmacen(String id, String nombre, String descripcion, String sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sucursalId = sucursalId;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }
}