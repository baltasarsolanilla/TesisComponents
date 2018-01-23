package com.BaltaJuanTesis.demoBoot.Service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BaltaJuanTesis.demoBoot.Service.PerspectivaService;
import com.BaltaJuanTesis.demoBoot.modelo.Perspectiva;
import com.BaltaJuanTesis.demoBoot.repository.PerspectivaRepository;

@Service("PerspectivaService")
@Transactional
public class PerspectivaServiceImpl implements PerspectivaService {
	
	@Autowired
	private PerspectivaRepository perspectivaRepository;

	public void savePerspectiva(Perspectiva user) {
		perspectivaRepository.save(user);
		
	}

	//MODIFIED
	public List<Perspectiva> findAllPerspectivas() {
		return (List<Perspectiva>) perspectivaRepository.findAll();
	}
	
	@Override
    public Perspectiva findByName(String name) {
        return perspectivaRepository.findByName(name);
    }
	
    @Override
    public Perspectiva findById(Long id) {
        return perspectivaRepository.findOne(id);
    }
    
    public void deletePerspectivaById(Long id){
        perspectivaRepository.delete(id);
        
    }
}