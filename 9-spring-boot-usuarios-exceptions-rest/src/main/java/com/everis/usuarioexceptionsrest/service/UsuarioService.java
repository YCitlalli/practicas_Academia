package com.everis.usuarioexceptionsrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.usuarioexceptionsrest.model.Usuario;
import com.everis.usuarioexceptionsrest.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario deleteById(int id) {
		return usuarioRepository.deleteById(id);
	}
}
