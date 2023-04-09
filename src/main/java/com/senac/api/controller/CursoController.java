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

import com.senac.api.entity.Curso;
import com.senac.api.request.CursoRequest;
import com.senac.api.response.CursoResponse;
import com.senac.api.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<CursoResponse> adicionar(@Valid @RequestBody CursoRequest cursoReq){
		ModelMapper mapper = new ModelMapper();
		Curso curso = mapper.map(cursoReq, Curso.class);
		curso = cursoService.adicionar(curso);
		return new ResponseEntity<>(mapper.map(curso, CursoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoResponse>> obterTodos(){
		List<Curso> cursos = cursoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CursoResponse> resposta = cursos.stream().map(curso -> mapper.map(curso, CursoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CursoResponse>> obterPorId(@PathVariable Long id){
		Optional<Curso> cursoEncontrado = cursoService.obterPorId(id);
		CursoResponse curso = new ModelMapper().map(cursoEncontrado.get(), CursoResponse.class);
		return new ResponseEntity<>(Optional.of(curso), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoResponse> atualizar(@Valid @RequestBody CursoRequest cursoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Curso curso = mapper.map(cursoReq, Curso.class);
		curso = cursoService.atualizar(id, curso);
		return new ResponseEntity<>(mapper.map(curso, CursoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		cursoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
