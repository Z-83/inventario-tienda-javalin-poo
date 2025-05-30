package com.inventario.app.repository;

import com.inventario.app.model.Sucursal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SucursalRepository {

    private final List<Sucursal> sucursales = new ArrayList<>();

    public SucursalRepository() {

        save(new Sucursal(UUID.randomUUID().toString(), "Sucursal Principal", "Calle 10 #12-34", "6011234567", "Bogota"));
        save(new Sucursal(UUID.randomUUID().toString(), "Sucursal Norte", "Carrera 15 #20-56", "6017654321", "Medellin"));
    }

    public Sucursal save(Sucursal sucursal) {
        if (sucursal.getId() == null || sucursal.getId().isEmpty()) {
            sucursal.setId(UUID.randomUUID().toString());
        }

        Optional<Sucursal> existingSucursal = findById(sucursal.getId());
        if (existingSucursal.isPresent()) {
            Sucursal s = existingSucursal.get();
            s.setNombre(sucursal.getNombre());
            s.setDireccion(sucursal.getDireccion());
            s.setTelefono(sucursal.getTelefono());
            s.setCiudad(sucursal.getCiudad());
            return s;
        } else {
            sucursales.add(sucursal);
            return sucursal;
        }
    }

    public List<Sucursal> findAll() {
        return new ArrayList<>(sucursales);
    }

    public Optional<Sucursal> findById(String id) {
        return sucursales.stream()
                .filter(sucursal -> sucursal.getId().equals(id))
                .findFirst();
    }

    public boolean update(Sucursal sucursal) {
        Optional<Sucursal> existingSucursal = findById(sucursal.getId());
        if (existingSucursal.isPresent()) {
            Sucursal s = existingSucursal.get();
            s.setNombre(sucursal.getNombre());
            s.setDireccion(sucursal.getDireccion());
            s.setTelefono(sucursal.getTelefono());
            s.setCiudad(sucursal.getCiudad());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return sucursales.removeIf(sucursal -> sucursal.getId().equals(id));
    }
}