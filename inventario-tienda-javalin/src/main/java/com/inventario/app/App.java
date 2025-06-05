package com.inventario.app;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import static io.javalin.apibuilder.ApiBuilder.*;

import com.inventario.app.model.Producto;
import com.inventario.app.repository.ProductoRepository;
import com.inventario.app.model.Cliente;
import com.inventario.app.repository.ClienteRepository;

// import com.inventario.app.controller.ProductoController;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class App {

    public static void main(String[] args) {

        ProductoRepository productoRepository = new ProductoRepository();
        ClienteRepository clienteRepository = new ClienteRepository();

        Javalin app = Javalin.create(config -> {

            // config.showJavalinBanner = false;
        });


        app.routes(() -> {

            /*

            path("productos", () -> {

                // get(ProductoController::getAll);
                // get("{id}", ProductoController::getOne);
                // post(ProductoController::create);
                // put("{id}", ProductoController::update);
                // delete("{id}", ProductoController::delete);
            });
            */


            path("clientes", () -> {

                get(ctx -> {
                    List<Cliente> clientes = clienteRepository.findAll();
                    ctx.json(clientes);
                });


                get("{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    Optional<Cliente> cliente = clienteRepository.findById(id);
                    if (cliente.isPresent()) {
                        ctx.json(cliente.get());
                    } else {
                        ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado");
                    }
                });

                post(ctx -> {
                    Cliente nuevoCliente = ctx.bodyAsClass(Cliente.class);
                    if (nuevoCliente.getId() == null || nuevoCliente.getId().isEmpty()) {
                        nuevoCliente.setId(UUID.randomUUID().toString());
                    }
                    Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
                    ctx.status(HttpStatus.CREATED).json(clienteGuardado);
                });


                put("{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    Cliente clienteActualizar = ctx.bodyAsClass(Cliente.class);
                    clienteActualizar.setId(id);
                    if (clienteRepository.update(clienteActualizar)) {
                        ctx.json(clienteActualizar);
                    } else {
                        ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado para actualizar");
                    }
                });

                delete("{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    if (clienteRepository.deleteById(id)) {
                        ctx.status(HttpStatus.NO_CONTENT);
                    } else {
                        ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado para eliminar");
                    }
                });
            });


        });

        app.start(7070);
        System.out.println("Servidor Javalin iniciado en http://localhost:7070");
    }
}