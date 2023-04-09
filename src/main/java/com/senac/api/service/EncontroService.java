package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Encontro;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.EncontroRepository;

@Service
public class EncontroService {
	
	@Autowired
	private EncontroRepository encontroRepository;
	
	public Encontro adicionar(Encontro encontro) {
		encontro.setId(null);
		encontro = encontroRepository.save(encontro);
		encontro.setId(encontro.getId());
		return encontro;
	}
	
	public List<Encontro> obterTodos(){
		List<Encontro> encontros = encontroRepository.findAll();
		return encontros;
	}
	
	public Optional<Encontro> obterPorId(Long id){
		Optional<Encontro> encontro = encontroRepository.findById(id);
		
		if(encontro.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return encontro;
	}
	
	public Encontro atualizar(Long id, Encontro encontro) {
		Optional<Encontro> encontroId = encontroRepository.findById(id);
		
		if(encontroId.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		encontro.setId(id);
		encontro.setId(id);
		encontroRepository.save(encontro);
		return encontro;
	}
	
	
	public void deletar(Long id) {
		Optional<Encontro> encontro = encontroRepository.findById(id);
		
		if(encontro.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRo COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		encontroRepository.deleteById(id);
	}
}
