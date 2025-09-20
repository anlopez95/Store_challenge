package com.meli.Store.Data;

import java.util.List;

import lombok.Data;

/**
 * Dto con información del vendedor
 */

@Data
public class VendedorDTO {
	
	private String id;
    private String nombre;
    private double reputacion;
    private List<String> productosIds;

}
