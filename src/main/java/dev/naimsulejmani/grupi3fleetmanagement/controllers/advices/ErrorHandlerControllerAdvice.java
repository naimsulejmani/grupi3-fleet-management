package dev.naimsulejmani.grupi3fleetmanagement.controllers.advices;


import dev.naimsulejmani.grupi3fleetmanagement.dtos.ErrorResponse;
import dev.naimsulejmani.grupi3fleetmanagement.exceptions.EmailExistException;
import dev.naimsulejmani.grupi3fleetmanagement.exceptions.UserNameExistException;
import dev.naimsulejmani.grupi3fleetmanagement.exceptions.UserNotFoundException;
import jakarta.persistence.EntityExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandlerControllerAdvice {

    //    @ExceptionHandler({EntityExistsException.class, UserNameExistException.class, EmailExistException.class})
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(HttpServletRequest request, EntityExistsException e) {
        var error = new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setStatusName(HttpStatus.CONFLICT.name());
        error.setTimestamp(LocalDateTime.now());
        error.setPath(request.getRequestURI());
//        error.setException(e);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(HttpServletRequest request, Exception e) {
        var error = new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setStatusName(HttpStatus.INTERNAL_SERVER_ERROR.name());
        error.setTimestamp(LocalDateTime.now());
        error.setPath(request.getRequestURI());
//        error.setException(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}














