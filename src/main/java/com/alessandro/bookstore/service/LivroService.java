package com.alessandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.bookstore.domain.Livro;
import com.alessandro.bookstore.repositories.LivroRepository;
import com.alessandro.bookstore.service.exceptions.ObjectnotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	public Livro findById(Integer id) {
		
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
		
	}

	public List<Livro> findBAll(Integer id_cat) {
		
		categoriaService.findById(id_cat);
		
		return livroRepository.findAllByCategoria(id_cat);
		 
	}

}


