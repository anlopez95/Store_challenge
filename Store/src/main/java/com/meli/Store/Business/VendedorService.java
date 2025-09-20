package com.meli.Store.Business;

import com.meli.Store.Data.ProductoDTO;
import com.meli.Store.Data.VendedorDTO;
import com.meli.Store.Exceptions.VendedorNotFoundException;
import com.meli.Store.Repository.IProductRepository;
import com.meli.Store.Repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private IVendedorRepository vendedorRepository;
    
    @Autowired
    private IProductRepository productRepository;

    public VendedorDTO getVendedorById(String id) {
        VendedorDTO vendedor = vendedorRepository.findById(id);
        if (vendedor == null) {
            throw new VendedorNotFoundException("El vendedor con id " + id + " no existe");
        }
        return vendedor;
    }

    public List<VendedorDTO> getAllVendedores() {
        return vendedorRepository.findAll();
    }

    public VendedorDTO createOrUpdateVendedor(VendedorDTO vendedor) {
        try {
            vendedorRepository.save(vendedor);
            return vendedor;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el vendedor", e);
        }
    }

    public void deleteVendedor(String id) {
    	VendedorDTO vendedor = vendedorRepository.findById(id);
        if (vendedor == null) {
            throw new VendedorNotFoundException("El vendedor con id " + id + " no existe");
        }

        try {
            // 1. Eliminar productos asociados
            List<ProductoDTO> productos = productRepository.findAll();
            for (ProductoDTO producto : productos) {
                if (id.equals(producto.getVendedorId())) {
                    productRepository.delete(producto.getId());
                }
            }

            // 2. Eliminar vendedor
            vendedorRepository.delete(id);

        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar vendedor y sus productos", e);
        }
    }
}
