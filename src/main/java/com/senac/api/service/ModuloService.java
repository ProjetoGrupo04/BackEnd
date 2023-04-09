package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Modulo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.ModuloRepository;

@Service
public class ModuloService {

	@Autowired 
	private ModuloRepository moduloRepository;
	
	public Modulo adicionar(Modulo modulo) {
		modulo.setId(null);
		modulo = moduloRepository.save(modulo);
		modulo.setId(modulo.getId());
		return modulo;
	}
	
	public List<Modulo> obterTodos(){
		List<Modulo> modulos = moduloRepository.findAll();
		return modulos;
	}
	
	public Optional<Modulo> obterPorId(Long id){
		Optional<Modulo> modulo = moduloRepository.findById(id);
		
		if(modulo.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return modulo;
	}
	
	public Modulo atualizar(Long id, Modulo modulo) {
		Optional<Modulo> moduloId = moduloRepository.findById(id);
		
		if(moduloId.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		modulo.setId(id);
		modulo.setId(id);
		moduloRepository.save(modulo);
		return modulo;
	}
	
	public void deletar(Long id) {
		Optional<Modulo> modulo = moduloRepository.findById(id);
		
		if(modulo.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		moduloRepository.deleteById(id);
	}
	
}	
