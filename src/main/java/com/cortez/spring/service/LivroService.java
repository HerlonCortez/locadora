package com.cortez.spring.service;

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
		Optional<Livro> l = livroRepository.findByDescricao(livro.getDescricao());
		if(l.isPresent()){
			if(!l.get().getId().equals(livro.getId()) && livro.getDescricao().equals(l.get().getDescricao())){
				throw new NegocioException("Já existe um livro cadastrado com este nome", HttpStatus.CONFLICT);
			}
		}
		return livroRepository.save(livro);
	}
}
