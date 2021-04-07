package com.efi.scrapper.service;

import java.util.List;

import com.efi.scrapper.domain.Televisor;

public interface TelevisorService {
	 public void insertarTelevisor(int id, String nombre);
	 public List<Televisor> cargarTelevisores();

}
