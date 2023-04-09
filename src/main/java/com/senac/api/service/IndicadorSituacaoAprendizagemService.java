package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.IndicadorSituacaoAprendizagem;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.IndicadorSituacaoAprendizagemRepository;

@Service
public class IndicadorSituacaoAprendizagemService {
	
	@Autowired
	private IndicadorSituacaoAprendizagemRepository indicadorSituacaoAprendizagemRepository;
	
	public IndicadorSituacaoAprendizagem adicionar(IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem) {
		indicadorSituacaoAprendizagem.setId(null);
		indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.save(indicadorSituacaoAprendizagem);
		indicadorSituacaoAprendizagem.setId(indicadorSituacaoAprendizagem.getId());
		return indicadorSituacaoAprendizagem;
	}
	
	public List<IndicadorSituacaoAprendizagem> obterTodos(){
		List<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagems = indicadorSituacaoAprendizagemRepository.findAll();
		return indicadorSituacaoAprendizagems;
	}
	
	public Optional<IndicadorSituacaoAprendizagem> obterPorId(Long id){
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return indicadorSituacaoAprendizagem;
	}
	
	public IndicadorSituacaoAprendizagem atualizar(Long id, IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem) {
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagemId = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagemId.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		indicadorSituacaoAprendizagem.setId(id);
		indicadorSituacaoAprendizagem.setId(id);
		indicadorSituacaoAprendizagemRepository.save(indicadorSituacaoAprendizagem);
		return indicadorSituacaoAprendizagem;
	}
	
	
	public void deletar(Long id) {
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		indicadorSituacaoAprendizagemRepository.deleteById(id);
	}
	
}
