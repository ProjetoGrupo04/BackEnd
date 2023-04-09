package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.DiaLetivo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.DiaLetivoRepository;

@Service
public class DiaLetivoService {

	@Autowired
	private DiaLetivoRepository diaLetivoRepository;
	
	public DiaLetivo adicionar(DiaLetivo diaLetivo) {
		diaLetivo.setId(null);
		diaLetivo = diaLetivoRepository.save(diaLetivo);
		diaLetivo.setId(diaLetivo.getId());
		return diaLetivo;
	}
	
	public List<DiaLetivo> obterTodos(){
		List<DiaLetivo> diaLetivos = diaLetivoRepository.findAll();
		return diaLetivos;
	}
	
	public Optional<DiaLetivo> obterPorId(Long id){
		Optional<DiaLetivo> diaLetivo = diaLetivoRepository.findById(id);
		
		if(diaLetivo.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return diaLetivo;
	}
	
	public DiaLetivo atualizar(Long id, DiaLetivo diaLetivo) {
		Optional<DiaLetivo> diaLetivoId = diaLetivoRepository.findById(id);
		
		if(diaLetivoId.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		diaLetivo.setId(id);
		diaLetivo.setId(id);
		diaLetivoRepository.save(diaLetivo);
		return diaLetivo;
	}
	
	
	public void deletar(Long id) {
		Optional<DiaLetivo> diaLetivo = diaLetivoRepository.findById(id);
		
		if(diaLetivo.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		diaLetivoRepository.deleteById(id);
	}
}
