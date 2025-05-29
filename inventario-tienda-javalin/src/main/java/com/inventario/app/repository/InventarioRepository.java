package com.inventario.app.repository;

import com.inventario.app.model.Inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InventarioRepository {

    private final List<Inventario> inventarios = new ArrayList<>();

    public InventarioRepository() {
        // Datos de ejemplo (usando IDs de producto ficticios)
        save(new Inventario(UUID.randomUUID().toString(), "prodABC", "Almacen Central", 100));
        save(new Inventario(UUID.randomUUID().toString(), "prodXYZ", "Tienda Principal", 50));
    }

    public Inventario save(Inventario inventario) {
        if (inventario.getId() == null || inventario.getId().isEmpty()) {
            inventario.setId(UUID.randomUUID().toString());
        }

        Optional<Inventario> existingInventario = findById(inventario.getId());
        if (existingInventario.isPresent()) {
            Inventario i = existingInventario.get();
            i.setProductoId(inventario.getProductoId());
            i.setUbicacion(inventario.getUbicacion());
            i.setCantidad(inventario.getCantidad());
            return i;
        } else {
            inventarios.add(inventario);
            return inventario;
        }
    }

    public List<Inventario> findAll() {
        return new ArrayList<>(inventarios);
    }

    public Optional<Inventario> findById(String id) {
        return inventarios.stream()
                .filter(inventario -> inventario.getId().equals(id))
                .findFirst();
    }

    public boolean update(Inventario inventario) {
        Optional<Inventario> existingInventario = findById(inventario.getId());
        if (existingInventario.isPresent()) {
            Inventario i = existingInventario.get();
            i.setProductoId(inventario.getProductoId());
            i.setUbicacion(inventario.getUbicacion());
            i.setCantidad(inventario.getCantidad());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return inventarios.removeIf(inventario -> inventario.getId().equals(id));
    }
}