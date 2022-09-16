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

import com.cortez.spring.entities.Locacao;
import com.cortez.spring.repository.LocacaoRepository;
import com.cortez.spring.service.LocacaoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private LocacaoService locacaoService;
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	
	@PostMapping
	public ResponseEntity<Locacao> add(@Valid @RequestBody Locacao locacao){
		Locacao newLocacao = locacaoService.salvar(locacao);
		return ResponseEntity.ok(newLocacao);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Locacao> devolution(@Valid @PathVariable UUID id, @RequestBody Locacao locacao){
		locacao.setId(id);
		Locacao updateLocacao = locacaoService.devolver(locacao);
		return ResponseEntity.ok(updateLocacao);
	}
	@GetMapping
	public List<Locacao> listar(){
		return locacaoRepository.findAll();
	}
}
