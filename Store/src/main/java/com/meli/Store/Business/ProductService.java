package com.meli.Store.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.Store.Data.ProductoDTO;
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
        return productRepository.findById(id);
    }

    public List<ProductoDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductoDTO createOrUpdateProduct(ProductoDTO producto) throws IOException {
        productRepository.save(producto);
        return producto;
    }
    
    public boolean deleteProduct(String id) throws IOException {
        ProductoDTO producto = productRepository.findById(id);
        if (producto == null) {
            return false;
        }
        productRepository.delete(id);
        return true;
    }
}
