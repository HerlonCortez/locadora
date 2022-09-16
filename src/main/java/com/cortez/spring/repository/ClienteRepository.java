package com.cortez.spring.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cortez.spring.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

	List<Cliente> findByNome(String nome); // Busca exata por nome

	List<Cliente> findByNomeContaining(String nome); // mesmo que like

	Optional<Cliente> findByEmail(String email); // Busca exta por e-mail
}
