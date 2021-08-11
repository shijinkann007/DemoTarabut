package com.tarabut.demo.advices;

 
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tarabut.demo.dto.GenericResponse;
import com.tarabut.demo.exceptions.ConfigurationException;
import com.tarabut.demo.exceptions.EntityNotFoundException;
import com.tarabut.demo.util.GenericResponseUtils;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<GenericResponse> handleEntityNotFoundException(Exception e, WebRequest request) {
		ResponseEntity<GenericResponse> response = buildGenericResponse(e);
		return response;
	}

	@ExceptionHandler(ConfigurationException.class)
	public ResponseEntity<GenericResponse> handleConfigurationException(Exception e, WebRequest request) {
		ResponseEntity<GenericResponse> response = buildGenericResponse(e);
		return response;
	}
	
	
	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(
	      MethodArgumentNotValidException ex, HttpHeaders headers,
	      HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest().body(GenericResponseUtils.buildGenericResponseError(ex.getBindingResult()
		        .getAllErrors().stream()
		        .map(ObjectError::getDefaultMessage)
		        .collect(Collectors.toList())));
 
	  } 

	private ResponseEntity<GenericResponse> buildGenericResponse(Exception e) {
		return ResponseEntity.badRequest().body(GenericResponseUtils.buildGenericResponseError(e));
	}

}
