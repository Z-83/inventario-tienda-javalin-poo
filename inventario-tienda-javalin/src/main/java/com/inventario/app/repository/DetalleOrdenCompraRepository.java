package com.inventario.app.repository;

import com.inventario.app.model.DetalleOrdenCompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DetalleOrdenCompraRepository {

    private final List<DetalleOrdenCompra> detallesOrdenCompra = new ArrayList<>();

    public DetalleOrdenCompraRepository() {

        save(new DetalleOrdenCompra(UUID.randomUUID().toString(), "oc001", "prodX", 5, 25.0));
        save(new DetalleOrdenCompra(UUID.randomUUID().toString(), "oc001", "prodY", 2, 60.0));
        save(new DetalleOrdenCompra(UUID.randomUUID().toString(), "oc002", "prodZ", 10, 15.0));
    }

    public DetalleOrdenCompra save(DetalleOrdenCompra detalleOrdenCompra) {
        if (detalleOrdenCompra.getId() == null || detalleOrdenCompra.getId().isEmpty()) {
            detalleOrdenCompra.setId(UUID.randomUUID().toString());
        }

        Optional<DetalleOrdenCompra> existingDetalle = findById(detalleOrdenCompra.getId());
        if (existingDetalle.isPresent()) {
            DetalleOrdenCompra d = existingDetalle.get();
            d.setOrdenCompraId(detalleOrdenCompra.getOrdenCompraId());
            d.setProductoId(detalleOrdenCompra.getProductoId());
            d.setCantidad(detalleOrdenCompra.getCantidad());
            d.setCostoUnitario(detalleOrdenCompra.getCostoUnitario());
            return d;
        } else {
            detallesOrdenCompra.add(detalleOrdenCompra);
            return detalleOrdenCompra;
        }
    }

    public List<DetalleOrdenCompra> findAll() {
        return new ArrayList<>(detallesOrdenCompra);
    }

    public Optional<DetalleOrdenCompra> findById(String id) {
        return detallesOrdenCompra.stream()
                .filter(detalle -> detalle.getId().equals(id))
                .findFirst();
    }

    public boolean update(DetalleOrdenCompra detalleOrdenCompra) {
        Optional<DetalleOrdenCompra> existingDetalle = findById(detalleOrdenCompra.getId());
        if (existingDetalle.isPresent()) {
            DetalleOrdenCompra d = existingDetalle.get();
            d.setOrdenCompraId(detalleOrdenCompra.getOrdenCompraId());
            d.setProductoId(detalleOrdenCompra.getProductoId());
            d.setCantidad(detalleOrdenCompra.getCantidad());
            d.setCostoUnitario(detalleOrdenCompra.getCostoUnitario());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return detallesOrdenCompra.removeIf(detalle -> detalle.getId().equals(id));
    }
}
