package com.inventario.app.repository;

import com.inventario.app.model.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsuarioRepository {

    private static final Map<String, Usuario> usuarios = new HashMap<>();

    public Usuario save(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Optional<Usuario> findById(String id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public boolean update(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            usuarios.put(usuario.getId(), usuario);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return usuarios.remove(id) != null;
    }
}