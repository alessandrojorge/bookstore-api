package com.alessandro.bookstore.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alessandro.bookstore.domain.Categoria;
import com.alessandro.bookstore.dtos.CategoriaDTO;
import com.alessandro.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {

		Categoria categoria = service.findById(id);

		return ResponseEntity.ok().body(categoria);

	}

	/*
	 * @GetMapping //abaixo tem uma forma mais elegante usando stream do java 8
	 * public ResponseEntity<List<CategoriaDTO>> findAll(){
	 * 
	 * List<Categoria> listacategoria = this.service.findAll();
	 * 
	 * List<CategoriaDTO> dto = new ArrayList<>();
	 * 
	 * for(Categoria cat : listacategoria ) {
	 * 
	 * dto.add(new CategoriaDTO(cat));
	 * 
	 * }
	 * 
	 * return ResponseEntity.ok().body(dto); }
	 */

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> listacategoria = this.service.findAll();

		List<CategoriaDTO> listaDto = listacategoria.stream().map(CategoriaDTO::new).collect(Collectors.toList());
	//	List<CategoriaDTO> listaDto = listacategoria.stream().map(obj -> if(obj.getno) new CategoriaDTO(obj)).collect(Collectors.toList()); 
    //  assim tb pode
		return ResponseEntity.ok().body(listaDto);
	}

}
