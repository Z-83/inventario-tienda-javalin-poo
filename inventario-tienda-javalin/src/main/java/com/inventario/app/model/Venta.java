package com.inventario.app.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Venta {
    private String id;
    private String clienteId;
    private LocalDateTime fechaVenta;
    private double total;
    private String estado;

    public Venta() {
    }

    public Venta(String id, String clienteId, LocalDateTime fechaVenta, double total, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.estado = estado;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        Venta venta = (Venta) o;
        return Objects.equals(id, venta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id='" + id + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", fechaVenta=" + fechaVenta +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                '}';
    }
}
