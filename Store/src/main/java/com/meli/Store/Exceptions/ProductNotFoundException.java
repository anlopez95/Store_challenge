package com.meli.Store.Exceptions;

/**
 * Excepcion que se lanza cuando no se encuentra el producto en registros existentes
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
