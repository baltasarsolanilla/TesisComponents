package com.BaltaJuanTesis.demoBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;


public interface ObjetivoRepository extends CrudRepository<Objetivo, String> {
	Objetivo findByName(String name);
}
