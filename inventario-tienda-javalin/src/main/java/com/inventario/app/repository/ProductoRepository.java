package com.inventario.app.repository; // ¡Este es el paquete correcto para ProductoRepository.java!

import com.inventario.app.model.Producto; // Necesitamos importar la clase Producto
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ProductoRepository {
    private static final List<Producto> productos = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    static {
        productos.add(new Producto(String.valueOf(counter.incrementAndGet()), "Teclado Mecánico", "Teclado RGB con switches azules", 75.99, 50));
        productos.add(new Producto(String.valueOf(counter.incrementAndGet()), "Ratón Inalámbrico", "Ratón ergonómico con batería de larga duración", 25.50, 120));
        productos.add(new Producto(String.valueOf(counter.incrementAndGet()), "Monitor Curvo 27''", "Monitor gaming 144Hz 1ms", 299.99, 30));
    }

    public Producto save(Producto producto) {
        if (producto.getId() == null || producto.getId().isEmpty()) {
            producto.setId(String.valueOf(counter.incrementAndGet()));
        }
        productos.add(producto);
        return producto;
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> findById(String id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Producto update(String id, Producto updatedProducto) {
        Optional<Producto> existingProductoOpt = findById(id);
        if (existingProductoOpt.isPresent()) {
            Producto existingProducto = existingProductoOpt.get();
            existingProducto.setNombre(updatedProducto.getNombre());
            existingProducto.setDescripcion(updatedProducto.getDescripcion());
            existingProducto.setPrecio(updatedProducto.getPrecio());
            existingProducto.setStock(updatedProducto.getStock());
            return existingProducto;
        }
        return null;
    }

    public boolean deleteById(String id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}
