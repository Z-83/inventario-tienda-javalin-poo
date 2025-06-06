package com.inventario.app.repository;

import com.inventario.app.model.TransaccionInventario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TransaccionInventarioRepository {

    private static final Map<String, TransaccionInventario> transacciones = new HashMap<>();

    public TransaccionInventario save(TransaccionInventario transaccion) {
        transacciones.put(transaccion.getId(), transaccion);
        return transaccion;
    }

    public Optional<TransaccionInventario> findById(String id) {
        return Optional.ofNullable(transacciones.get(id));
    }

    public List<TransaccionInventario> findAll() {
        return new ArrayList<>(transacciones.values());
    }

    public boolean update(TransaccionInventario transaccion) {
        if (transacciones.containsKey(transaccion.getId())) {
            transacciones.put(transaccion.getId(), transaccion);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return transacciones.remove(id) != null;
    }
}