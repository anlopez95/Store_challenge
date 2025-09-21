package com.meli.Store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.meli.Store.Business.ProductService;
import com.meli.Store.Controller.ProductController;
import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Exceptions.ProductNotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
	
	@Mock
    private ProductService productoService;

    @InjectMocks
    private ProductController productController;

    private ProductoDTO producto;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        producto = new ProductoDTO();
        producto.setId("p1");
        producto.setTitulo("Producto Test");
    }

    @Test
    void getProductById_success() {
        when(productoService.getProductById("p1")).thenReturn(producto);

        ResponseEntity<ProductoDTO> response = productController.getProductById("p1");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("p1", response.getBody().getId());
    }

    @Test
    void getProductById_notFound() {
        when(productoService.getProductById("p99")).thenThrow(new ProductNotFoundException("El producto con id p99 no existe"));

        assertThrows(ProductNotFoundException.class, () -> productController.getProductById("p99"));
    }

    @Test
    void getAllProducts_success() {
        when(productoService.getAllProducts()).thenReturn(Arrays.asList(producto));

        ResponseEntity<List<ProductoDTO>> response = productController.getAllProducts();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void createProduct_success() throws IOException {
        when(productoService.createOrUpdateProduct(producto)).thenReturn(producto);

        ResponseEntity<ProductoDTO> response = productController.createProduct(producto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("p1", response.getBody().getId());
    }

    @Test
    void updateProduct_success() {
        when(productoService.createOrUpdateProduct(producto)).thenReturn(producto);

        ResponseEntity<ProductoDTO> response = productController.updateProduct("p1", producto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("p1", response.getBody().getId());
    }

    @Test
    void deleteProduct_success() throws IOException {
        doNothing().when(productoService).deleteProduct("p1");

        ResponseEntity<String> response = productController.deleteProduct("p1");

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Eliminado producto p1"));
    }

    @Test
    void deleteProduct_notFound() throws IOException {
        doThrow(new ProductNotFoundException("El producto con id p99 no existe")).when(productoService).deleteProduct("p99");

        assertThrows(ProductNotFoundException.class, () -> productController.deleteProduct("p99"));
    }

}
