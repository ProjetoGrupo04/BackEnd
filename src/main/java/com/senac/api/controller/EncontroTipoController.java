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

import com.senac.api.entity.EncontroTipo;
import com.senac.api.request.EncontroTipoRequest;
import com.senac.api.response.EncontroTipoResponse;
import com.senac.api.service.EncontroTipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/encontro-tipo")
public class EncontroTipoController {
	
	@Autowired
	private EncontroTipoService encontroTipoService;
	
	@PostMapping
	public ResponseEntity<EncontroTipoResponse> adicionar(@Valid @RequestBody EncontroTipoRequest encontroTipoReq){
		ModelMapper mapper = new ModelMapper();
		EncontroTipo encontroTipo = mapper.map(encontroTipoReq, EncontroTipo.class);
		encontroTipo = encontroTipoService.adicionar(encontroTipo);
		return new ResponseEntity<>(mapper.map(encontroTipo, EncontroTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EncontroTipoResponse>> obterTodos(){
		List<EncontroTipo> encontroTipos = encontroTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<EncontroTipoResponse> resposta = encontroTipos.stream().map(encontroTipo -> mapper.map(encontroTipo, EncontroTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EncontroTipoResponse>> obterPorId(@PathVariable Long id){
		Optional<EncontroTipo> encontroTipoEncontrado = encontroTipoService.obterPorId(id);
		EncontroTipoResponse encontroTipo = new ModelMapper().map(encontroTipoEncontrado.get(), EncontroTipoResponse.class);
		return new ResponseEntity<>(Optional.of(encontroTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EncontroTipoResponse> atualizar(@Valid @RequestBody EncontroTipoRequest encontroTipoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		EncontroTipo encontroTipo = mapper.map(encontroTipoReq, EncontroTipo.class);
		encontroTipo = encontroTipoService.atualizar(id, encontroTipo);
		return new ResponseEntity<>(mapper.map(encontroTipo, EncontroTipoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		encontroTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
