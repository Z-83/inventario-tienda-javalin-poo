package com.inventario.app.repository;

import com.inventario.app.model.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoriaRepository {

    private final List<Categoria> categorias = new ArrayList<>();

    public CategoriaRepository() {

        save(new Categoria(UUID.randomUUID().toString(), "Electronica", "Dispositivos electronicos y gadgets"));
        save(new Categoria(UUID.randomUUID().toString(), "Ropa", "Prendas de vestir para todas las edades"));
        save(new Categoria(UUID.randomUUID().toString(), "Alimentos", "Productos comestibles y bebidas"));
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null || categoria.getId().isEmpty()) {
            categoria.setId(UUID.randomUUID().toString());
        }

        Optional<Categoria> existingCategoria = findById(categoria.getId());
        if (existingCategoria.isPresent()) {
            Categoria c = existingCategoria.get();
            c.setNombre(categoria.getNombre());
            c.setDescripcion(categoria.getDescripcion());
            return c;
        } else {
            categorias.add(categoria);
            return categoria;
        }
    }

    public List<Categoria> findAll() {
        return new ArrayList<>(categorias);
    }

    public Optional<Categoria> findById(String id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId().equals(id))
                .findFirst();
    }

    public boolean update(Categoria categoria) {
        Optional<Categoria> existingCategoria = findById(categoria.getId());
        if (existingCategoria.isPresent()) {
            Categoria c = existingCategoria.get();
            c.setNombre(categoria.getNombre());
            c.setDescripcion(categoria.getDescripcion());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}