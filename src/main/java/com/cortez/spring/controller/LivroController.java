package com.cortez.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortez.spring.entities.Livro;
import com.cortez.spring.repository.EditoraRepository;
import com.cortez.spring.repository.LivroRepository;
import com.cortez.spring.service.LivroService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired 
	private EditoraRepository editoraRepository;
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Livro> add(@Valid @RequestBody Livro livro){
		Livro newLivro = livroRepository.save(livro);
		return ResponseEntity.ok(newLivro);
	}
	
	@GetMapping
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	
	@GetMapping("/count")
	public Long count() {
		return livroRepository.count();
	}
}
