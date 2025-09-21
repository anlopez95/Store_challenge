package com.meli.Store.Repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.Store.Data.VendedorDTO;
import com.meli.Store.Repository.IVendedorRepository;
import com.meli.Store.Utils.Constantes;

import jakarta.annotation.PostConstruct;

@Repository
@ConditionalOnProperty(name = "storage.type", havingValue = "json", matchIfMissing = true)
public class JsonVendedorRepository implements IVendedorRepository {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final File storage = new File(Constantes.ARCHIVO_VENDEDORES);
    private Map<String, VendedorDTO> vendedores = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        if (storage.exists()) {
            List<VendedorDTO> vendedorList = objectMapper.readValue(
                storage, new TypeReference<List<VendedorDTO>>() {}
            );
            vendedores = vendedorList.stream().collect(Collectors.toMap(VendedorDTO::getId, v -> v));
        }
    }

    @Override
    public VendedorDTO findById(String id) {
        return vendedores.get(id);
    }

    @Override
    public List<VendedorDTO> findAll() {
        return vendedores.values().stream().toList();
    }

    @Override
    public void save(VendedorDTO entity) throws IOException {
        vendedores.put(entity.getId(), entity);
        persist();
    }

    @Override
    public void delete(String id) throws IOException {
        vendedores.remove(id);
        persist();
    }

    private void persist() throws IOException {
        objectMapper.writeValue(storage, vendedores.values());
    }
}
