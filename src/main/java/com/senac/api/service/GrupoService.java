package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Grupo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public Grupo adicionar(Grupo grupo) {
		grupo.setId(null);
		grupo = grupoRepository.save(grupo);
		grupo.setId(grupo.getId());
		return grupo;
	}
	
	public List<Grupo> obterTodos(){
		List<Grupo> grupos = grupoRepository.findAll();
		return grupos;
	}
	
	public Optional<Grupo> obterPorId(Long id){
		Optional<Grupo> grupo = grupoRepository.findById(id);
		
		if(grupo.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return grupo;
	}
	
	public Grupo atualizar(Long id, Grupo grupo) {
		Optional<Grupo> grupoId = grupoRepository.findById(id);
		
		if(grupoId.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		grupo.setId(id);
		grupo.setId(id);
		grupoRepository.save(grupo);
		return grupo;
	}
	
	
	public void deletar(Long id) {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		
		if(grupo.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		grupoRepository.deleteById(id);
	}
}
