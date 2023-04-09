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

import com.senac.api.entity.Estudante;
import com.senac.api.request.EstudanteRequest;
import com.senac.api.response.EstudanteResponse;
import com.senac.api.service.EstudanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@PostMapping
	public ResponseEntity<EstudanteResponse> adicionar(@Valid @RequestBody EstudanteRequest estudanteReq){
		ModelMapper mapper = new ModelMapper();
		Estudante estudante = mapper.map(estudanteReq, Estudante.class);
		estudante = estudanteService.adicionar(estudante);
		return new ResponseEntity<>(mapper.map(estudante, EstudanteResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EstudanteResponse>> obterTodos(){
		List<Estudante> estudantes = estudanteService.obterTodos();	
		ModelMapper mapper = new ModelMapper();
		List<EstudanteResponse> resposta = estudantes.stream().map(estudante -> mapper.map(estudante, EstudanteResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EstudanteResponse>> obterPorId(@PathVariable Long id){
		Optional<Estudante> estudanteEncontrado = estudanteService.obterPorId(id);
		EstudanteResponse estudante = new ModelMapper().map(estudanteEncontrado.get(), EstudanteResponse.class);
		return new ResponseEntity<>(Optional.of(estudante), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponse> atualizar(@Valid @RequestBody EstudanteRequest estudanteReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Estudante estudante = mapper.map(estudanteReq, Estudante.class);
		estudante = estudanteService.atualizar(id, estudante);
		return new ResponseEntity<>(mapper.map(estudante, EstudanteResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		estudanteService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
