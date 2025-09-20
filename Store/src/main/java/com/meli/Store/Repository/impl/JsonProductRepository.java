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
import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Repository.IProductRepository;
import com.meli.Store.Utils.Constantes;

import jakarta.annotation.PostConstruct;

@Repository
@ConditionalOnProperty(name = "storage.type", havingValue = "json", matchIfMissing = true)
public class JsonProductRepository implements IProductRepository {

 private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
 private final File storage = new File(Constantes.ARCHIVO_PRODUCTOS);
 private Map<String, ProductoDTO> productos = new HashMap<>();

 @PostConstruct
 public void init() throws IOException {
     if (storage.exists()) {
         List<ProductoDTO> productList = objectMapper.readValue(
             storage, new TypeReference<List<ProductoDTO>>() {}
         );
         productos = productList.stream().collect(Collectors.toMap(ProductoDTO::getId, p -> p));
     }
 }

 @Override
 public ProductoDTO findById(String id) {
     return productos.get(id);
 }

 @Override
 public List<ProductoDTO> findAll() {
     return productos.values().stream().toList();
 }

 @Override
 public void save(ProductoDTO entity) throws IOException {
	    productos.put(entity.getId(), entity);
	    persist(); // si falla, lanza IOException
	}

 @Override
 public void delete(String id) throws IOException {
	    productos.remove(id);
	    persist();
	}

 private void persist() throws IOException {
     objectMapper.writeValue(storage, productos.values());
 }
}

