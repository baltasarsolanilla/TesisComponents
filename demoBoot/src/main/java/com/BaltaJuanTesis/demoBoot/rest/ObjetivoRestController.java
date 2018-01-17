package com.BaltaJuanTesis.demoBoot.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.BaltaJuanTesis.demoBoot.Service.ObjetivoService;
import com.BaltaJuanTesis.demoBoot.modelo.Objetivo;

@RestController
public class ObjetivoRestController {

	  @Autowired
	  ObjetivoService ObjetivoService;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All Users--------------------------------------------------------
	     
	    @RequestMapping(value = "/Objetivo/", method = RequestMethod.GET)
	    public ResponseEntity<List<Objetivo>> listAllObjetivos() {
	        List<Objetivo> Objetivos = ObjetivoService.findAllObjetivos();
	        if(Objetivos.isEmpty()){
	            return new ResponseEntity<List<Objetivo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Objetivo>>(Objetivos, HttpStatus.OK);
	    }
	    

	    //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/Objetivo/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createObjetivo(@RequestBody Objetivo Objetivo,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Objetivo" + Objetivo.getName());
	 
	        ObjetivoService.saveObjetivo(Objetivo);
	        
	        //eliminar VERRR
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/Objetivo/{name}").buildAndExpand(Objetivo.getName()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	   
	    
}