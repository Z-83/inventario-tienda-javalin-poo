package com.inventario.app.repository;

import com.inventario.app.model.Impuesto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImpuestoRepository {
    private Map<String, Impuesto> impuestos = new HashMap<>();

    public ImpuestoRepository() {

    }

    public Impuesto save(Impuesto impuesto) {
        impuestos.put(impuesto.getId(), impuesto);
        return impuesto;
    }

    public Optional<Impuesto> findById(String id) {
        return Optional.ofNullable(impuestos.get(id));
    }

    public List<Impuesto> findAll() {
        return List.copyOf(impuestos.values());
    }

    public boolean update(Impuesto impuesto) {
        if (impuestos.containsKey(impuesto.getId())) {
            impuestos.put(impuesto.getId(), impuesto);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return impuestos.remove(id) != null;
    }
}