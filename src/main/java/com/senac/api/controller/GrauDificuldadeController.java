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

import com.senac.api.entity.GrauDificuldade;
import com.senac.api.request.GrauDificuldadeRequest;
import com.senac.api.response.GrauDificuldadeResponse;
import com.senac.api.service.GrauDificuldadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/grauDificuldade")
public class GrauDificuldadeController {

	@Autowired 
	private GrauDificuldadeService grauDificuldadeService;
	
	@PostMapping
	public ResponseEntity<GrauDificuldadeResponse> adicionar(@Valid @RequestBody GrauDificuldadeRequest grauDificuldadeReq){
		ModelMapper mapper = new ModelMapper();
		GrauDificuldade grauDificuldade = mapper.map(grauDificuldadeReq, GrauDificuldade.class);
		grauDificuldade = grauDificuldadeService.adicionar(grauDificuldade);
		return new ResponseEntity<>(mapper.map(grauDificuldade, GrauDificuldadeResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<GrauDificuldadeResponse>> obterTodos(){
		List<GrauDificuldade> grauDificuldades = grauDificuldadeService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<GrauDificuldadeResponse> resposta = grauDificuldades.stream().map(grauDificuldade -> mapper.map(grauDificuldade, GrauDificuldadeResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GrauDificuldadeResponse>> obterPorId(@PathVariable Long id){
		Optional<GrauDificuldade> grauDificuldadeEncontrado = grauDificuldadeService.obterPorId(id);
		GrauDificuldadeResponse grauDificuldade = new ModelMapper().map(grauDificuldadeEncontrado.get(), GrauDificuldadeResponse.class);
		return new ResponseEntity<>(Optional.of(grauDificuldade), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrauDificuldadeResponse> atualizar(@Valid @RequestBody GrauDificuldadeRequest grauDificuldadeReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		GrauDificuldade grauDificuldade = mapper.map(grauDificuldadeReq, GrauDificuldade.class);
		grauDificuldade = grauDificuldadeService.atualizar(id, grauDificuldade);
		return new ResponseEntity<>(mapper.map(grauDificuldade, GrauDificuldadeResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		grauDificuldadeService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
