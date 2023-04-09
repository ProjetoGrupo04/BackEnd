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

import com.senac.api.entity.Grupo;
import com.senac.api.request.GrupoRequest;
import com.senac.api.response.GrupoResponse;
import com.senac.api.service.GrupoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@PostMapping
	public ResponseEntity<GrupoResponse> adicionar(@Valid @RequestBody GrupoRequest grupoReq){
		ModelMapper mapper = new ModelMapper();
		Grupo grupo = mapper.map(grupoReq, Grupo.class);
		grupo = grupoService.adicionar(grupo);
		return new ResponseEntity<>(mapper.map(grupo, GrupoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<GrupoResponse>> obterTodos(){
		List<Grupo> grupos = grupoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<GrupoResponse> resposta = grupos.stream().map(grupo -> mapper.map(grupo, GrupoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GrupoResponse>> obterPorId(@PathVariable Long id){
		Optional<Grupo> grupoEncontrado = grupoService.obterPorId(id);
		GrupoResponse grupo = new ModelMapper().map(grupoEncontrado.get(), GrupoResponse.class);
		return new ResponseEntity<>(Optional.of(grupo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrupoResponse> atualizar(@Valid @RequestBody GrupoRequest grupoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Grupo grupo = mapper.map(grupoReq, Grupo.class);
		grupo = grupoService.atualizar(id, grupo);
		return new ResponseEntity<>(mapper.map(grupo, GrupoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		grupoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
