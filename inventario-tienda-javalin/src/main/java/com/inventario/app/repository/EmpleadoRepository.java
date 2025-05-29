package com.inventario.app.repository;

import com.inventario.app.model.Empleado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmpleadoRepository {

    private final List<Empleado> empleados = new ArrayList<>();

    public EmpleadoRepository() {
        // Datos de ejemplo
        save(new Empleado(UUID.randomUUID().toString(), "Carlos", "Ruiz", "Gerente", LocalDate.of(2022, 1, 15), "carlos.r@example.com"));
        save(new Empleado(UUID.randomUUID().toString(), "Ana", "Lopez", "Vendedor", LocalDate.of(2023, 3, 1), "ana.l@example.com"));
    }

    public Empleado save(Empleado empleado) {
        if (empleado.getId() == null || empleado.getId().isEmpty()) {
            empleado.setId(UUID.randomUUID().toString());
        }

        Optional<Empleado> existingEmpleado = findById(empleado.getId());
        if (existingEmpleado.isPresent()) {
            Empleado e = existingEmpleado.get();
            e.setNombre(empleado.getNombre());
            e.setApellido(empleado.getApellido());
            e.setCargo(empleado.getCargo());
            e.setFechaContratacion(empleado.getFechaContratacion());
            e.setEmail(empleado.getEmail());
            return e;
        } else {
            empleados.add(empleado);
            return empleado;
        }
    }

    public List<Empleado> findAll() {
        return new ArrayList<>(empleados);
    }

    public Optional<Empleado> findById(String id) {
        return empleados.stream()
                .filter(empleado -> empleado.getId().equals(id))
                .findFirst();
    }

    public boolean update(Empleado empleado) {
        Optional<Empleado> existingEmpleado = findById(empleado.getId());
        if (existingEmpleado.isPresent()) {
            Empleado e = existingEmpleado.get();
            e.setNombre(empleado.getNombre());
            e.setApellido(empleado.getApellido());
            e.setCargo(empleado.getCargo());
            e.setFechaContratacion(empleado.getFechaContratacion());
            e.setEmail(empleado.getEmail());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return empleados.removeIf(empleado -> empleado.getId().equals(id));
    }
}