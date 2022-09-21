package com.cortez.spring.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cortez.spring.repository.ClienteRepository;

import com.cortez.spring.entities.Cliente;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {

		return clienteRepository.save(cliente);	
		
	}
	
	@Transactional
	public void delete(UUID id) {
		clienteRepository.deleteById(id);
	}
}
