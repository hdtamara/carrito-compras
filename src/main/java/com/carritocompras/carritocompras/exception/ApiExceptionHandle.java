package com.carritocompras.carritocompras.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialException;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ApiExceptionHandle{

  
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, InsufficientStockException.class})
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap; 
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class, ClassNotFoundException.class})
    public Map<String, String> handleBusinessException(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    } 

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({CredentialException.class,UserNotEnabledException.class})
    public Map<String,String> handleWrongCredentials(Exception ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserAlreadyExistsException.class})
    public Map<String,String> handleUserExist(Exception ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    //@ExceptionHandler(InsufficientStockException.class)
    //public Map<String, String> handleStockException(Exception ex) {
        //Map<String, String> errorMap = new HashMap<>();
        //errorMap.put("errorMessage", ex.getMessage());
      //  return errorMap;
    //}

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String,String> otherException(Exception ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }





}
    

