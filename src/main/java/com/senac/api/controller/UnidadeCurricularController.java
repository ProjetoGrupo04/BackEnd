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

import com.senac.api.entity.UnidadeCurricular;
import com.senac.api.request.UnidadeCurricularRequest;
import com.senac.api.response.UnidadeCurricularResponse;
import com.senac.api.service.UnidadeCurricularService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/unidade-curricular")
public class UnidadeCurricularController {
	
	@Autowired
	private UnidadeCurricularService unidadeCurricularService;
	
	@PostMapping
	public ResponseEntity<UnidadeCurricularResponse> adicionar(@Valid @RequestBody UnidadeCurricularRequest unidadeCurricularReq){
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricular unidadeCurricular = mapper.map(unidadeCurricularReq, UnidadeCurricular.class);
		unidadeCurricular = unidadeCurricularService.adicionar(unidadeCurricular);
		return new ResponseEntity<>(mapper.map(unidadeCurricular, UnidadeCurricularResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UnidadeCurricularResponse>> obterTodos(){
		List<UnidadeCurricular> unidadeCurriculares = unidadeCurricularService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<UnidadeCurricularResponse> resposta = unidadeCurriculares.stream().map(unidadeCurricular -> mapper.map(unidadeCurricular, UnidadeCurricularResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UnidadeCurricularResponse>> obterPorId(@PathVariable Long id){
		Optional<UnidadeCurricular> unidadeCurricularEncontrada = unidadeCurricularService.obterPorId(id);
		UnidadeCurricularResponse unidadeCurricular = new ModelMapper().map(unidadeCurricularEncontrada.get(), UnidadeCurricularResponse.class);
		return new ResponseEntity<>(Optional.of(unidadeCurricular), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UnidadeCurricularResponse> atualizar(@Valid @RequestBody UnidadeCurricularRequest unidadeCurricularReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricular unidadeCurricular = mapper.map(unidadeCurricularReq, UnidadeCurricular.class);
		unidadeCurricular = unidadeCurricularService.atualizar(id, unidadeCurricular);
		return new ResponseEntity<>(mapper.map(unidadeCurricular, UnidadeCurricularResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		unidadeCurricularService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
