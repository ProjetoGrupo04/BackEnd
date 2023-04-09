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

import com.senac.api.entity.CopetenciaIndicador;
import com.senac.api.request.CopetenciaIndicadorRequest;
import com.senac.api.response.CopetenciaIndicadorResponse;
import com.senac.api.service.CopetenciaIndicadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/copetencia-indicador")
public class CopetenciaIndicadorController {

	@Autowired
	private CopetenciaIndicadorService copetenciaIndicadorService;
	
	@PostMapping
	public ResponseEntity<CopetenciaIndicadorResponse> adicionar(@Valid @RequestBody CopetenciaIndicadorRequest copetenciaIndicadorReq){
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicador copetenciaIndicador = mapper.map(copetenciaIndicadorReq, CopetenciaIndicador.class);
		copetenciaIndicador = copetenciaIndicadorService.adicionar(copetenciaIndicador);
		return new ResponseEntity<>(mapper.map(copetenciaIndicador, CopetenciaIndicadorResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CopetenciaIndicadorResponse>> obterTodos(){
		List<CopetenciaIndicador> copetenciaIndicadores = copetenciaIndicadorService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CopetenciaIndicadorResponse> resposta = copetenciaIndicadores.stream().map(copetenciaIndicador -> mapper.map(copetenciaIndicador, CopetenciaIndicadorResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CopetenciaIndicadorResponse>> obterPorId(@PathVariable Long id){
		Optional<CopetenciaIndicador> CopetenciaIndicadorEncontrado = copetenciaIndicadorService.obterPorId(id);
		CopetenciaIndicadorResponse copetenciaIndicador = new ModelMapper().map(CopetenciaIndicadorEncontrado.get(), CopetenciaIndicadorResponse.class);
		return new ResponseEntity<>(Optional.of(copetenciaIndicador), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CopetenciaIndicadorResponse> atualizar(@Valid @RequestBody CopetenciaIndicadorRequest copetenciaIndicadorReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicador copetenciaIndicador = mapper.map(copetenciaIndicadorReq, CopetenciaIndicador.class);
		copetenciaIndicador = copetenciaIndicadorService.atualizar(id, copetenciaIndicador);
		return new ResponseEntity<>(mapper.map(copetenciaIndicador, CopetenciaIndicadorResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		copetenciaIndicadorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
