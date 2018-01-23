package com.BaltaJuanTesis.demoBoot.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	  ObjetivoService objetivoService;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All Objetivo--------------------------------------------------------
	     
	    @RequestMapping(value = "/Objetivo/", method = RequestMethod.GET)
	    public ResponseEntity<List<Objetivo>> listAllObjetivos() {
	        List<Objetivo> objetivos = objetivoService.findAllObjetivos();
	        if(objetivos.isEmpty()){
	            return new ResponseEntity<List<Objetivo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Objetivo>>(objetivos, HttpStatus.OK);
	    }
	    

	    //-------------------Create a Objetivo--------------------------------------------------------
	     
	    @RequestMapping(value = "/Objetivo/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createObjetivo(@RequestBody Objetivo objetivo,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Objetivo" + objetivo.getName());
	 
	        objetivoService.saveObjetivo(objetivo);
	        
	        //eliminar VERRR
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/Objetivo/{name}").buildAndExpand(objetivo.getName()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    //-------------------Delete Objetivo--------------------------------------------------------
        
        @RequestMapping(value = "/Objetivo/{name}", method = RequestMethod.DELETE)
        public ResponseEntity<Objetivo> deleteObjetivo(@PathVariable("name") String name) {
            System.out.println("Fetching & Deleting objetivo with name " + name);
       
            Objetivo objetivo = objetivoService.findByName(name);
            if (objetivo == null) {
                System.out.println("Unable to delete. Objetivo with name" + name+ " not found");
                return new ResponseEntity<Objetivo>(HttpStatus.NOT_FOUND);
            }
     
            objetivoService.deleteObjetivoById(objetivo.getId());
            return new ResponseEntity<Objetivo>(HttpStatus.NO_CONTENT);
        }

	    
	   
	    
}