package com.app.exception_handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;
//import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;

@RestControllerAdvice // mandatory !
public class GlobalExceptionHandler {
	// can contain single /multiple exc handling methods
	// how to tell SC , following method : exc handling method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		 //convert List<FieldError> --> Map: fieldName , def mesg
		Map<String, String> map=e.getFieldErrors() //List<FieldErr>
				.stream() //Stream<FieldError>
				.collect(Collectors.toMap(f -> f.getField(), 
						f -> f.getDefaultMessage()));
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);

	}

	 //add another exc handling method to handle Resource not found exc
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("handle res not found "+e);
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));		
	}
	//catch-all 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e)
	{
		System.out.println("in catch-all "+e);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR) //500
				.body(new ApiResponse(e.getMessage()));
	}

}
