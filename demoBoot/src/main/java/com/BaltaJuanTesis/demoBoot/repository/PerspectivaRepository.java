package com.BaltaJuanTesis.demoBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;


public interface PerspectivaRepository extends CrudRepository<Perspectiva, Long> {
	/**
	 * Method Name - Data Jpa
	 * Finds Perspectiva by using the 'name' as a search criteria.
	 * @Query("select p from Perspectiva when Perspectiva.name=name")
	 * @Query JPA Translate: "select p from Perspectiva p where p.name=?1"
     * @param name
     * @return  An Perspectiva which name is an exact match with the given name.
     *          If no Perspectiva is found, this method returns NULL.
     * 
     * Supported keywords inside method names Keyword
     * https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */
	Perspectiva findByName(String name);
}
