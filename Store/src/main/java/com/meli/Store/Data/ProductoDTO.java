package com.meli.Store.Data;

import java.util.List;

import lombok.Data;

@Data
public class ProductoDTO {
	
	private String id;
    private String titulo;
    private String descripcion;
    private PrecioDTO precio;
    private InventarioDTO inventario;
    private List<ImagenDTO> imagenes;
    private String vendedorId;
    private List<ReseñaDTO> reseñas;
    private List<PreguntaDTO> preguntas;
}
