package com.cortez.spring.service;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cortez.spring.entities.Locacao;
import com.cortez.spring.exception.NegocioException;
import com.cortez.spring.repository.LocacaoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;
	
	
	@Transactional
	public Locacao salvar(Locacao locacao) {
		
		if (!verifyPossibilityLocacao(locacao)) {
			throw new NegocioException("A data de locação não pode ser diferente de hoje", HttpStatus.CONFLICT);
		}
		return locacaoRepository.save(locacao);
	}
	
	@Transactional
	public Locacao devolver(Locacao locacao) {
		if(!verifyPossibilityDevolution(locacao)) {
			throw new NegocioException("A data de devolução não pode ser inferior a data de locação", HttpStatus.CONFLICT);
		}
		return locacaoRepository.save(locacao);
	}
	
	private boolean verifyPossibilityLocacao(Locacao locacao) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-DD");
		if (df.format(locacao.getData_locacao()).equals(df.format(new Date()))) {
			return true;
		}
		return false;
	}
	
	private boolean verifyPossibilityDevolution(Locacao locacao) {
		if (locacao.getData_locacao().before(locacao.getData_devolucao())) {
			return true;
		}
		return false;
	}
}
