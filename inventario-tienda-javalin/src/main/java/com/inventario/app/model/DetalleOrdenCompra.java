package com.inventario.app.model;

import java.util.Objects;

public class DetalleOrdenCompra {
    private String id;
    private String ordenCompraId;
    private String productoId;
    private int cantidad;
    private double costoUnitario;

    public DetalleOrdenCompra() {
    }

    public DetalleOrdenCompra(String id, String ordenCompraId, String productoId, int cantidad, double costoUnitario) {
        this.id = id;
        this.ordenCompraId = ordenCompraId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(String ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleOrdenCompra that = (DetalleOrdenCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DetalleOrdenCompra{" +
                "id='" + id + '\'' +
                ", ordenCompraId='" + ordenCompraId + '\'' +
                ", productoId='" + productoId + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
