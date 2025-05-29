package com.inventario.app.repository;

import com.inventario.app.model.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProveedorRepository {

    private final List<Proveedor> proveedores = new ArrayList<>();

    public ProveedorRepository() {
        // Datos de ejemplo
        save(new Proveedor(UUID.randomUUID().toString(), "Tech Supplies Inc.", "ventas@techsupplies.com", "101 Tech Way"));
        save(new Proveedor(UUID.randomUUID().toString(), "Global Foods Ltd.", "info@globalfoods.net", "456 Food Blvd"));
    }

    public Proveedor save(Proveedor proveedor) {
        if (proveedor.getId() == null || proveedor.getId().isEmpty()) {
            proveedor.setId(UUID.randomUUID().toString());
        }

        Optional<Proveedor> existingProveedor = findById(proveedor.getId());
        if (existingProveedor.isPresent()) {
            Proveedor p = existingProveedor.get();
            p.setNombre(proveedor.getNombre());
            p.setContacto(proveedor.getContacto());
            p.setDireccion(proveedor.getDireccion());
            return p;
        } else {
            proveedores.add(proveedor);
            return proveedor;
        }
    }

    public List<Proveedor> findAll() {
        return new ArrayList<>(proveedores);
    }

    public Optional<Proveedor> findById(String id) {
        return proveedores.stream()
                .filter(proveedor -> proveedor.getId().equals(id))
                .findFirst();
    }

    public boolean update(Proveedor proveedor) {
        Optional<Proveedor> existingProveedor = findById(proveedor.getId());
        if (existingProveedor.isPresent()) {
            Proveedor p = existingProveedor.get();
            p.setNombre(proveedor.getNombre());
            p.setContacto(proveedor.getContacto());
            p.setDireccion(proveedor.getDireccion());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return proveedores.removeIf(proveedor -> proveedor.getId().equals(id));
    }
}