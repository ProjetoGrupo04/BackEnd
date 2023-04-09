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

import com.senac.api.entity.CursoTipo;
import com.senac.api.request.CursoTipoRequest;
import com.senac.api.response.CursoTipoResponse;
import com.senac.api.service.CursoTipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/curso-tipo")
public class CursoTipoController {
	
	@Autowired
	private CursoTipoService cursoTipoService;
	
	@PostMapping
	public ResponseEntity<CursoTipoResponse> adicionar(@Valid @RequestBody CursoTipoRequest cursoTipoReq){
		ModelMapper mapper = new ModelMapper();
		CursoTipo cursoTipo = mapper.map(cursoTipoReq, CursoTipo.class);
		cursoTipo = cursoTipoService.adicionar(cursoTipo);
		return new ResponseEntity<>(mapper.map(cursoTipo, CursoTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoTipoResponse>> obterTodos(){
		List<CursoTipo> cursoTipos = cursoTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CursoTipoResponse> resposta = cursoTipos.stream().map(tipo -> mapper.map(tipo, CursoTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CursoTipoResponse>> obterPorId(@PathVariable Long id){
		Optional<CursoTipo> cursoTipoEncontrado = cursoTipoService.obterPorId(id);
		CursoTipoResponse cursoTipo = new ModelMapper().map(cursoTipoEncontrado.get(), CursoTipoResponse.class);
		return new ResponseEntity<>(Optional.of(cursoTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoTipoResponse> atualizar(@Valid @RequestBody CursoTipoRequest cursoTipoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		CursoTipo cursoTipo = mapper.map(cursoTipoReq, CursoTipo.class);
		cursoTipo = cursoTipoService.atualizar(id, cursoTipo);
		return new ResponseEntity<>(mapper.map(cursoTipo, CursoTipoResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		cursoTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
