package com.cortez.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cortez.spring.entities.Livro;
import com.cortez.spring.exception.NegocioException;
import com.cortez.spring.repository.LivroRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Transactional
	public Livro salvar(Livro livro) {
		List<Livro> livros = livroRepository.findByDescricao(livro.getDescricao());
		if(!livros.isEmpty()){
			for (Livro l : livros) {
				if(l.getDescricao().equals(livro.getDescricao()) 
				&& l.getEditora().getId().equals(livro.getEditora().getId())){
					throw new NegocioException("Já existe um livro com as mesmas características", HttpStatus.CONFLICT);
				}
			}
		}
		return livroRepository.save(livro);
	}
}
