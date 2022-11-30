package com.springboot.application.service;

import java.util.List;

import com.springboot.application.model.Dispositivo;



public interface DispositivoService  {
	
	List<Dispositivo> buscarTodosDispositivos();
	
	Dispositivo salvarDispositivo(Dispositivo dispositivo) ;
	
	Dispositivo pegarDispositivoPeloId(Long id);
	
	Dispositivo atualizarDispositivo(Dispositivo dispositivo);
	
	void apagarDispositivoPeloId(Long id);
}
