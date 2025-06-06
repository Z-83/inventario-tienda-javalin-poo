package com.inventario.app.model;

import java.time.LocalDateTime;


public class Factura {
    private String id;
    private String ventaId;
    private String clienteId;
    private LocalDateTime fechaEmision;
    private double total;

    public Factura(String id, String ventaId, String clienteId, LocalDateTime fechaEmision, double total) {
        this.id = id;
        this.ventaId = ventaId;
        this.clienteId = clienteId;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getVentaId() {
        return ventaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVentaId(String ventaId) {
        this.ventaId = ventaId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}