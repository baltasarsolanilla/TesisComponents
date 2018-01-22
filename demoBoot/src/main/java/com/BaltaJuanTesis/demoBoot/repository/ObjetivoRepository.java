package com.BaltaJuanTesis.demoBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;


public interface ObjetivoRepository extends CrudRepository<Objetivo, Long> {
	/**
	 * Method Name - Data Jpa
     * Finds Objetivo by using the 'name' as a search criteria.
     * @Query("select o from Objetivo when Objetivo.name=name")
     * @param name
     * @return  An Objetivo which name is an exact match with the given name.
     *          If no Objetivo is found, this method returns NULL.
     * 
     * Supported keywords inside method names Keyword
     * https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */
	Objetivo findByName(String name);
	
	//WORKING - pero igualmente devuelve cada objeto mapeado por la foreign key.
	@Override
	//@Query("select o from Objetivo o JOIN Perspectiva p where p.name='Finanzas'")
	@Query("select o from Objetivo o")
	List<Objetivo> findAll();
}
