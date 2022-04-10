package com.alessandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.bookstore.domain.Categoria;
import com.alessandro.bookstore.repositories.CategoriaRepository;
import com.alessandro.bookstore.service.exceptions.ObjectnotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException(
				"Obejeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}

}
