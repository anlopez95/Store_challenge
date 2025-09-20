package com.meli.Store.Controller;

import com.meli.Store.Business.VendedorService;
import com.meli.Store.Data.VendedorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

	/**
	 * Endpoint dedicado a obtener informacion de un vendedor.
	 * 
	 * @param id Identificador del vendedor
	 * @return ResponseEntity Con la informacion del vendedor y los ids de los
	 *         productos asociados
	 */
	@Operation(summary = "Obtener un vendedor por ID", description = "Devuelve la información de un vendedor específico, junto con los productos asociados", tags = {
			"Vendedor" })
	@GetMapping("/{id}")
	public ResponseEntity<VendedorDTO> getVendedorById(@PathVariable String id) {
		return ResponseEntity.ok(vendedorService.getVendedorById(id));
	}

	/**
	 * Endpoint dedicado a obtener informacion de todos los vendedores.
	 * 
	 * @return ResponseEntity Con informacion de vendedores.
	 */
	@Operation(summary = "Listar todos los vendedores", description = "Devuelve una lista con todos los vendedores registrados", tags = {
			"Vendedores" })
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> getAllVendedores() {
		return ResponseEntity.ok(vendedorService.getAllVendedores());
	}

	/**
	 * EndPoint dedicado a crear vendedores
	 * 
	 * @param vendedor Parametro con la informacion del vendedor.
	 * @return ResponseEntity Con respuesta de creación.
	 * @throws IOException
	 */
	@Operation(summary = "Crear un vendedor", description = "Registra un nuevo vendedor en el sistema", tags = {
			"Vendedor" })
	@PostMapping
	public ResponseEntity<VendedorDTO> createVendedor(@RequestBody VendedorDTO vendedor) throws IOException {
		return ResponseEntity.ok(vendedorService.createOrUpdateVendedor(vendedor));
	}

	/**
	 * EndPoint encargado de actualizar la información de un vendedor.
	 * 
	 * @param id       Identificador del vendedor a actualizar.
	 * @param vendedor Información del vendedor.
	 * @return ResponseEntity Con confirmacion del actualizado.
	 */
	@Operation(summary = "Actualizar un vendedor por ID", description = "Actualiza la información de un vendedor existente", tags = {
			"Vendedor" })
	@PutMapping("/{id}")
	public ResponseEntity<VendedorDTO> updateVendedor(@PathVariable String id, @RequestBody VendedorDTO vendedor) {
		vendedor.setId(id);
		return ResponseEntity.ok(vendedorService.createOrUpdateVendedor(vendedor));
	}

	/**
	 * EndPoint dedicado a borrar a un vendedor
	 * 
	 * @param id Identificador del vendedor a eliminar
	 * @return ResponseEntity Con la confirmacion del borrado
	 */
	@Operation(summary = "Eliminar un vendedor por ID", description = "Elimina un vendedor y todos los productos asociados", tags = {
			"Vendedor" })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVendedor(@PathVariable String id) {
		vendedorService.deleteVendedor(id);
		return ResponseEntity.ok("Eliminado vendedor " + id + " y sus productos asociados correctamente");
	}
}
