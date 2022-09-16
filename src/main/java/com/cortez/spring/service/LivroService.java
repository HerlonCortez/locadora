package com.cortez.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortez.spring.entities.Livro;
import com.cortez.spring.repository.LivroRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Transactional
	public Livro salvar(Livro livro) {
		return livroRepository.save(livro);
	}
}
