package com.meli.Store.Repository;

import com.meli.Store.Data.VendedorDTO;

import java.io.IOException;
import java.util.List;

public interface IVendedorRepository {
    VendedorDTO findById(String id);
    List<VendedorDTO> findAll();
    void save(VendedorDTO vendedor) throws IOException;
    void delete(String id) throws IOException;
}
