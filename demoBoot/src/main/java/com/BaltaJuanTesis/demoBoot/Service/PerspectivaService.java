package com.BaltaJuanTesis.demoBoot.Service;

import java.util.List;

import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;


public interface PerspectivaService {
	
	void savePerspectiva(Perspectiva user);
	
	List<Perspectiva> findAllPerspectivas();
	
	Perspectiva findById(Long id);
	
	Perspectiva findByName(String name);
    
    void deletePerspectivaById(Long id);

}
