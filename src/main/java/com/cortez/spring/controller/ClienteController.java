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

import com.cortez.spring.entities.Cliente;
import com.cortez.spring.repository.ClienteRepository;
import com.cortez.spring.service.ClienteService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/count")
	public Long count(){
		return clienteRepository.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable UUID id) {
		return clienteRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> adicionar(@Valid @RequestBody Cliente cliente) {
		Cliente newCliente =  clienteService.salvar(cliente);
		return ResponseEntity.ok(newCliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterar(@PathVariable UUID id, @Valid @RequestBody Cliente cliente){
		if (!clienteRepository.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = clienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable UUID id){
		if (!clienteRepository.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
