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

import com.senac.api.entity.PlanejamentoUc;
import com.senac.api.request.PlanejamentoUcRequest;
import com.senac.api.response.PlanejamentoUcResponse;
import com.senac.api.service.PlanejamentoUcService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/planejamentoUc")
public class PlanejamentoUcController {

	@Autowired
	private PlanejamentoUcService planejamentoUcService;
	
	@PostMapping
	public ResponseEntity<PlanejamentoUcResponse> adicionar(@Valid @RequestBody PlanejamentoUcRequest planejamentoUcReq){
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUc planejamentoUc = mapper.map(planejamentoUcReq, PlanejamentoUc.class);
		planejamentoUc = planejamentoUcService.adicionar(planejamentoUc);
		return new ResponseEntity<>(mapper.map(planejamentoUc, PlanejamentoUcResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PlanejamentoUcResponse>> obterTodos(){
		List<PlanejamentoUc> planejamentoUcs = planejamentoUcService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<PlanejamentoUcResponse> resposta = planejamentoUcs.stream().map(planejamentoUc -> mapper.map(planejamentoUc, PlanejamentoUcResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PlanejamentoUcResponse>> obterPorId(@PathVariable Long id){
		Optional<PlanejamentoUc> planejamentoUcEncontrado = planejamentoUcService.obterPorId(id);
		PlanejamentoUcResponse planejamentoUc = new ModelMapper().map(planejamentoUcEncontrado.get(), PlanejamentoUcResponse.class);
		return new ResponseEntity<>(Optional.of(planejamentoUc), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PlanejamentoUcResponse> atualizar(@Valid @RequestBody PlanejamentoUcRequest planejamentoUcReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUc planejamentoUc = mapper.map(planejamentoUcReq, PlanejamentoUc.class);
		planejamentoUc = planejamentoUcService.atualizar(id, planejamentoUc);
		return new ResponseEntity<>(mapper.map(planejamentoUc, PlanejamentoUcResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		planejamentoUcService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
