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

import com.senac.api.entity.Participante;
import com.senac.api.request.ParticipanteRequest;
import com.senac.api.response.ParticipanteResponse;
import com.senac.api.service.ParticipanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;
	
	@PostMapping
	public ResponseEntity<ParticipanteResponse> adicionar(@Valid @RequestBody ParticipanteRequest participanteReq){
		ModelMapper mapper = new ModelMapper();
		Participante participante = mapper.map(participanteReq, Participante.class);
		participante = participanteService.adicionar(participante);
		return new ResponseEntity<>(mapper.map(participante, ParticipanteResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ParticipanteResponse>> obterTodos(){
		List<Participante> participantes = participanteService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ParticipanteResponse> resposta = participantes.stream().map(participante -> mapper.map(participante, ParticipanteResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ParticipanteResponse>> obterPorId(@PathVariable Long id){
		Optional<Participante> participanteEncontrado = participanteService.obterPorId(id);
		ParticipanteResponse participante = new ModelMapper().map(participanteEncontrado.get(), ParticipanteResponse.class);
		return new ResponseEntity<>(Optional.of(participante), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParticipanteResponse> atualizar(@Valid @RequestBody ParticipanteRequest participanteReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Participante participante = mapper.map(participanteReq, Participante.class);
		participante = participanteService.atualizar(id, participante);
		return new ResponseEntity<>(mapper.map(participante, ParticipanteResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		participanteService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
