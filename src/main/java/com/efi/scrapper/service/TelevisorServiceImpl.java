package com.efi.scrapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efi.scrapper.domain.Televisor;
import com.efi.scrapper.repository.TelevisorRepository;

@Service
public class TelevisorServiceImpl implements TelevisorService{

    @Autowired
    private TelevisorRepository televisorRepository;
    
	@Override
	public void insertarTelevisor(int id, String nombre) {
		 Televisor televisorNuevo = new Televisor(id, nombre);
		 televisorRepository.save(televisorNuevo);
	}

	@Override
	public List<Televisor> cargarTelevisores() {
		 List<Televisor> televisores = televisorRepository.findAll();
	     return televisores;
	}

}
