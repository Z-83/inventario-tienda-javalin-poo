package com.inventario.app.controller;

import com.inventario.app.model.DetalleVenta;
import com.inventario.app.repository.DetalleVentaRepository;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DetalleVentaController {

    private static DetalleVentaRepository repository = new DetalleVentaRepository();

    public static void getAll(Context ctx) {
        List<DetalleVenta> recursos = repository.findAll();
        ctx.json(recursos);
        ctx.status(HttpStatus.OK);
    }

    public static void getOne(Context ctx) {
        String id = ctx.pathParam("id");
        Optional<DetalleVenta> recurso = repository.findById(id);

        if (recurso.isPresent()) {
            ctx.json(recurso.get());
            ctx.status(HttpStatus.OK);
        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Recurso " + id + " no encontrado.");
        }
    }

    public static void create(Context ctx) {

        DetalleVenta newRecurso = ctx.bodyAsClass(DetalleVenta.class);

        if (newRecurso.getId() == null || newRecurso.getId().isEmpty()) {
            newRecurso.setId(UUID.randomUUID().toString());
        }

        repository.save(newRecurso);
        ctx.json(newRecurso);
        ctx.status(HttpStatus.CREATED);
    }

    public static void update(Context ctx) {
        String id = ctx.pathParam("id");
        DetalleVenta recursoToUpdate = ctx.bodyAsClass(DetalleVenta.class);

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

    // DELETE: Eliminar un recurso
    public static void delete(Context ctx) {
        String id = ctx.pathParam("id");
        if (repository.deleteById(id)) {
            ctx.status(HttpStatus.NO_CONTENT); // 204 No Content (éxito sin contenido)
        } else {
            ctx.status(HttpStatus.NOT_FOUND); // 404 Not Found
            ctx.result("Recurso " + id + " no encontrado para eliminar.");
        }
    }
}