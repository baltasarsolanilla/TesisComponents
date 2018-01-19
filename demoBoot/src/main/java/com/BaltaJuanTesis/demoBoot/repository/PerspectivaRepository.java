package com.BaltaJuanTesis.demoBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;


public interface PerspectivaRepository extends CrudRepository<Perspectiva, Long> {
	Perspectiva findByName(String name);
}
