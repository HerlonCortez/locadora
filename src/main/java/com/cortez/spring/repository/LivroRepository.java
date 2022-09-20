package com.cortez.spring.repository;




import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cortez.spring.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

    Optional<Livro> findByDescricao(String descricao);
}
