package com.senac.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.api.entity.ObjetoAprendizagem;
import com.senac.api.request.ObjetoAprendizagemRequest;
import com.senac.api.response.ObjetoAprendizagemResponse;
import com.senac.api.service.ObjetoAprendizagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/objetoAprendizagem")
public class ObjetoAprendizagemController {

	@Autowired
	private ObjetoAprendizagemService objetoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<ObjetoAprendizagemResponse>  adicionar(@Valid @RequestBody ObjetoAprendizagemRequest objReq){
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagem obj = mapper.map(objReq, ObjetoAprendizagem.class);
		obj = objetoAprendizagemService.adicionar(obj);
		return ResponseEntity<>(mapper.map(obj, ObjetoAprendizagemResponse.class), HttpStatus.CREATED);
		//return ResponseEntity<>(mapper.map(obj, ObjetoAprendizagemResponse.class), HttpStatus.CREATED);
	}
}
