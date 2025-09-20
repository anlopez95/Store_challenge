package com.meli.Store.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meli.Store.Business.ProductService;
import com.meli.Store.Data.ProductoDTO;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

	@Autowired
    private ProductService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductById(@PathVariable String id) {
    	return ResponseEntity.ok(productoService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProducts() {
        return ResponseEntity.ok(productoService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProduct(@RequestBody ProductoDTO producto) throws IOException {
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProduct(
            @PathVariable String id,
            @RequestBody ProductoDTO producto
    ) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) throws IOException {
    	productoService.deleteProduct(id);
        return ResponseEntity.ok("Eliminado producto " + id + " correctamente");
    }
}
