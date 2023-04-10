package com.example.demo.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class Exception_Handler {
	public final ResponseEntity<ExceptionResponse>handleException(IdNotFoundException idNotFound,WebRequest request){
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(), idNotFound.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionresponse,HttpStatus.NOT_FOUND);
		
	}

}
