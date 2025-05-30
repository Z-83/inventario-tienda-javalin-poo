package com.inventario.app.repository;

import com.inventario.app.model.OrdenCompra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrdenCompraRepository {

    private final List<OrdenCompra> ordenesCompra = new ArrayList<>();

    public OrdenCompraRepository() {

        save(new OrdenCompra(UUID.randomUUID().toString(), "prov1", LocalDate.now(), 500.0, "Pendiente"));
        save(new OrdenCompra(UUID.randomUUID().toString(), "prov2", LocalDate.now().minusDays(10), 1200.50, "Recibida"));
    }

    public OrdenCompra save(OrdenCompra ordenCompra) {
        if (ordenCompra.getId() == null || ordenCompra.getId().isEmpty()) {
            ordenCompra.setId(UUID.randomUUID().toString());
        }

        Optional<OrdenCompra> existingOrden = findById(ordenCompra.getId());
        if (existingOrden.isPresent()) {
            OrdenCompra o = existingOrden.get();
            o.setProveedorId(ordenCompra.getProveedorId());
            o.setFechaOrden(ordenCompra.getFechaOrden());
            o.setTotalOrden(ordenCompra.getTotalOrden());
            o.setEstado(ordenCompra.getEstado());
            return o;
        } else {
            ordenesCompra.add(ordenCompra);
            return ordenCompra;
        }
    }

    public List<OrdenCompra> findAll() {
        return new ArrayList<>(ordenesCompra);
    }

    public Optional<OrdenCompra> findById(String id) {
        return ordenesCompra.stream()
                .filter(orden -> orden.getId().equals(id))
                .findFirst();
    }

    public boolean update(OrdenCompra ordenCompra) {
        Optional<OrdenCompra> existingOrden = findById(ordenCompra.getId());
        if (existingOrden.isPresent()) {
            OrdenCompra o = existingOrden.get();
            o.setProveedorId(ordenCompra.getProveedorId());
            o.setFechaOrden(ordenCompra.getFechaOrden());
            o.setTotalOrden(ordenCompra.getTotalOrden());
            o.setEstado(ordenCompra.getEstado());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return ordenesCompra.removeIf(orden -> orden.getId().equals(id));
    }
}