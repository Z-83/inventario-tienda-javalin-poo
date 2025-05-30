package com.inventario.app.model;

import java.time.LocalDate;
import java.util.Objects;

public class OrdenCompra {
    private String id;
    private String proveedorId;
    private LocalDate fechaOrden;
    private double totalOrden;
    private String estado;

    public OrdenCompra() {
    }

    public OrdenCompra(String id, String proveedorId, LocalDate fechaOrden, double totalOrden, String estado) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.fechaOrden = fechaOrden;
        this.totalOrden = totalOrden;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(double totalOrden) {
        this.totalOrden = totalOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenCompra that = (OrdenCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "id='" + id + '\'' +
                ", proveedorId='" + proveedorId + '\'' +
                ", fechaOrden=" + fechaOrden +
                ", totalOrden=" + totalOrden +
                ", estado='" + estado + '\'' +
                '}';
    }
}