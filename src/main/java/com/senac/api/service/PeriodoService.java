package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Periodo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.PeriodoRepository;

@Service
public class PeriodoService {

	@Autowired 
	private PeriodoRepository periodoRepository;
	
	public Periodo adicionar(Periodo periodo) {
		periodo.setId(null);
		periodo = periodoRepository.save(periodo);
		periodo.setId(periodo.getId());
		return periodo;
	}
	
	public List<Periodo> obterTodos(){
		List<Periodo> periodos = periodoRepository.findAll();
		return periodos;
	}
	
	public Optional<Periodo> obterPorId(Long id){
		Optional<Periodo> periodo = periodoRepository.findById(id);
		
		if(periodo.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return periodo;
	}
	
	public Periodo atualizar(Long id, Periodo periodo) {
		Optional<Periodo> periodoId = periodoRepository.findById(id);
		
		if(periodoId.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		periodo.setId(id);
		periodo.setId(id);
		periodoRepository.save(periodo);
		return periodo;
	}
	
	
	public void deletar(Long id) {
		Optional<Periodo> periodo = periodoRepository.findById(id);
		
		if(periodo.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		periodoRepository.deleteById(id);
	}
}
