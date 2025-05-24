package com.inventario.app;

import io.javalin.Javalin;
import io.javalin.http.ContentType;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {

        }).start(7000);

        app.get("/", ctx -> {
            ctx.contentType(ContentType.HTML);
            ctx.result("!Hola desde Javalin! Tu API de Inventario está funcionando.");
        });

        System.out.println("Servidor Javalin iniciado en http://localhost:7000");
    }
}