package com.salma.mini_projet_pharmacie.exception;

import com.salma.mini_projet_pharmacie.dto.ApiResponse;
import com.salma.mini_projet_pharmacie.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Erreurs NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(NotFoundException ex) {
        return ResponseHandler.error(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Erreurs Runtime (validation, etc.)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntime(RuntimeException ex) {
        return ResponseHandler.error(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Erreurs générales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneral(Exception ex) {
        return ResponseHandler.error("Erreur interne : " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
