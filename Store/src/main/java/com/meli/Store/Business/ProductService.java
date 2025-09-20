package com.meli.Store.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Exceptions.ProductNotFoundException;
import com.meli.Store.Repository.IProductRepository;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

	@Autowired
    private IProductRepository productRepository;

    public ProductoDTO getProductById(String id) {
    	 ProductoDTO producto = productRepository.findById(id);
         if (producto == null) {
             throw new ProductNotFoundException("El producto con id " + id + " no existe");
         }
         return producto;
    }

    public List<ProductoDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductoDTO createOrUpdateProduct(ProductoDTO producto) {
    	try {
            productRepository.save(producto);
            return producto;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el producto", e);
        }
    }
    
    public void deleteProduct(String id) {
    	ProductoDTO producto = productRepository.findById(id);
        if (producto == null) {
            throw new ProductNotFoundException("El producto con id " + id + " no existe");
        }
        try {
            productRepository.delete(id);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el producto", e);
        }
    }
}
