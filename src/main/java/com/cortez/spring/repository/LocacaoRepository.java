package com.cortez.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cortez.spring.entities.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
	
}
