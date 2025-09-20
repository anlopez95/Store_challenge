package com.meli.Store.Repository;

import java.io.IOException;
import java.util.List;

public interface IRepository<T> {
    T findById(String id);
    List<T> findAll();
    void save(T entity) throws IOException;   // se deja throws porque JSON sí puede fallar y se deja logica de control en el servicio en vez del repo
    void delete(String id) throws IOException;
}
