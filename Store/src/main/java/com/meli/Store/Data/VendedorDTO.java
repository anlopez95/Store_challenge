package com.meli.Store.Data;

import lombok.Data;

/**
 * Dto con información del vendedor
 */

@Data
public class VendedorDTO {
	
	private String id;
    private String nombre;
    private double reputacion;

}
