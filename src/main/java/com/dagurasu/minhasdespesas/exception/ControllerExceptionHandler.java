package com.dagurasu.minhasdespesas.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(DespesaNotFoundException.class)
	public ResponseEntity<StandardError> despesaNotFound(DespesaNotFoundException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}
