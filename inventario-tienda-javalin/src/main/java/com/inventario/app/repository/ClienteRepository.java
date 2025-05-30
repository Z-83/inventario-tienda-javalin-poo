package com.inventario.app.repository;

import com.inventario.app.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {

        save(new Cliente(UUID.randomUUID().toString(), "Juan", "Perez", "juan.perez@example.com", "123456789", "Calle Falsa 123"));
        save(new Cliente(UUID.randomUUID().toString(), "Maria", "Gonzalez", "maria.g@example.com", "987654321", "Avenida Siempre Viva 742"));
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null || cliente.getId().isEmpty()) {
            cliente.setId(UUID.randomUUID().toString());
        }

        Optional<Cliente> existingCliente = findById(cliente.getId());
        if (existingCliente.isPresent()) {

            Cliente c = existingCliente.get();
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());
            c.setEmail(cliente.getEmail());
            c.setTelefono(cliente.getTelefono());
            c.setDireccion(cliente.getDireccion());
            return c;
        } else {

            clientes.add(cliente);
            return cliente;
        }
    }

    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> findById(String id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    public boolean update(Cliente cliente) {
        Optional<Cliente> existingCliente = findById(cliente.getId());
        if (existingCliente.isPresent()) {
            Cliente c = existingCliente.get();
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());
            c.setEmail(cliente.getEmail());
            c.setTelefono(cliente.getTelefono());
            c.setDireccion(cliente.getDireccion());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}