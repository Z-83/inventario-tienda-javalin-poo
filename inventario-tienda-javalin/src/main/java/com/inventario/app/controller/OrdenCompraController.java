package com.inventario.app.controller;

import com.inventario.app.model.OrdenCompra;
import com.inventario.app.repository.OrdenCompraRepository;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrdenCompraController {

    private static OrdenCompraRepository repository = new OrdenCompraRepository();

    public static void getAll(Context ctx) {
        List<OrdenCompra> recursos = repository.findAll();
        ctx.json(recursos);
        ctx.status(HttpStatus.OK);
    }

    public static void getOne(Context ctx) {
        String id = ctx.pathParam("id");
        Optional<OrdenCompra> recurso = repository.findById(id);

        if (recurso.isPresent()) {
            ctx.json(recurso.get());
            ctx.status(HttpStatus.OK);
        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Recurso " + id + " no encontrado.");
        }
    }

    public static void create(Context ctx) {

        OrdenCompra newRecurso = ctx.bodyAsClass(OrdenCompra.class);

        if (newRecurso.getId() == null || newRecurso.getId().isEmpty()) {
            newRecurso.setId(UUID.randomUUID().toString());
        }

        repository.save(newRecurso);
        ctx.json(newRecurso);
        ctx.status(HttpStatus.CREATED);
    }

    public static void update(Context ctx) {
        String id = ctx.pathParam("id");
        OrdenCompra recursoToUpdate = ctx.bodyAsClass(OrdenCompra.class);

        if (!id.equals(recursoToUpdate.getId())) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.result("ID en la URL no coincide con el ID en el cuerpo de la petición.");
            return;
        }

        if (repository.update(recursoToUpdate)) {
            ctx.json(recursoToUpdate);
            ctx.status(HttpStatus.OK);
        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Recurso " + id + " no encontrado para actualizar.");
        }
    }

    public static void delete(Context ctx) {
        String id = ctx.pathParam("id");
        if (repository.deleteById(id)) {
            ctx.status(HttpStatus.NO_CONTENT);
        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Recurso " + id + " no encontrado para eliminar.");
        }
    }
}