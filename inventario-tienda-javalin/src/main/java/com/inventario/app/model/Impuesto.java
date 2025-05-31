package com.inventario.app.model;

public class Impuesto {
    private String id;
    private String nombre;
    private String descripcion;
    private double tasa;


    public Impuesto(String id, String nombre, String descripcion, double tasa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tasa = tasa;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }
}