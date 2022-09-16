package com.cortez.spring.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 50)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 50)
	private String autor;
	
	private int lancamento;
	
}
