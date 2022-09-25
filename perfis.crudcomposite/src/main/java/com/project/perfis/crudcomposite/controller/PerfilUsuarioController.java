package com.project.perfis.crudcomposite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.perfis.crudcomposite.DTO.PerfilUsuarioRequestDTO;
import com.project.perfis.crudcomposite.service.impl.PerfilUsuarioServiceImpl;

@Controller
public class PerfilUsuarioController {

	@Autowired
	private PerfilUsuarioServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody PerfilUsuarioRequestDTO novoAluno)
	{
		service.save(novoAluno);
		return ResponseEntity.status(HttpStatus.OK).body("Qualquer coisa");
	}
}
