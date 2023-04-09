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

import com.senac.api.entity.Encontro;
import com.senac.api.request.EncontroRequest;
import com.senac.api.response.EncontroResponse;
import com.senac.api.service.EncontroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/encontro")
public class EncontroController {

	@Autowired
	private EncontroService encontroService;
	
	@PostMapping
	public ResponseEntity<EncontroResponse> adicionar(@Valid @RequestBody EncontroRequest encontroReq){
		ModelMapper mapper = new ModelMapper();
		Encontro encontro = mapper.map(encontroReq, Encontro.class);
		encontro = encontroService.adicionar(encontro);
		return new ResponseEntity<>(mapper.map(encontro, EncontroResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EncontroResponse>> obterTodos(){
		List<Encontro> encontros = encontroService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<EncontroResponse> resposta = encontros.stream().map(encontro -> mapper.map(encontro, EncontroResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EncontroResponse>> obterPorId(@PathVariable Long id){
		Optional<Encontro> encontroEncontrado = encontroService.obterPorId(id);
		EncontroResponse encontro = new ModelMapper().map(encontroEncontrado.get(), EncontroResponse.class);
		return new ResponseEntity<>(Optional.of(encontro), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EncontroResponse> atualizar(@Valid @RequestBody EncontroRequest encontroReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Encontro encontro = mapper.map(encontroReq, Encontro.class);
		encontro = encontroService.atualizar(id, encontro);
		return new ResponseEntity<>(mapper.map(encontro, EncontroResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		encontroService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
