package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Turno;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.TurnoRepository;

@Service
public class TurnoService {

	@Autowired
	private TurnoRepository turnoRepository;
	
	public Turno adicionar(Turno turno) {
		turno.setId(null);
		turno = turnoRepository.save(turno);
		turno.setId(turno.getId());
		return turno;
	}
	
	public List<Turno> obterTodos(){
		List<Turno> turnos = turnoRepository.findAll();
		return turnos;
	}
	
	public Optional<Turno> obterPorId(Long id){
		Optional<Turno> turno = turnoRepository.findById(id);
		
		if(turno.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return turno;
	}
	
	public Turno atualizar(Long id, Turno turno) {
		Optional<Turno> turnoId = turnoRepository.findById(id);
		
		if(turnoId.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		turno.setId(id);
		turno.setId(id);
		turnoRepository.save(turno);
		return turno;
	}
	
	
	public void deletar(Long id) {
		Optional<Turno> turno = turnoRepository.findById(id);
		
		if(turno.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		turnoRepository.deleteById(id);
	}
	
}
