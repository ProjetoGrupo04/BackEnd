package com.senac.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.api.entity.ObjetoAprendizagem;
import com.senac.api.service.ObjetoAprendizagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/objetoAprendizagem")
public class ObjetoAprendizagemController {

	@Autowired
	private ObjetoAprendizagemService objetoAprendizagemService;
	
	public @ResponseEntity<ObjetoAprendizagemResponse>  adicionar(@Valid @RequestBody ObjetoAprendizagemRequest objReq){
		
	}
}
