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
	
	@Override
	/*
	 * Las siguientes Queries devuelven exactamente lo que devuelven en el WorkbenchSQL.
	 */
	//@Query("select o from Objetivo o inner join o.perspectiva p where p.name='Finanzas'")
	//@Query("select p from Objetivo o inner join o.perspectiva p where p.name='Finanzas'")
	//@Query("select o.name from Objetivo o inner join o.perspectiva p where p.name='Finanzas'")
	//@Query("select o.name, p.name from Objetivo o inner join o.perspectiva p")
	//@Query("select p.name, o.name from Objetivo o inner join o.perspectiva p group by p.name, o.name")
	
	/*
	 * Solución para retornar las tuplas Objetivo(id, name, perspectiva_id)
	 */
	//@Query("select o.id, o.name, o.perspectiva.id from Objetivo o")
	List<Objetivo> findAll();
	
	//Eliminar
//	@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
//	List<Document> findDocumentsForListing(String filterValue);

}
