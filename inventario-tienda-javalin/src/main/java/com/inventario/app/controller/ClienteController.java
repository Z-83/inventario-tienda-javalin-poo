package com.inventario.app.controller;

import com.inventario.app.model.Cliente;
import com.inventario.app.repository.ClienteRepository;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClienteController {

    private static ClienteRepository clienteRepository = new ClienteRepository();

    public static void getAll(Context ctx) {
        List<Cliente> clientes = clienteRepository.findAll();
        ctx.json(clientes);
    }

    public static void getOne(Context ctx) {
        String id = ctx.pathParam("id");
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            ctx.json(cliente.get());
        } else {
            ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado");
        }
    }

    public static void create(Context ctx) {
        Cliente nuevoCliente = ctx.bodyAsClass(Cliente.class);
        if (nuevoCliente.getId() == null || nuevoCliente.getId().isEmpty()) {
            nuevoCliente.setId(UUID.randomUUID().toString());
        }
        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        ctx.status(HttpStatus.CREATED).json(clienteGuardado);
    }

    public static void update(Context ctx) {
        String id = ctx.pathParam("id");
        Cliente clienteActualizar = ctx.bodyAsClass(Cliente.class);
        clienteActualizar.setId(id); // Asegura que el ID de la URL se use
        if (clienteRepository.update(clienteActualizar)) {
            ctx.json(clienteActualizar);
        } else {
            ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado para actualizar");
        }
    }

    public static void delete(Context ctx) {
        String id = ctx.pathParam("id");
        if (clienteRepository.deleteById(id)) {
            ctx.status(HttpStatus.NO_CONTENT); // 204 No Content para eliminación exitosa
        } else {
            ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado para eliminar");
        }
    }
}
