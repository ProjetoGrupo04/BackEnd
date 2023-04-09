package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.PlanejamentoUc;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.PlanejamentoUcRepository;

@Service
public class PlanejamentoUcService {

	@Autowired
	private PlanejamentoUcRepository planejamentoUcRepository;
	
	public PlanejamentoUc adicionar(PlanejamentoUc planejamentoUc) {
		planejamentoUc.setId(null);
		planejamentoUc = planejamentoUcRepository.save(planejamentoUc);
		planejamentoUc.setId(planejamentoUc.getId());
		return planejamentoUc;
	}
	
	public List<PlanejamentoUc> obterTodos(){
		List<PlanejamentoUc> planejamentoUcs = planejamentoUcRepository.findAll();
		return planejamentoUcs;
	}
	
	public Optional<PlanejamentoUc> obterPorId(Long id){
		Optional<PlanejamentoUc> planejamentoUc = planejamentoUcRepository.findById(id);
		
		if(planejamentoUc.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return planejamentoUc;
	}
	
	public PlanejamentoUc atualizar(Long id, PlanejamentoUc planejamentoUc) {
		Optional<PlanejamentoUc> planejamentoUcId = planejamentoUcRepository.findById(id);
		
		if(planejamentoUcId.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		planejamentoUc.setId(id);
		planejamentoUc.setId(id);
		planejamentoUcRepository.save(planejamentoUc);
		return planejamentoUc;
	}
	
	
	public void deletar(Long id) {
		Optional<PlanejamentoUc> planejamentoUc = planejamentoUcRepository.findById(id);
		
		if(planejamentoUc.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		planejamentoUcRepository.deleteById(id);
	}
}
