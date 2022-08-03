package com.cortez.spring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.cortez.spring.entities.Editora;

@RestController
public interface EditoraRepository extends JpaRepository<Editora, Long>{

	Optional<Editora> findByDescricao(String descricao);
}
