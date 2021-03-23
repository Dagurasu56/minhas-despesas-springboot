package com.dagurasu.minhasdespesas.exception;

public class DespesaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DespesaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DespesaNotFoundException(String message) {
		super(message);
	}
}