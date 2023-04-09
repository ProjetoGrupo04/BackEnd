package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.GrauDificuldade;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.GrauDificuldadeRepository;

@Service
public class GrauDificuldadeService {

	@Autowired
	private GrauDificuldadeRepository grauDificuldadeRepository;
	
	public GrauDificuldade adicionar(GrauDificuldade grauDificuldade) {
		grauDificuldade.setId(null);
		grauDificuldade = grauDificuldadeRepository.save(grauDificuldade);
		grauDificuldade.setId(grauDificuldade.getId());
		return grauDificuldade;
	}
	
	public List<GrauDificuldade> obterTodos(){
		List<GrauDificuldade> grauDificuldades = grauDificuldadeRepository.findAll();
		return grauDificuldades;
	}
	
	public Optional<GrauDificuldade> obterPorId(Long id){
		Optional<GrauDificuldade> grauDificuldade = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldade.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return grauDificuldade;
	}
	
	public GrauDificuldade atualizar(Long id, GrauDificuldade grauDificuldade) {
		Optional<GrauDificuldade> grauDificuldadeId = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldadeId.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		grauDificuldade.setId(id);
		grauDificuldade.setId(id);
		grauDificuldadeRepository.save(grauDificuldade);
		return grauDificuldade;
	}
	
	
	public void deletar(Long id) {
		Optional<GrauDificuldade> grauDificuldade = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldade.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		grauDificuldadeRepository.deleteById(id);
	}
}
