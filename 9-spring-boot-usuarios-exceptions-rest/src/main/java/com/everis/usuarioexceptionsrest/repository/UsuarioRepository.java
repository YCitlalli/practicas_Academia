package com.everis.usuarioexceptionsrest.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.usuarioexceptionsrest.model.Usuario;

@Repository
public class UsuarioRepository {

	private static List<Usuario> usuarios = new ArrayList<>();
	
	private static int contador = 5;
	
	static {
		usuarios.add(new Usuario(1,"Juan", new Date()));
		usuarios.add(new Usuario(2,"Ivan", new Date()));
		usuarios.add(new Usuario(3,"Francisco", new Date()));
		usuarios.add(new Usuario(4,"Citlalli", new Date()));
		usuarios.add(new Usuario(5,"Alexis", new Date()));
	}
		
	public List<Usuario> findAll(){
		return usuarios;
	}
	
	public Usuario save(Usuario usuario) {
		if(usuario.getId()==null) {
			usuario.setId(++contador);
		}
		usuarios.add(usuario);
		return usuario;
	}
	
	public Usuario findById(int id) {
		for(Usuario usuario : usuarios) {
			if (usuario.getId()==id) {
				return usuario;
			}
		}
		return null;
	}
		
	public Usuario deleteById(int id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId()==id) {
				usuarios.remove(usuario);
				return usuario;
			}
		}
		
	//Permite recorrer una mas rapido, porque cachea la informacion.
//		Iterator<Usuario> iterator = usuarios.iterator();
//		while(iterator.hasNext()) {
//			Usuario usuario = iterator.next();
//			if(usuario.getId()==id) {
//				iterator.remove();
//				return usuario;
//			}
//			
//		}
		return null;
	}
}
