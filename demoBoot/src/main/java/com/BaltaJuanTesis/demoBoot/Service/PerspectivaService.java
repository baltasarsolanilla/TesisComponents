package com.BaltaJuanTesis.demoBoot.Service;

import java.util.List;

import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;


public interface PerspectivaService {
	
	void savePerspectiva(Perspectiva user);
	
	List<Perspectiva > findAllPerspectivas(); 
}
