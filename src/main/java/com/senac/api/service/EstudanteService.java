package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Estudante;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired 
	private EstudanteRepository estudanteRepository;
	
	public Estudante adicionar(Estudante estudante) {
		estudante.setId(null);
		estudante = estudanteRepository.save(estudante);
		estudante.setId(estudante.getId());
		return estudante;
	}
	
	public List<Estudante> obterTodos(){
		List<Estudante> estudantes = estudanteRepository.findAll();
		return estudantes;
	}
	
	public Optional<Estudante> obterPorId(Long id){
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		
		if(estudante.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		return estudante;
	}
	
	public Estudante atualizar(Long id, Estudante estudante) {
		Optional<Estudante> estudanteId = estudanteRepository.findById(id);
		
		if(estudanteId.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		estudante.setId(id);
		estudante.setId(id);
		estudanteRepository.save(estudante);
		return estudante;
	}
	
	public void deletar(Long id) {
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		
		if(estudante.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		estudanteRepository.deleteById(id);
	}
	
}
