package com.inventario.app.repository;

import com.inventario.app.model.DetalleVenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DetalleVentaRepository {

    private final List<DetalleVenta> detallesVenta = new ArrayList<>();

    public DetalleVentaRepository() {

        save(new DetalleVenta(UUID.randomUUID().toString(), "venta001", "prodA", 2, 50.0));
        save(new DetalleVenta(UUID.randomUUID().toString(), "venta001", "prodB", 1, 100.0));
        save(new DetalleVenta(UUID.randomUUID().toString(), "venta002", "prodC", 3, 25.5));
    }

    public DetalleVenta save(DetalleVenta detalleVenta) {
        if (detalleVenta.getId() == null || detalleVenta.getId().isEmpty()) {
            detalleVenta.setId(UUID.randomUUID().toString());
        }

        Optional<DetalleVenta> existingDetalle = findById(detalleVenta.getId());
        if (existingDetalle.isPresent()) {
            DetalleVenta d = existingDetalle.get();
            d.setVentaId(detalleVenta.getVentaId());
            d.setProductoId(detalleVenta.getProductoId());
            d.setCantidad(detalleVenta.getCantidad());
            d.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            return d;
        } else {
            detallesVenta.add(detalleVenta);
            return detalleVenta;
        }
    }

    public List<DetalleVenta> findAll() {
        return new ArrayList<>(detallesVenta);
    }

    public Optional<DetalleVenta> findById(String id) {
        return detallesVenta.stream()
                .filter(detalle -> detalle.getId().equals(id))
                .findFirst();
    }

    public boolean update(DetalleVenta detalleVenta) {
        Optional<DetalleVenta> existingDetalle = findById(detalleVenta.getId());
        if (existingDetalle.isPresent()) {
            DetalleVenta d = existingDetalle.get();
            d.setVentaId(detalleVenta.getVentaId());
            d.setProductoId(detalleVenta.getProductoId());
            d.setCantidad(detalleVenta.getCantidad());
            d.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return detallesVenta.removeIf(detalle -> detalle.getId().equals(id));
    }
}