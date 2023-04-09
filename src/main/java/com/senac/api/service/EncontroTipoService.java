package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.EncontroTipo;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.EncontroTipoRepository;

@Service
public class EncontroTipoService {

	@Autowired
	private EncontroTipoRepository encontroTipoRepository;
	
	public EncontroTipo adicionar(EncontroTipo encontroTipo) {
		encontroTipo.setId(null);
		encontroTipo = encontroTipoRepository.save(encontroTipo);
		encontroTipo.setId(encontroTipo.getId());
		return encontroTipo;
	}
	
	public List<EncontroTipo> obterTodos(){
		List<EncontroTipo> encontroTipos = encontroTipoRepository.findAll();
		return encontroTipos;
	}
	
	public Optional<EncontroTipo> obterPorId(Long id){
		Optional<EncontroTipo> encontroTipo = encontroTipoRepository.findById(id);
		
		if(encontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return encontroTipo;
	}
	
	public EncontroTipo atualizar(Long id, EncontroTipo encontroTipo) {
		Optional<EncontroTipo> encontroTipoId = encontroTipoRepository.findById(id);
		
		if(encontroTipoId.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		encontroTipo.setId(id);
		encontroTipo.setId(id);
		encontroTipoRepository.save(encontroTipo);
		return encontroTipo;
	}
	
	
	public void deletar(Long id) {
		Optional<EncontroTipo> encontroTipo = encontroTipoRepository.findById(id);
		
		if(encontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		encontroTipoRepository.deleteById(id);
	}
}
