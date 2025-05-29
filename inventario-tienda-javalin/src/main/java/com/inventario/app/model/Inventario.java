package com.inventario.app.model;

import java.util.Objects;

public class Inventario {
    private String id;
    private String productoId;
    private String ubicacion;
    private int cantidad;

    public Inventario() {
    }

    public Inventario(String id, String productoId, String ubicacion, int cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id='" + id + '\'' +
                ", productoId='" + productoId + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", cantidad=" + cantidad +
           '}';
    }
}