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

import com.senac.api.entity.Copetencia;
import com.senac.api.request.CopetenciaRequest;
import com.senac.api.response.CopetenciaResponse;
import com.senac.api.service.CopetenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/unidade-curricular/copetencia")
public class CopetenciaController {

	@Autowired
	private CopetenciaService copetenciaService;
	
	@PostMapping
	public ResponseEntity<CopetenciaResponse> adicionar(@Valid @RequestBody CopetenciaRequest copetenciaReq){
		ModelMapper mapper = new ModelMapper();
		Copetencia copetencia = mapper.map(copetenciaReq, Copetencia.class);
		copetencia = copetenciaService.adicionar(copetencia);
		return new ResponseEntity<>(mapper.map(copetencia, CopetenciaResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CopetenciaResponse>> obterTodos(){
		List<Copetencia> copetencias = copetenciaService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CopetenciaResponse> resposta = copetencias.stream().map(copetencia -> mapper.map(copetencia, CopetenciaResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CopetenciaResponse>> obterPorId(@PathVariable Long id){
		Optional<Copetencia> copetenciaEncontrada = copetenciaService.obterPorId(id);
		CopetenciaResponse copetencia = new ModelMapper().map(copetenciaEncontrada.get(), CopetenciaResponse.class);
		return new ResponseEntity<>(Optional.of(copetencia), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CopetenciaResponse> atualizar(@Valid @RequestBody CopetenciaRequest copetenciaReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Copetencia copetencia = mapper.map(copetenciaReq, Copetencia.class);
		copetencia = copetenciaService.atualizar(id, copetencia);
		return new ResponseEntity<>(mapper.map(copetencia, CopetenciaResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		copetenciaService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
