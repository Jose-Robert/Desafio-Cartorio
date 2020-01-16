package com.docket.cartorio.exception;

public class IdentificadorNuloOuInexistenteException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public IdentificadorNuloOuInexistenteException(String msg) {
		super(msg);
	}
}
