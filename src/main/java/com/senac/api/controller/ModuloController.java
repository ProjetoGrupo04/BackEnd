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

import com.senac.api.entity.Modulo;
import com.senac.api.request.ModuloRequest;
import com.senac.api.response.ModuloResponse;
import com.senac.api.service.ModuloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/modulo")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@PostMapping
	public ResponseEntity<ModuloResponse> adicionar(@Valid @RequestBody ModuloRequest ModuloReq){
		ModelMapper mapper = new ModelMapper();
		Modulo modulo = mapper.map(ModuloReq, Modulo.class);
		modulo = moduloService.adicionar(modulo);
		return new ResponseEntity<>(mapper.map(modulo, ModuloResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ModuloResponse>> obterTodos(){
		List<Modulo> modulos = moduloService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ModuloResponse> resposta = modulos.stream().map(modulo -> mapper.map(modulo, ModuloResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ModuloResponse>> obterPorId(@PathVariable Long id){
		Optional<Modulo> moduloEncontrado = moduloService.obterPorId(id);
		ModuloResponse Modulo = new ModelMapper().map(moduloEncontrado.get(), ModuloResponse.class);
		return new ResponseEntity<>(Optional.of(Modulo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ModuloResponse> atualizar(@Valid @RequestBody ModuloRequest ofertaReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Modulo modulo = mapper.map(ofertaReq, Modulo.class);
		modulo = moduloService.atualizar(id, modulo);
		return new ResponseEntity<>(mapper.map(modulo, ModuloResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		moduloService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
