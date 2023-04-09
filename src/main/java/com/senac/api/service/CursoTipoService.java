package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.CursoTipo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.CursoTipoRepository;

@Service
public class CursoTipoService {

	@Autowired
	private CursoTipoRepository cursoTipoRepository;
	
	public CursoTipo adicionar(CursoTipo cursoTipo) {
		cursoTipo.setId(null);
		cursoTipo = cursoTipoRepository.save(cursoTipo);
		cursoTipo.setId(cursoTipo.getId());
		return cursoTipo;
	}
	
	public List<CursoTipo> obterTodos(){
		List<CursoTipo> cursoTipos = cursoTipoRepository.findAll();
		return cursoTipos;
	}
	
	public Optional<CursoTipo> obterPorId(Long id){
		Optional<CursoTipo> cursoTipo = cursoTipoRepository.findById(id);
		
		if(cursoTipo.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		return cursoTipo;
	}
	
	public CursoTipo atualizar(Long id, CursoTipo cursoTipo) {
		Optional<CursoTipo> cursoTipoId = cursoTipoRepository.findById(id);
		
		if(cursoTipoId.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		cursoTipo.setId(id);
		cursoTipo.setId(id);
		cursoTipoRepository.save(cursoTipo);
		return cursoTipo;
	}
	
	public void deletar(Long id) {
		Optional<CursoTipo> cursoTipo = cursoTipoRepository.findById(id);
		
		if(cursoTipo.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		cursoTipoRepository.deleteById(id);
	}
}
