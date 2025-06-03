package com.inventario.app;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import static io.javalin.apibuilder.ApiBuilder.*; // ¡Importante!

// Importa tus modelos y repositorios
import com.inventario.app.model.Producto; // Puede que ahora muestre advertencia de no usada, ¡está bien!
import com.inventario.app.repository.ProductoRepository; // Puede que ahora muestre advertencia de no usada, ¡está bien!
import com.inventario.app.model.Cliente;
import com.inventario.app.repository.ClienteRepository;

// Si tenías esta línea, coméntala o bórrala si no tienes ProductoController.java
// import com.inventario.app.controller.ProductoController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class App {

    public static void main(String[] args) {

        ProductoRepository productoRepository = new ProductoRepository(); // Advertencia: 'productoRepository' is never used. ¡Es normal por ahora!
        ClienteRepository clienteRepository = new ClienteRepository();

        Javalin app = Javalin.create(config -> {
            // Configuraciones generales si las necesitas
        });

        app.routes(() -> {
            /*
            // ¡BLOQUE DE PRODUCTOS COMENTADO TEMPORALMENTE!
            // Si llegas a crear ProductoController, quita estos comentarios y verifica el controller.
            path("productos", () -> {
                get(ProductoController::getAll);
                get("{id}", ProductoController::getOne);
                post(ProductoController::create);
                put("{id}", ProductoController::update);
                delete("{id}", ProductoController::delete);
            });
            */

            // ============== ENDPOINTS PARA CLIENTE =====================
            path("clientes", () -> {
                // GET: Obtener todos los clientes
                get(ctx -> {
                    List<Cliente> clientes = clienteRepository.findAll();
                    ctx.json(clientes);
                });

                // GET: Obtener un cliente por ID
                get("{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    Optional<Cliente> cliente = clienteRepository.findById(id);
                    if (cliente.isPresent()) {
                        ctx.json(cliente.get());
                    } else {
                        ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado");
                    }
                });

                // POST: Crear un nuevo cliente
                post(ctx -> {
                    Cliente nuevoCliente = ctx.bodyAsClass(Cliente.class);
                    if (nuevoCliente.getId() == null || nuevoCliente.getId().isEmpty()) {
                        nuevoCliente.setId(UUID.randomUUID().toString());
                    }
                    Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
                    ctx.status(HttpStatus.CREATED).json(clienteGuardado);
                });

                // PUT: Actualizar un cliente existente por ID
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

                // DELETE: Eliminar un cliente por ID
                delete("{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    if (clienteRepository.deleteById(id)) {
                        ctx.status(HttpStatus.NO_CONTENT);
                    } else {
                        ctx.status(HttpStatus.NOT_FOUND).result("Cliente no encontrado para eliminar");
                    }
                });
            });
            // ==========================================================

        }); // Fin de app.routes()

        app.start(7070);
        System.out.println("Servidor Javalin iniciado en http://localhost:7070");
    }
}