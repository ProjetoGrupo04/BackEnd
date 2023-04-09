package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.UnidadeCurricular;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.UnidadeCurricularRepository;

@Service
public class UnidadeCurricularService {

	@Autowired
	private UnidadeCurricularRepository unidadeCurricularRepository;
	
	public UnidadeCurricular adicionar(UnidadeCurricular unidadeCurricular) {
		unidadeCurricular.setId(null);
		unidadeCurricular = unidadeCurricularRepository.save(unidadeCurricular);
		unidadeCurricular.setId(unidadeCurricular.getId());
		return unidadeCurricular;
	}
	
	public List<UnidadeCurricular> obterTodos(){
		List<UnidadeCurricular> unidadeCurriculares = unidadeCurricularRepository.findAll();
		return unidadeCurriculares;
	}
	
	public Optional<UnidadeCurricular> obterPorId(Long id){
		Optional<UnidadeCurricular> unidadeCurricular = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricular.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return unidadeCurricular;
	}
	
	public UnidadeCurricular atualizar(Long id, UnidadeCurricular unidadeCurricular) {
		Optional<UnidadeCurricular> unidadeCurricularId = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricularId.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		unidadeCurricular.setId(id);
		unidadeCurricular.setId(id);
		unidadeCurricularRepository.save(unidadeCurricular);
		return unidadeCurricular;
	}
	
	
	public void deletar(Long id) {
		Optional<UnidadeCurricular> unidadeCurricular = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricular.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		unidadeCurricularRepository.deleteById(id);
	}

}
