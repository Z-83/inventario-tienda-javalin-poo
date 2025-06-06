package com.inventario.app.model;

import java.time.LocalDateTime;

public class TransaccionInventario {
    private String id;
    private String productoId;
    private int cantidad;
    private String tipoTransaccion;
    private LocalDateTime fechaTransaccion;
    private String usuarioId;
    private String descripcion;

    public TransaccionInventario(String id, String productoId, int cantidad, String tipoTransaccion, LocalDateTime fechaTransaccion, String usuarioId, String descripcion) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.usuarioId = usuarioId;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getProductoId() {
        return productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}