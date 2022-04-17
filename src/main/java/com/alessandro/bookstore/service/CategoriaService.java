package com.alessandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.alessandro.bookstore.domain.Categoria;
import com.alessandro.bookstore.dtos.CategoriaDTO;
import com.alessandro.bookstore.repositories.CategoriaRepository;
import com.alessandro.bookstore.service.exceptions.DateIntegrityViolationException;
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
	
	public Categoria inserirCategoria(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void excluir(Integer id) {
		findById(id);
		
		try {
			
			this.categoriaRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DateIntegrityViolationException("Categoria não pode ser deletadada! Possui livros associados!");
			
		}
		
	}

}
