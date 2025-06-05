package com.inventario.app.repository;

import com.inventario.app.model.Envio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnvioRepository {
    private Map<String, Envio> envios = new HashMap<>();

    public EnvioRepository() {

    }

    public Envio save(Envio envio) {
        envios.put(envio.getId(), envio);
        return envio;
    }

    public Optional<Envio> findById(String id) {
        return Optional.ofNullable(envios.get(id));
    }

    public List<Envio> findAll() {
        return List.copyOf(envios.values());
    }

    public boolean update(Envio envio) {
        if (envios.containsKey(envio.getId())) {
            envios.put(envio.getId(), envio);
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        return envios.remove(id) != null;
    }
}