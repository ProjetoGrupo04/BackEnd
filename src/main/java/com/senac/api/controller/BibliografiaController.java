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

import com.senac.api.entity.Bibliografia;
import com.senac.api.request.BibliografiaRequest;
import com.senac.api.response.BibliografiaResponse;
import com.senac.api.service.BibliografiaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/unidade-curricular/bibliografia")///api/unidade-curricular/bibliografia
public class BibliografiaController {
	
	@Autowired
	private BibliografiaService bibliografiaService;
	
	@PostMapping
	public ResponseEntity<BibliografiaResponse> adicionar(@Valid @RequestBody BibliografiaRequest bibliografiaReq){
		ModelMapper mapper = new ModelMapper();
		Bibliografia bibliografia = mapper.map(bibliografiaReq, Bibliografia.class);
		bibliografia = bibliografiaService.adicionar(bibliografia);
		return new ResponseEntity<>(mapper.map(bibliografia, BibliografiaResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BibliografiaResponse>> obterTodos(){
		List<Bibliografia> cursos = bibliografiaService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<BibliografiaResponse> resposta = cursos.stream().map(curso -> mapper.map(curso, BibliografiaResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<BibliografiaResponse>> obterPorId(@PathVariable Long id){
		Optional<Bibliografia> bibliografiaEncontrada = bibliografiaService.obterPorId(id);
		BibliografiaResponse curso = new ModelMapper().map(bibliografiaEncontrada.get(), BibliografiaResponse.class);
		return new ResponseEntity<>(Optional.of(curso), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BibliografiaResponse> atualizar(@Valid @RequestBody BibliografiaRequest bibliografiaReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Bibliografia bibliografia = mapper.map(bibliografiaReq, Bibliografia.class);
		bibliografia = bibliografiaService.atualizar(id, bibliografia);
		return new ResponseEntity<>(mapper.map(bibliografia, BibliografiaResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		bibliografiaService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
