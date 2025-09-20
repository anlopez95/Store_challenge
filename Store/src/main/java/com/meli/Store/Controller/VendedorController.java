package com.meli.Store.Controller;

import com.meli.Store.Business.VendedorService;
import com.meli.Store.Data.VendedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> getVendedorById(@PathVariable String id) {
        return ResponseEntity.ok(vendedorService.getVendedorById(id));
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> getAllVendedores() {
        return ResponseEntity.ok(vendedorService.getAllVendedores());
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> createVendedor(@RequestBody VendedorDTO vendedor) throws IOException {
        return ResponseEntity.ok(vendedorService.createOrUpdateVendedor(vendedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> updateVendedor(
            @PathVariable String id,
            @RequestBody VendedorDTO vendedor
    ) {
        vendedor.setId(id);
        return ResponseEntity.ok(vendedorService.createOrUpdateVendedor(vendedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendedor(@PathVariable String id) {
        vendedorService.deleteVendedor(id);
        return ResponseEntity.ok("Eliminado vendedor " + id + " correctamente");
    }
}
