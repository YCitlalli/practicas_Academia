package com.everis.hateoas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//Importando todos los atributos y metodos estaticos dentro de la clase
//ControllerLinkBuilder
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.everis.hateoas.model.Producto;

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
	
	@GetMapping(value="/productos/{id}", produces= {"application/json"})
	public Producto buscaProducto(@PathVariable int id) {
		return productos.get(id);
	}
	
	@GetMapping(value="/productos", produces= {"application/json"})
  //@GetMapping(value="/productos", consumes= {"application/json"}, produces= {"application/json"})
	public Resources<Producto> listar(){
		for(Producto producto : productos) {
			Link selfLink = linkTo(methodOn(ProductoController.class)
					.buscaProducto(producto.getIdProducto())).withSelfRel();
			producto.add(selfLink);
					
		}
		return new Resources<Producto>(productos);
	}
}
