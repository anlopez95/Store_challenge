package com.meli.Store.Data;

import lombok.Data;

/**
 * Dto con información preguntas hechas sobre el producto
 */

@Data
public class PreguntaDTO {
	
	private String usuarioId;
    private String pregunta;
    private String respuesta;

}
