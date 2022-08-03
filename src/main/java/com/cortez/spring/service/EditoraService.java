package com.cortez.spring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cortez.spring.entities.Editora;
import com.cortez.spring.exception.NegocioException;
import com.cortez.spring.repository.EditoraRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EditoraService {
	
	private EditoraRepository editoraRepository;
	
	@Transactional
	public Editora salvar(Editora editora) {
		
		Optional<Editora> e = editoraRepository.findByDescricao(editora.getDescricao());
		if (e.isPresent()) {
			if (!e.get().getId().equals(editora.getId()) && editora.getDescricao().equals(e.get().getDescricao())) {
				throw new NegocioException("Já existe uma editora cadastrada com este nome", HttpStatus.CONFLICT);
			}
		}
		return editoraRepository.save(editora);
	}
	
	@Transactional
	public void delete(Long id) {
		editoraRepository.deleteById(id);
	}

}
