package com.alessandro.bookstore.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alessandro.bookstore.domain.Livro;
import com.alessandro.bookstore.dtos.LivroDTO;
import com.alessandro.bookstore.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		
		Livro livro = livroService.findById(id);
		
		return ResponseEntity.ok().body(livro);
	}
		
	@GetMapping()
	
	public ResponseEntity<List<LivroDTO>> findbyAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
		//localhos:8080/livros?categoria=1
		//List<Livro> livro = livroService.findBAll(id_cat);
		
		List<Livro> list = livroService.findBAll(id_cat);
		List<LivroDTO> listDto = list.stream().map(livro-> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
		//OU
		
		/*return  ResponseEntity.ok().body(livroService.findBAll(id_cat)
				.stream().map(livro-> new LivroDTO(livro)).collect(Collectors.toList()));*/
				
	}
	

}
