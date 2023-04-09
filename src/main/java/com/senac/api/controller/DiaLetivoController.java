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

import com.senac.api.entity.DiaLetivo;
import com.senac.api.request.DiaLetivoRequest;
import com.senac.api.response.DiaLetivoResponse;
import com.senac.api.service.DiaLetivoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dia-letivo")
public class DiaLetivoController {

	@Autowired
	private DiaLetivoService diaLetivoService;
	
	@PostMapping
	public ResponseEntity<DiaLetivoResponse> adicionar(@Valid @RequestBody DiaLetivoRequest diaLetivoReq){
		ModelMapper mapper = new ModelMapper();
		DiaLetivo diaLetivo = mapper.map(diaLetivoReq, DiaLetivo.class);
		diaLetivo = diaLetivoService.adicionar(diaLetivo);
		return new ResponseEntity<>(mapper.map(diaLetivo, DiaLetivoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DiaLetivoResponse>> obterTodos(){
		List<DiaLetivo> diaLetivos = diaLetivoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<DiaLetivoResponse> resposta = diaLetivos.stream().map(diaLetivo -> mapper.map(diaLetivo, DiaLetivoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<DiaLetivoResponse>> obterPorId(@PathVariable Long id){
		Optional<DiaLetivo> diaLetivoEncontrado = diaLetivoService.obterPorId(id);
		DiaLetivoResponse diaLetivo = new ModelMapper().map(diaLetivoEncontrado.get(), DiaLetivoResponse.class);
		return new ResponseEntity<>(Optional.of(diaLetivo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiaLetivoResponse> atualizar(@Valid @RequestBody DiaLetivoRequest diaLetivoReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		DiaLetivo diaLetivo = mapper.map(diaLetivoReq, DiaLetivo.class);
		diaLetivo = diaLetivoService.atualizar(id, diaLetivo);
		return new ResponseEntity<>(mapper.map(diaLetivo, DiaLetivoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		diaLetivoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
