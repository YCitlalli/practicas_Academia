package com.everis.xml.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.xml.model.Producto;


@RestController
public class ProductoController {

	private static List<Producto> productos =new ArrayList<Producto>();
	
	//Constructor estatico, inicializar todos los atributos estaticos
	static {
		productos.add(new Producto(1, "Producto 1"));
		productos.add(new Producto(2, "Producto 2"));
		productos.add(new Producto(3, "Producto 3"));
		productos.add(new Producto(4, "Producto 4"));
	}
	
	//Te muestra los productos en dos formatos xml y json 
	@GetMapping(value="/productos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto buscaProducto(@PathVariable int id) {
		return productos.get(id);
	}
	
	@GetMapping("/productos")
	public List<Producto> listar(){
		return productos;
	}
}
