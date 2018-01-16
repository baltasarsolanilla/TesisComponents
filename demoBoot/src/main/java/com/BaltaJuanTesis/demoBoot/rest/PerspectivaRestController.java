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

import com.BaltaJuanTesis.demoBoot.Service.PerspectivaService;
import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;

@RestController
public class PerspectivaRestController {

	  @Autowired
	  PerspectivaService perspectivaService;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All Users--------------------------------------------------------
	     
	    @RequestMapping(value = "/Perspectiva/", method = RequestMethod.GET)
	    public ResponseEntity<List<Perspectiva>> listAllPerspectivas() {
	        List<Perspectiva> Perspectivas = perspectivaService.findAllPerspectivas();
	        if(Perspectivas.isEmpty()){
	            return new ResponseEntity<List<Perspectiva>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Perspectiva>>(Perspectivas, HttpStatus.OK);
	    }
	    

	    //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/Perspectiva/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createPerspectiva(@RequestBody Perspectiva Perspectiva,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Perspectiva" + Perspectiva.getName());
	 
	        perspectivaService.savePerspectiva(Perspectiva);
	        
	        //eliminar
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/Perspectiva/{name}").buildAndExpand(Perspectiva.getName()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	   
	    
}