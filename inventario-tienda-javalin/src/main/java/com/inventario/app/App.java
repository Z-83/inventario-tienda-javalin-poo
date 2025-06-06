package com.inventario.app;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import com.inventario.app.controller.ClienteController;
import com.inventario.app.controller.ProductoController;
import com.inventario.app.controller.CategoriaController;
import com.inventario.app.controller.DescuentoController;
import com.inventario.app.controller.DetalleOrdenCompraController;
import com.inventario.app.controller.DetalleVentaController;
import com.inventario.app.controller.EmpleadoController;
import com.inventario.app.controller.EnvioController;
import com.inventario.app.controller.FacturaController;
import com.inventario.app.controller.ImpuestoController;
import com.inventario.app.controller.InventarioController;
import com.inventario.app.controller.MetodoPagoController;
import com.inventario.app.controller.OrdenCompraController;
import com.inventario.app.controller.ProveedorController;
import com.inventario.app.controller.RolController;
import com.inventario.app.controller.SucursalController;
import com.inventario.app.controller.TransaccionInventarioController;
import com.inventario.app.controller.UbicacionAlmacenController;
import com.inventario.app.controller.UsuarioController;
import com.inventario.app.controller.VentaController;


public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost();
                });
            });
        });

        app.routes(() -> {
            path("productos", () -> {
                get(ProductoController::getAll);
                get("{id}", ProductoController::getOne);
                post(ProductoController::create);
                put("{id}", ProductoController::update);
                delete("{id}", ProductoController::delete);
            });

            path("clientes", () -> {
                get(ClienteController::getAll);
                get("{id}", ClienteController::getOne);
                post(ClienteController::create);
                put("{id}", ClienteController::update);
                delete("{id}", ClienteController::delete);
            });

            path("categorias", () -> {
                get(CategoriaController::getAll);
                get("{id}", CategoriaController::getOne);
                post(CategoriaController::create);
                put("{id}", CategoriaController::update);
                delete("{id}", CategoriaController::delete);
            });

            path("descuentos", () -> {
                get(DescuentoController::getAll);
                get("{id}", DescuentoController::getOne);
                post(DescuentoController::create);
                put("{id}", DescuentoController::update);
                delete("{id}", DescuentoController::delete);
            });

            path("detalle-orden-compras", () -> {
                get(DetalleOrdenCompraController::getAll);
                get("{id}", DetalleOrdenCompraController::getOne);
                post(DetalleOrdenCompraController::create);
                put("{id}", DetalleOrdenCompraController::update);
                delete("{id}", DetalleOrdenCompraController::delete);
            });

            path("detalle-ventas", () -> {
                get(DetalleVentaController::getAll);
                get("{id}", DetalleVentaController::getOne);
                post(DetalleVentaController::create);
                put("{id}", DetalleVentaController::update);
                delete("{id}", DetalleVentaController::delete);
            });

            path("empleados", () -> {
                get(EmpleadoController::getAll);
                get("{id}", EmpleadoController::getOne);
                post(EmpleadoController::create);
                put("{id}", EmpleadoController::update);
                delete(EmpleadoController::delete);
            });

            path("envios", () -> {
                get(EnvioController::getAll);
                get("{id}", EnvioController::getOne);
                post(EnvioController::create);
                put("{id}", EnvioController::update);
                delete("{id}", EnvioController::delete);
            });

            path("facturas", () -> {
                get(FacturaController::getAll);
                get("{id}", FacturaController::getOne);
                post(FacturaController::create);
                put("{id}", FacturaController::update);
                delete("{id}", FacturaController::delete);
            });

            path("impuestos", () -> {
                get(ImpuestoController::getAll);
                get("{id}", ImpuestoController::getOne);
                post(ImpuestoController::create);
                put("{id}", ImpuestoController::update);
                delete("{id}", ImpuestoController::delete);
            });

            path("inventarios", () -> {
                get(InventarioController::getAll);
                get("{id}", InventarioController::getOne);
                post(InventarioController::create);
                put("{id}", InventarioController::update);
                delete("{id}", InventarioController::delete);
            });

            path("metodos-pago", () -> {
                get(MetodoPagoController::getAll);
                get("{id}", MetodoPagoController::getOne);
                post(MetodoPagoController::create);
                put("{id}", MetodoPagoController::update);
                delete("{id}", MetodoPagoController::delete);
            });

            path("orden-compras", () -> {
                get(OrdenCompraController::getAll);
                get("{id}", OrdenCompraController::getOne);
                post(OrdenCompraController::create);
                put("{id}", OrdenCompraController::update);
                delete("{id}", OrdenCompraController::delete);
            });

            path("proveedores", () -> {
                get(ProveedorController::getAll);
                get("{id}", ProveedorController::getOne);
                post(ProveedorController::create);
                put("{id}", ProveedorController::update);
                delete("{id}", ProveedorController::delete);
            });

            path("roles", () -> {
                get(RolController::getAll);
                get("{id}", RolController::getOne);
                post(RolController::create);
                put("{id}", RolController::update);
                delete("{id}", RolController::delete);
            });

            path("sucursales", () -> {
                get(SucursalController::getAll);
                get("{id}", SucursalController::getOne);
                post(SucursalController::create);
                put("{id}", SucursalController::update);
                delete("{id}", SucursalController::delete);
            });

            path("transacciones-inventario", () -> {
                get(TransaccionInventarioController::getAll);
                get("{id}", TransaccionInventarioController::getOne);
                post(TransaccionInventarioController::create);
                put("{id}", TransaccionInventarioController::update);
                delete("{id}", TransaccionInventarioController::delete);
            });

            path("ubicacion-almacenes", () -> {
                get(UbicacionAlmacenController::getAll);
                get("{id}", UbicacionAlmacenController::getOne);
                post(UbicacionAlmacenController::create);
                put("{id}", UbicacionAlmacenController::update);
                delete("{id}", UbicacionAlmacenController::delete);
            });

            path("usuarios", () -> {
                get(UsuarioController::getAll);
                get("{id}", UsuarioController::getOne);
                post(UsuarioController::create);
                put("{id}", UsuarioController::update);
                delete("{id}", UsuarioController::delete);
            });

            path("ventas", () -> {
                get(VentaController::getAll);
                get("{id}", VentaController::getOne);
                post(VentaController::create);
                put("{id}", VentaController::update);
                delete("{id}", VentaController::delete);
            });
        });

        app.start(7070);
        System.out.println("Servidor Javalin iniciado en http://localhost:7070");
    }
}