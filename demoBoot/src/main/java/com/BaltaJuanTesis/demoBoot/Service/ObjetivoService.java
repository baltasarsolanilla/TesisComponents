package com.BaltaJuanTesis.demoBoot.Service;

import java.util.List;

import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;


public interface ObjetivoService {
	Objetivo findByName(String name);
	
	void saveObjetivo(Objetivo user);
	
	List<Objetivo> findAllObjetivos(); 
}
