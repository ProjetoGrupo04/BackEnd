package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Copetencia;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.CopetenciaRepository;

@Service
public class CopetenciaService {
	
	@Autowired
	private CopetenciaRepository copetenciaRepository;
	

	public Copetencia adicionar(Copetencia copetencia) {
		copetencia.setId(null);
		copetencia = copetenciaRepository.save(copetencia);
		copetencia.setId(copetencia.getId());
		return copetencia;
	}
	
	public List<Copetencia> obterTodos(){
		List<Copetencia> copetencias = copetenciaRepository.findAll();
		return copetencias;
	}
	
	public Optional<Copetencia> obterPorId(Long id){
		Optional<Copetencia> copetencia = copetenciaRepository.findById(id);
		
		if(copetencia.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return copetencia;
	}
	
	public Copetencia atualizar(Long id, Copetencia copetencia) {
		Optional<Copetencia> copetenciaId = copetenciaRepository.findById(id);
		
		if(copetenciaId.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		copetencia.setId(id);
		copetencia.setId(id);
		copetenciaRepository.save(copetencia);
		return copetencia;
	}
	
	
	public void deletar(Long id) {
		Optional<Copetencia> copetencia = copetenciaRepository.findById(id);
		
		if(copetencia.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		copetenciaRepository.deleteById(id);
	}
}
