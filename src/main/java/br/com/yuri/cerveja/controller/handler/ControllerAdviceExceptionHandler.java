package br.com.yuri.cerveja.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.yuri.cerveja.service.exception.RegisterStyleNameException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(RegisterStyleNameException.class)
	public ResponseEntity<String> registerStyleNameExceptionHandler(RegisterStyleNameException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
