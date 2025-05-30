package com.inventario.app.repository;

import com.inventario.app.model.MetodoPago;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MetodoPagoRepository {

    private final List<MetodoPago> metodosPago = new ArrayList<>();

    public MetodoPagoRepository() {

        save(new MetodoPago(UUID.randomUUID().toString(), "Tarjeta de Credito", "Online"));
        save(new MetodoPago(UUID.randomUUID().toString(), "Efectivo", "Fisico"));
        save(new MetodoPago(UUID.randomUUID().toString(), "Transferencia Bancaria", "Online"));
    }

    public MetodoPago save(MetodoPago metodoPago) {
        if (metodoPago.getId() == null || metodoPago.getId().isEmpty()) {
            metodoPago.setId(UUID.randomUUID().toString());
        }

        Optional<MetodoPago> existingMetodo = findById(metodoPago.getId());
        if (existingMetodo.isPresent()) {
            MetodoPago m = existingMetodo.get();
            m.setNombre(metodoPago.getNombre());
            m.setTipo(metodoPago.getTipo());
            return m;
        } else {
            metodosPago.add(metodoPago);
            return metodoPago;
        }
    }

    public List<MetodoPago> findAll() {
        return new ArrayList<>(metodosPago);
    }

    public Optional<MetodoPago> findById(String id) {
        return metodosPago.stream()
                .filter(metodo -> metodo.getId().equals(id))
                .findFirst();
    }

    public boolean update(MetodoPago metodoPago) {
        Optional<MetodoPago> existingMetodo = findById(metodoPago.getId());
        if (existingMetodo.isPresent()) {
            MetodoPago m = existingMetodo.get();
            m.setNombre(metodoPago.getNombre());
            m.setTipo(metodoPago.getTipo());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return metodosPago.removeIf(metodo -> metodo.getId().equals(id));
    }
}