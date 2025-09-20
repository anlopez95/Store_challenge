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

	/**
	 * Endpoint para realizar la busqueda de producto por id alfanumerico.
	 * @param id Indicativo unico del producto.
	 * @return ResponseEntity con información del producto.
	 */
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductById(@PathVariable String id) {
    	return ResponseEntity.ok(productoService.getProductById(id));
    }

    /**
     * Endpoint que devuelve la lista completa de productos.
     * @return ResponseEntity con toda la información de productos almacenados en el archivo productos.json.
     */
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProducts() {
        return ResponseEntity.ok(productoService.getAllProducts());
    }

    /**
     * EndPoint encargado de la creacion de nuevos productos en el registro existente.
     * @param producto Objeto DTO con la información del producto a crear.
     * @return ResponseEntity con la información del producto almacenada en lista de productos.
     * @throws IOException Posible excepción para la creación del producto, relacionada a storage json.
     */
    @PostMapping
    public ResponseEntity<ProductoDTO> createProduct(@RequestBody ProductoDTO producto) throws IOException {
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    /**
     * EndPoint encargado de realizar el update de la información de un producto.
     * @param id Identficador del producto a actualizar.
     * @param producto Cuerpo con la info a designar para el producto objetivo de actualización.
     * @return ResponseEntity con la confirmación e informacion del producto actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProduct(
            @PathVariable String id,
            @RequestBody ProductoDTO producto
    ) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.createOrUpdateProduct(producto));
    }

    /**
     * EndPoint encargado de la eliminación de productos del catalogo.
     * @param id Identificador unico del producto a eliminar.
     * @return ResponseEntity con estatus de la eliminación.
     * @throws IOException Manejo de excepciones presentadas.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) throws IOException {
    	productoService.deleteProduct(id);
        return ResponseEntity.ok("Eliminado producto " + id + " correctamente");
    }
}
