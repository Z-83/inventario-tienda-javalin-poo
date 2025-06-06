package com.inventario.app.repository;

import com.inventario.app.model.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductoRepository {

    private static final Map<String, Producto> productos = new HashMap<>();

    public ProductoRepository() {
    }

    public Producto save(Producto producto) {
        productos.put(producto.getId(), producto);
        return producto;
    }

    public Optional<Producto> findById(String id) {
        return Optional.ofNullable(productos.get(id));
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos.values());
    }

    public boolean update(Producto producto) {
        if (productos.containsKey(producto.getId())) {
            productos.put(producto.getId(), producto);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return productos.remove(id) != null;
    }
}
