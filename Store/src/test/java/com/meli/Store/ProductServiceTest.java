package com.meli.Store;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.meli.Store.Business.*;
import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Exceptions.ProductNotFoundException;
import com.meli.Store.Repository.IProductRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
	
	 @Mock
	    private IProductRepository productRepository;

	    @InjectMocks
	    private ProductService productService;

	    private ProductoDTO producto;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        producto = new ProductoDTO();
	        producto.setId("p1");
	        producto.setTitulo("Producto Test");
	    }

	    @Test
	    void getProductById_existingId_returnsProduct() {
	        when(productRepository.findById("p1")).thenReturn(producto);

	        ProductoDTO result = productService.getProductById("p1");

	        assertNotNull(result);
	        assertEquals("p1", result.getId());
	        verify(productRepository, times(1)).findById("p1");
	    }

	    @Test
	    void getProductById_nonExistingId_throwsException() {
	        when(productRepository.findById("p99")).thenReturn(null);

	        assertThrows(ProductNotFoundException.class, () -> productService.getProductById("p99"));
	    }

	    @Test
	    void getAllProducts_returnsList() {
	        when(productRepository.findAll()).thenReturn(Arrays.asList(producto));

	        List<ProductoDTO> result = productService.getAllProducts();

	        assertEquals(1, result.size());
	        verify(productRepository, times(1)).findAll();
	    }

	    @Test
	    void createOrUpdateProduct_success() throws IOException {
	        doNothing().when(productRepository).save(producto);

	        ProductoDTO result = productService.createOrUpdateProduct(producto);

	        assertEquals("p1", result.getId());
	        verify(productRepository, times(1)).save(producto);
	    }

	    @Test
	    void createOrUpdateProduct_throwsIOException() throws IOException {
	        doThrow(new IOException("Error al guardar")).when(productRepository).save(producto);

	        RuntimeException ex = assertThrows(RuntimeException.class, () -> productService.createOrUpdateProduct(producto));
	        assertTrue(ex.getMessage().contains("Error al guardar"));
	    }

	    @Test
	    void deleteProduct_existingProduct_success() throws IOException {
	        when(productRepository.findById("p1")).thenReturn(producto);
	        doNothing().when(productRepository).delete("p1");

	        assertDoesNotThrow(() -> productService.deleteProduct("p1"));
	        verify(productRepository, times(1)).delete("p1");
	    }

	    @Test
	    void deleteProduct_nonExistingProduct_throwsException() {
	        when(productRepository.findById("p99")).thenReturn(null);

	        assertThrows(ProductNotFoundException.class, () -> productService.deleteProduct("p99"));
	    }

	    @Test
	    void deleteProduct_throwsIOException() throws IOException {
	        when(productRepository.findById("p1")).thenReturn(producto);
	        doThrow(new IOException("Error al eliminar")).when(productRepository).delete("p1");

	        RuntimeException ex = assertThrows(RuntimeException.class, () -> productService.deleteProduct("p1"));
	        assertTrue(ex.getMessage().contains("Error al eliminar"));
	    }

}
