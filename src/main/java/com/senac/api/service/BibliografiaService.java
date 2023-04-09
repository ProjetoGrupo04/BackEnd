package com.senac.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Bibliografia;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.BibliografiaRepository;

@Service
public class BibliografiaService {
	
	@Autowired
	private BibliografiaRepository bibliografiaRepository;
	
	public Bibliografia adicionar(Bibliografia bibliografia) {
		bibliografia.setId(null);	
		bibliografia = bibliografiaRepository.save(bibliografia);
		bibliografia.setId(bibliografia.getId());
		return bibliografia;
	}
	
	public List<Bibliografia> obterTodos(){
		List<Bibliografia> bibliografias = bibliografiaRepository.findAll();
		return bibliografias.stream().map(bibliografia -> new ModelMapper().map(bibliografia, Bibliografia.class)).collect((Collectors.toList()));
	}
	
	public Optional<Bibliografia> obterPorId(Long id){
		Optional<Bibliografia> bibliografia = bibliografiaRepository.findById(id);
		
		if(bibliografia.isEmpty()) {
			throw new ObjectnotFoundException("Bibliografia COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return bibliografia;
	}
	
	public void deletar(Long id) {
		Optional<Bibliografia> bibliografia = bibliografiaRepository.findById(id);
		
		if(bibliografia.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		bibliografiaRepository.deleteById(id);
	}
	
	public Bibliografia atualizar(Long id, Bibliografia bibliografia) {
		Optional<Bibliografia> bibliografiaId = bibliografiaRepository.findById(id);
		
		if(bibliografiaId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		bibliografia.setId(id);
		bibliografia.setId(id);
		bibliografiaRepository.save(bibliografia);
		return bibliografia;
	}
}
