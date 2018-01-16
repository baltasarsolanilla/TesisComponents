package com.BaltaJuanTesis.demoBoot.Service.impl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BaltaJuanTesis.demoBoot.Service.ObjetivoService;
import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;
import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;
import com.BaltaJuanTesis.demoBoot.repository.ObjetivoRepository;

@Service("ObjetivoService")
@Transactional
public class ObjetivoServiceImpl implements ObjetivoService {
	
	@Autowired
	private ObjetivoRepository ObjetivoRepository;

	public Objetivo findByName(String name) {
		return ObjetivoRepository.findByName(name);
	}

	public void saveObjetivo(Objetivo user) {
		ObjetivoRepository.save(user);
		
	}

	public List<Objetivo> findAllObjetivos() {
		return (List<Objetivo>) ObjetivoRepository.findAll();
	}
	
	



}