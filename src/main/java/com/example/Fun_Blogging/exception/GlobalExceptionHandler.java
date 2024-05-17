package com.example.Fun_Blogging.exception;

import com.example.Fun_Blogging.entityDTO.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exp){
        String message = exp.getMessage();
        ApiResponse apiResponse= new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<Map<String,String>> handleInvalidData(MethodArgumentNotValidException ex){
        Map<String,String>map= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();
            String fieldMessage =error.getDefaultMessage();
            map.put(fieldName,fieldMessage);
        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }

}
