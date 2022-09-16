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
		
//		Optional<Cliente> c = clienteRepository.findByEmail(cliente.getEmail());
//		if (c.isPresent()) {
//			if (!c.get().getId().equals(cliente.getId()) && cliente.getEmail().equals(c.get().getEmail())) {
//				throw new NegocioException("Já existe um cliente cadastrado com este e-mail", HttpStatus.CONFLICT);
//			}
//		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void delete(UUID id) {
		clienteRepository.deleteById(id);
	}
}
