package com.meli.Store.Exceptions;

public class VendedorNotFoundException extends RuntimeException {
    public VendedorNotFoundException(String message) {
        super(message);
    }
}
