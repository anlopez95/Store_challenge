package com.meli.Store.Repository;

import java.io.IOException;
import java.util.List;

import com.meli.Store.Data.ProductoDTO;

public interface IProductRepository {
	
	ProductoDTO findById(String id);
    List<ProductoDTO> findAll();
    void save(ProductoDTO product) throws IOException;
    void delete(String id) throws IOException;

}
