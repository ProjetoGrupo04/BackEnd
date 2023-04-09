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

import com.senac.api.entity.IndicadorSituacaoAprendizagem;
import com.senac.api.request.IndicadorSituacaoAprendizagemRequest;
import com.senac.api.response.IndicadorSituacaoAprendizagemResponse;
import com.senac.api.service.IndicadorSituacaoAprendizagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/indicadorSituacaoAprendizagem")
public class IndicadorSituacaoAprendizagemController {

	@Autowired
	private IndicadorSituacaoAprendizagemService indicadorSituacaoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<IndicadorSituacaoAprendizagemResponse> adicionar(@Valid @RequestBody IndicadorSituacaoAprendizagemRequest indicadorSituacaoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem = mapper.map(indicadorSituacaoAprendizagemReq, IndicadorSituacaoAprendizagem.class);
		indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemService.adicionar(indicadorSituacaoAprendizagem);
		return new ResponseEntity<>(mapper.map(indicadorSituacaoAprendizagem, IndicadorSituacaoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<IndicadorSituacaoAprendizagemResponse>> obterTodos(){
		List<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagems = indicadorSituacaoAprendizagemService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<IndicadorSituacaoAprendizagemResponse> resposta = indicadorSituacaoAprendizagems.stream().map(indicadorSituacaoAprendizagem -> mapper.map(indicadorSituacaoAprendizagem, IndicadorSituacaoAprendizagemResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<IndicadorSituacaoAprendizagemResponse>> obterPorId(@PathVariable Long id){
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagemEncontrado = indicadorSituacaoAprendizagemService.obterPorId(id);
		IndicadorSituacaoAprendizagemResponse indicadorSituacaoAprendizagem = new ModelMapper().map(indicadorSituacaoAprendizagemEncontrado.get(), IndicadorSituacaoAprendizagemResponse.class);
		return new ResponseEntity<>(Optional.of(indicadorSituacaoAprendizagem), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<IndicadorSituacaoAprendizagemResponse> atualizar(@Valid @RequestBody IndicadorSituacaoAprendizagemRequest indicadorSituacaoAprendizagemReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem = mapper.map(indicadorSituacaoAprendizagemReq, IndicadorSituacaoAprendizagem.class);
		indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemService.atualizar(id, indicadorSituacaoAprendizagem);
		return new ResponseEntity<>(mapper.map(indicadorSituacaoAprendizagem, IndicadorSituacaoAprendizagemResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		indicadorSituacaoAprendizagemService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
