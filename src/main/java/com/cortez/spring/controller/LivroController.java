package com.cortez.spring.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cortez.spring.entities.Livro;
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
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Livro> add(@Valid @RequestBody Livro livro){
		Livro newLivro = livroService.salvar(livro);
		return ResponseEntity.ok(newLivro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar(@Valid @RequestBody Livro livro, @PathVariable UUID id){
		if(!livroRepository.existsById(id)){
			return ResponseEntity.notFound().build();
		}
		livro.setId(id);
		Livro updatedLivro = livroService.salvar(livro);
		return ResponseEntity.ok(updatedLivro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable UUID id) {
		return livroRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
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
