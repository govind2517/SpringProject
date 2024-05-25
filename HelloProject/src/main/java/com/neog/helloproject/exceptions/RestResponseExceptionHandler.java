package com.neog.helloproject.exceptions;

import com.neog.helloproject.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleCustomError(Exception e){
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage(e.getMessage());
        dto.setStatus(404);
        ResponseEntity<ResponseDTO> resEntity = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        return resEntity;

    }

}
