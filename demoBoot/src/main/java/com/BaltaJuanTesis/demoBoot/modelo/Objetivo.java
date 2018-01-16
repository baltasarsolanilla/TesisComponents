package com.BaltaJuanTesis.demoBoot.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Objetivo {

	@Id
	private String name;
	
	@ManyToOne
	private Perspectiva perspectiva;
}
