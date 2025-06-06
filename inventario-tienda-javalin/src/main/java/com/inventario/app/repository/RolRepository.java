package com.inventario.app.repository;

import com.inventario.app.model.Rol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RolRepository {

    private static final Map<String, Rol> roles = new HashMap<>();

    public Rol save(Rol rol) {
        roles.put(rol.getId(), rol);
        return rol;
    }

    public Optional<Rol> findById(String id) {
        return Optional.ofNullable(roles.get(id));
    }

    public List<Rol> findAll() {
        return new ArrayList<>(roles.values());
    }

    public boolean update(Rol rol) {
        if (roles.containsKey(rol.getId())) {
            roles.put(rol.getId(), rol);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return roles.remove(id) != null;
    }
}