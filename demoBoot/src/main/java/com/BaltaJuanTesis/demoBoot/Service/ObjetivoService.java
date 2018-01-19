package com.BaltaJuanTesis.demoBoot.Service;

import java.util.List;

import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;


public interface ObjetivoService {
	
	void saveObjetivo(Objetivo user);
	
	List<Objetivo> findAllObjetivos();

	Objetivo findById(Long id);
    
    Objetivo findByName(String name);
    
    void deleteObjetivoById(Long id);

}
