package com.inventario.app.repository;

import com.inventario.app.model.Factura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FacturaRepository {

    private static final Map<String, Factura> facturas = new HashMap<>();

    public Factura save(Factura factura) {
        facturas.put(factura.getId(), factura);
        return factura;
    }

    public Optional<Factura> findById(String id) {
        return Optional.ofNullable(facturas.get(id));
    }

    public List<Factura> findAll() {
        return new ArrayList<>(facturas.values());
    }

    public boolean update(Factura factura) {
        if (facturas.containsKey(factura.getId())) {
            facturas.put(factura.getId(), factura);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return facturas.remove(id) != null;
    }
}