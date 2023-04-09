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

import com.senac.api.entity.Oferta;
import com.senac.api.request.OfertaRequest;
import com.senac.api.response.OfertaResponse;
import com.senac.api.service.OfertaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/oferta")
public class OfertaController {

	@Autowired
	private OfertaService ofertaService;
	
	@PostMapping
	public ResponseEntity<OfertaResponse> adicionar(@Valid @RequestBody OfertaRequest ofertaReq){
		ModelMapper mapper = new ModelMapper();
		Oferta oferta = mapper.map(ofertaReq, Oferta.class);
		oferta = ofertaService.adicionar(oferta);
		return new ResponseEntity<>(mapper.map(oferta, OfertaResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OfertaResponse>> obterTodos(){
		List<Oferta> ofertas = ofertaService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<OfertaResponse> resposta = ofertas.stream().map(oferta -> mapper.map(oferta, OfertaResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<OfertaResponse>> obterPorId(@PathVariable Long id){
		Optional<Oferta> ofertaEncontrada = ofertaService.obterPorId(id);
		OfertaResponse oferta = new ModelMapper().map(ofertaEncontrada.get(), OfertaResponse.class);
		return new ResponseEntity<>(Optional.of(oferta), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OfertaResponse> atualizar(@Valid @RequestBody OfertaRequest ofertaReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Oferta oferta = mapper.map(ofertaReq, Oferta.class);
		oferta = ofertaService.atualizar(id, oferta);
		return new ResponseEntity<>(mapper.map(oferta, OfertaResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		ofertaService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
