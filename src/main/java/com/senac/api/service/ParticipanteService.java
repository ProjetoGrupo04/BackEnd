package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Participante;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public Participante adicionar(Participante participante) {
		participante.setId(null);
		participante = participanteRepository.save(participante);
		participante.setId(participante.getId());
		return participante;
	}
	
	public List<Participante> obterTodos(){
		List<Participante> participantes = participanteRepository.findAll();
		return participantes;
	}
	
	public Optional<Participante> obterPorId(Long id){
		Optional<Participante> participante = participanteRepository.findById(id);
		
		if(participante.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return participante;
	}
	
	public Participante atualizar(Long id, Participante participante) {
		Optional<Participante> participanteId = participanteRepository.findById(id);
		
		if(participanteId.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		participante.setId(id);
		participante.setId(id);
		participanteRepository.save(participante);
		return participante;
	}
	
	
	public void deletar(Long id) {
		Optional<Participante> participante = participanteRepository.findById(id);
		
		if(participante.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		participanteRepository.deleteById(id);
	}
}
