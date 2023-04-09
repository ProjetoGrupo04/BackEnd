package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.SituacaoAprendizagem;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.SituacaoAprendizagemRepository;

@Service
public class SituacaoAprendizagemService {
	
	@Autowired
	private SituacaoAprendizagemRepository situacaoAprendizagemRepository;
	
	public SituacaoAprendizagem adicionar(SituacaoAprendizagem situacaoAprendizagem) {
		situacaoAprendizagem.setId(null);
		situacaoAprendizagem = situacaoAprendizagemRepository.save(situacaoAprendizagem);
		situacaoAprendizagem.setId(situacaoAprendizagem.getId());
		System.out.println("Situacao_aprendizagem_id: " + situacaoAprendizagem.getId());
		return situacaoAprendizagem;
	}
	
	public List<SituacaoAprendizagem> obterTodos(){
		List<SituacaoAprendizagem> situacaoAprendizagems = situacaoAprendizagemRepository.findAll();
		return situacaoAprendizagems;
	}
	
	public Optional<SituacaoAprendizagem> obterPorId(Long id){
		Optional<SituacaoAprendizagem> situacaoAprendizagem = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}

		return situacaoAprendizagem;
	}
	
	public SituacaoAprendizagem atualizar(Long id, SituacaoAprendizagem situacaoAprendizagem) {
		Optional<SituacaoAprendizagem> situacaoAprendizagemId = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagemId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		situacaoAprendizagem.setId(id);
		situacaoAprendizagem.setId(id);
		situacaoAprendizagemRepository.save(situacaoAprendizagem);
		return situacaoAprendizagem;
	}
	
	
	public void deletar(Long id) {
		Optional<SituacaoAprendizagem> situacaoAprendizagem = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		situacaoAprendizagemRepository.deleteById(id);
	}
}
