package com.inventario.app.repository;

import com.inventario.app.model.Descuento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DescuentoRepository {
    private Map<String, Descuento> descuentos = new HashMap<>();

    public DescuentoRepository() {

    }

    public Descuento save(Descuento descuento) {
        descuentos.put(descuento.getId(), descuento);
        return descuento;
    }

    public Optional<Descuento> findById(String id) {
        return Optional.ofNullable(descuentos.get(id));
    }

    public List<Descuento> findAll() {
        return List.copyOf(descuentos.values());
    }

    public boolean update(Descuento descuento) {
        if (descuentos.containsKey(descuento.getId())) {
            descuentos.put(descuento.getId(), descuento);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return descuentos.remove(id) != null;
    }
}