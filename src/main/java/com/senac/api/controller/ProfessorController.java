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

import com.senac.api.entity.Professor;
import com.senac.api.request.ProfessorRequest;
import com.senac.api.response.ProfessorResponse;
import com.senac.api.service.ProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;

	@PostMapping
	public ResponseEntity<ProfessorResponse> adicionar(@Valid @RequestBody ProfessorRequest professorReq){
		ModelMapper mapper = new ModelMapper();
		Professor professor = mapper.map(professorReq, Professor.class);
		professor = professorService.adicionar(professor);
		return new ResponseEntity<>(mapper.map(professor, ProfessorResponse.class), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProfessorResponse>> obterTodos(){
		List<Professor> professores = professorService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ProfessorResponse> resposta = professores.stream().map(professor -> mapper.map(professor, ProfessorResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProfessorResponse>> obterPorId(@PathVariable Long id){
		Optional<Professor> professorEncontrado = professorService.obterPorId(id);
		ProfessorResponse professor = new ModelMapper().map(professorEncontrado.get(), ProfessorResponse.class);
		return new ResponseEntity<>(Optional.of(professor), HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id){
		professorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfessorResponse> atualizar(@Valid @RequestBody ProfessorRequest professorReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Professor professor = mapper.map(professorReq,  Professor.class);
		professor = professorService.atualizar(id, professor);
		return new ResponseEntity<>(mapper.map(professor, ProfessorResponse.class), HttpStatus.OK);
	}
}
