package com.meli.Store.Data;

import lombok.Data;

/**
 * Dto con información de existencias de los productos y su resumen de vendidos
 */

@Data
public class InventarioDTO {
	
	private int disponible;
    private int vendidos;

}
