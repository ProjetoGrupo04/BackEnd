package com.senac.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.api.entity.SituacaoAprendizagem;
import com.senac.api.request.SituacaoAprendizagemRequest;
import com.senac.api.response.SituacaoAprendizagemResponse;
import com.senac.api.service.SituacaoAprendizagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/situacaoAprendizagem")
public class SituacaoAprendizagemController {

	@Autowired
	private SituacaoAprendizagemService situacaoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<SituacaoAprendizagemResponse> adicionar(@Valid @RequestBody SituacaoAprendizagemRequest situacaoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagem situacaoAprendizagem = mapper.map(situacaoAprendizagemReq, SituacaoAprendizagem.class);
		situacaoAprendizagem = situacaoAprendizagemService.adicionar(situacaoAprendizagem);
		return new ResponseEntity<>(mapper.map(situacaoAprendizagem, SituacaoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SituacaoAprendizagemResponse>> obterTodos(){
		List<SituacaoAprendizagem> situacaoAprendizagems = situacaoAprendizagemService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<SituacaoAprendizagemResponse> resposta = situacaoAprendizagems.stream().map(situacaoAprendizagem -> mapper.map(situacaoAprendizagem, SituacaoAprendizagemResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<SituacaoAprendizagemResponse>> obterPorId(@PathVariable Long id){
		Optional<SituacaoAprendizagem> situacaoAprendizagemEncontrado = situacaoAprendizagemService.obterPorId(id);
		SituacaoAprendizagemResponse situacaoAprendizagem = new ModelMapper().map(situacaoAprendizagemEncontrado.get(), SituacaoAprendizagemResponse.class);
		return new ResponseEntity<>(Optional.of(situacaoAprendizagem), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SituacaoAprendizagemResponse> atualizar(@Valid @RequestBody SituacaoAprendizagemRequest situacaoAprendizagemReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagem situacaoAprendizagem = mapper.map(situacaoAprendizagemReq, SituacaoAprendizagem.class);
		situacaoAprendizagem = situacaoAprendizagemService.atualizar(id, situacaoAprendizagem);
		return new ResponseEntity<>(mapper.map(situacaoAprendizagem, SituacaoAprendizagemResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		situacaoAprendizagemService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
