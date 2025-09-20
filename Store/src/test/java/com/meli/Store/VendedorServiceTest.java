package com.meli.Store;

import com.meli.Store.Business.VendedorService;
import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Data.VendedorDTO;
import com.meli.Store.Exceptions.VendedorNotFoundException;
import com.meli.Store.Repository.IProductRepository;
import com.meli.Store.Repository.IVendedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendedorServiceTest {
	
	@Mock
    private IVendedorRepository vendedorRepository;
	
	@Mock
	private IProductRepository productRepository;

    @InjectMocks
    private VendedorService vendedorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getVendedorById_existente_retornaVendedor() {
        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setId("v1");
        vendedor.setNombre("ElectroColombia");

        when(vendedorRepository.findById("v1")).thenReturn(vendedor);

        VendedorDTO result = vendedorService.getVendedorById("v1");

        assertNotNull(result);
        assertEquals("v1", result.getId());
        assertEquals("ElectroColombia", result.getNombre());
        verify(vendedorRepository, times(1)).findById("v1");
    }

    @Test
    void getVendedorById_noExistente_lanzaExcepcion() {
        when(vendedorRepository.findById("v99")).thenReturn(null);

        assertThrows(VendedorNotFoundException.class,
                () -> vendedorService.getVendedorById("v99"));
    }

    @Test
    void getAllVendedores_retornaLista() {
        VendedorDTO v1 = new VendedorDTO();
        v1.setId("v1");
        VendedorDTO v2 = new VendedorDTO();
        v2.setId("v2");

        when(vendedorRepository.findAll()).thenReturn(Arrays.asList(v1, v2));

        List<VendedorDTO> result = vendedorService.getAllVendedores();

        assertEquals(2, result.size());
        verify(vendedorRepository, times(1)).findAll();
    }

    @Test
    void createOrUpdateVendedor_guardaCorrectamente() throws IOException {
        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setId("v1");

        VendedorDTO result = vendedorService.createOrUpdateVendedor(vendedor);

        assertEquals("v1", result.getId());
        verify(vendedorRepository, times(1)).save(vendedor);
    }

    @Test
    void deleteVendedor_existente_eliminaCorrectamente() throws IOException {
        // Arrange
        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setId("v1");

        ProductoDTO producto1 = new ProductoDTO();
        producto1.setId("p1");
        producto1.setVendedorId("v1");

        ProductoDTO producto2 = new ProductoDTO();
        producto2.setId("p2");
        producto2.setVendedorId("v1");

        when(vendedorRepository.findById("v1")).thenReturn(vendedor);
        when(productRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        // Act
        vendedorService.deleteVendedor("v1");

        // Assert
        verify(productRepository, times(1)).delete("p1");
        verify(productRepository, times(1)).delete("p2");
        verify(vendedorRepository, times(1)).delete("v1");
    }

    @Test
    void deleteVendedor_noExistente_lanzaExcepcion() {
        when(vendedorRepository.findById("v99")).thenReturn(null);

        assertThrows(VendedorNotFoundException.class,
                () -> vendedorService.deleteVendedor("v99"));
    }
    

}
