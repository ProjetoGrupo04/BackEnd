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

import com.senac.api.entity.Periodo;
import com.senac.api.request.PeriodoRequest;
import com.senac.api.response.PeriodoResponse;
import com.senac.api.service.PeriodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/periodo")
public class PeriodoController {
	
	@Autowired
	private PeriodoService periodoService;
	
	@PostMapping
	public ResponseEntity<PeriodoResponse> adicionar(@Valid @RequestBody PeriodoRequest periodoReq){
		ModelMapper mapper = new ModelMapper();
		Periodo periodo = mapper.map(periodoReq, Periodo.class);
		periodo = periodoService.adicionar(periodo);
		return new ResponseEntity<>(mapper.map(periodo, PeriodoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PeriodoResponse>> obterTodos(){
		List<Periodo> periodos = periodoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<PeriodoResponse> resposta = periodos.stream().map(periodo -> mapper.map(periodo, PeriodoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PeriodoResponse>> obterPorId(@PathVariable Long id){
		Optional<Periodo> periodoEncontrado = periodoService.obterPorId(id);
		PeriodoResponse periodo = new ModelMapper().map(periodoEncontrado.get(), PeriodoResponse.class);
		return new ResponseEntity<>(Optional.of(periodo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeriodoResponse> atualizar(@Valid @RequestBody PeriodoRequest periodoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Periodo periodo = mapper.map(periodoReq, Periodo.class);
		periodo = periodoService.atualizar(id, periodo);
		return new ResponseEntity<>(mapper.map(periodo, PeriodoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		periodoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
