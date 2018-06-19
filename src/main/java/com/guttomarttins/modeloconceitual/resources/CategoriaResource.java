package com.guttomarttins.modeloconceitual.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guttomarttins.modeloconceitual.domain.Categoria;
import com.guttomarttins.modeloconceitual.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	private ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	private List<Categoria> listar() {
//		
//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritório");
//		
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		return lista;
//	}
	
}
