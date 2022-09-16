package com.cortez.spring.entities;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.Nullable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 50)
	private String nome;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 14)
	private String cpf;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 14)
	private String celular;
	
	@NotBlank(message = "{NotBlank}")
	@Email
	@Size(max = 50)
	private String email;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 2)
	private String uf;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 50)
	private String cep;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 30)
	private String cidade;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 30)
	private String bairro;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 30)
	private String logradouro;
	
	@Nullable
	private String complemento;
	
	@NotBlank(message = "{NotBlank}")
	@Size(max = 10)
	private String numero;
}
