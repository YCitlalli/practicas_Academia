package com.everis.usuarioexceptionsrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNoEncontradoException extends RuntimeException {

	public UsuarioNoEncontradoException(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}

}
