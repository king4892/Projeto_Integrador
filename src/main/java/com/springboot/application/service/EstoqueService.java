package com.springboot.application.service;

import java.util.List;

import com.springboot.application.model.Estoque;

public interface EstoqueService {
	
	List<Estoque> buscarTodosOsEstoques();
	
	Estoque salvarEstoque(Estoque estoque);
	
	Estoque pegarEstoquePeloId(Long id);
	
	Estoque atualizarEstoque(Estoque estoque);
	
	void apagarEstoquePeloId(Long id);
	
	
}
