package com.carritocompras.carritocompras.exception;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message){
        super(message);
    }
}
