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

import com.senac.api.entity.Turno;
import com.senac.api.request.TurnoRequest;
import com.senac.api.response.TurnoResponse;
import com.senac.api.service.TurnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

	@Autowired
	private TurnoService turnoService;
	
	@PostMapping
	public ResponseEntity<TurnoResponse> adicionar(@Valid @RequestBody TurnoRequest turnoReq){
		ModelMapper mapper = new ModelMapper();
		Turno turno = mapper.map(turnoReq, Turno.class);
		turno = turnoService.adicionar(turno);
		return new ResponseEntity<>(mapper.map(turno, TurnoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TurnoResponse>> obterTodos(){
		List<Turno> turnos = turnoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<TurnoResponse> resposta = turnos.stream().map(turno -> mapper.map(turno, TurnoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TurnoResponse>> obterPorId(@PathVariable Long id){
		Optional<Turno> turnoEncontrado = turnoService.obterPorId(id);
		TurnoResponse turno = new ModelMapper().map(turnoEncontrado.get(), TurnoResponse.class);
		return new ResponseEntity<>(Optional.of(turno), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TurnoResponse> atualizar(@Valid @RequestBody TurnoRequest turnoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Turno turno = mapper.map(turnoReq, Turno.class);
		turno = turnoService.atualizar(id, turno);
		return new ResponseEntity<>(mapper.map(turno, TurnoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		turnoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
