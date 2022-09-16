package com.cortez.spring.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cortez.spring.entities.Editora;
import com.cortez.spring.repository.EditoraRepository;
import com.cortez.spring.service.EditoraService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/editoras")
public class EditoraController {

	private EditoraRepository editoraRepository;
	private EditoraService editoraService;
	
	@GetMapping
	public List<Editora> listar(){
		return editoraRepository.findAll();
	}
	
	@GetMapping("/count")
	public Long count(){
		return editoraRepository.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> buscar(@PathVariable UUID id){
		return editoraRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Editora> adicionar(@Valid @RequestBody Editora editora) {
		Editora newEditora =  editoraService.salvar(editora);
		return ResponseEntity.ok(newEditora);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Editora> alterar(@Valid @RequestBody Editora editora, @PathVariable UUID id){
		if(!editoraRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		editora.setId(id);
		editora = editoraService.salvar(editora);
		return ResponseEntity.ok(editora);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id){
		if(!editoraRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		editoraService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
