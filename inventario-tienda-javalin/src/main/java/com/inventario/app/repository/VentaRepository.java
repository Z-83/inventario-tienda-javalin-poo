package com.inventario.app.repository;

import com.inventario.app.model.Venta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VentaRepository {

    private final List<Venta> ventas = new ArrayList<>();

    public VentaRepository() {

        save(new Venta(UUID.randomUUID().toString(), "cliente123", LocalDateTime.now(), 150.75, "Completada"));
        save(new Venta(UUID.randomUUID().toString(), "cliente456", LocalDateTime.now().minusDays(5), 230.00, "Pendiente"));
    }

    public Venta save(Venta venta) {
        if (venta.getId() == null || venta.getId().isEmpty()) {
            venta.setId(UUID.randomUUID().toString());
        }

        Optional<Venta> existingVenta = findById(venta.getId());
        if (existingVenta.isPresent()) {
            Venta v = existingVenta.get();
            v.setClienteId(venta.getClienteId());
            v.setFechaVenta(venta.getFechaVenta());
            v.setTotal(venta.getTotal());
            v.setEstado(venta.getEstado());
            return v;
        } else {
            ventas.add(venta);
            return venta;
        }
    }

    public List<Venta> findAll() {
        return new ArrayList<>(ventas);
    }

    public Optional<Venta> findById(String id) {
        return ventas.stream()
                .filter(venta -> venta.getId().equals(id))
                .findFirst();
    }

    public boolean update(Venta venta) {
        Optional<Venta> existingVenta = findById(venta.getId());
        if (existingVenta.isPresent()) {
            Venta v = existingVenta.get();
            v.setClienteId(venta.getClienteId());
            v.setFechaVenta(venta.getFechaVenta());
            v.setTotal(venta.getTotal());
            v.setEstado(venta.getEstado());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return ventas.removeIf(venta -> venta.getId().equals(id));
    }
}
