package com.example.AtividadePontuada.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>>handlerIllegalArgument(IllegalArgumentException erro){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }
    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity <Map <String, Object>>handlerEmailJaCadastrado (IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensagem",erro.getMessage()));
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String,Object>> handlerMethodArgumentNotValidException (MethodArgumentNotValidException erro){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem",erro.getMessage()));
    }

    @ExceptionHandler (HttpRequestMethodNotSupportedException.class)
    public  ResponseEntity <Map<String, Object>> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro){
        return  ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(Map.of("mensagem",erro.getMessage()));
    }
}

