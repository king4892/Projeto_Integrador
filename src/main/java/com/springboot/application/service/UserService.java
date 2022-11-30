package com.springboot.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Usuario;
import com.springboot.application.repository.UsuarioRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listAll(){
		return usuarioRepository.findAll(Sort.by("email").ascending());
	}

}
