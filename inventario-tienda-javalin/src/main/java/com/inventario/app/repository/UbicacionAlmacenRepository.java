package com.inventario.app.repository;

import com.inventario.app.model.UbicacionAlmacen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UbicacionAlmacenRepository {

    private static final Map<String, UbicacionAlmacen> ubicaciones = new HashMap<>();

    public UbicacionAlmacen save(UbicacionAlmacen ubicacion) {
        ubicaciones.put(ubicacion.getId(), ubicacion);
        return ubicacion;
    }

    public Optional<UbicacionAlmacen> findById(String id) {
        return Optional.ofNullable(ubicaciones.get(id));
    }

    public List<UbicacionAlmacen> findAll() {
        return new ArrayList<>(ubicaciones.values());
    }

    public boolean update(UbicacionAlmacen ubicacion) {
        if (ubicaciones.containsKey(ubicacion.getId())) {
            ubicaciones.put(ubicacion.getId(), ubicacion);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return ubicaciones.remove(id) != null;
    }
}