package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Oferta;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.OfertaRepository;

@Service
public class OfertaService {

	@Autowired 
	private OfertaRepository ofertaRepository;
	
	public Oferta adicionar(Oferta oferta) {
		oferta.setId(null);
		oferta = ofertaRepository.save(oferta);
		oferta.setId(oferta.getId());
		return oferta;
	}
	
	public List<Oferta> obterTodos(){
		List<Oferta> ofertas = ofertaRepository.findAll();
		return ofertas;
	}
	
	public Optional<Oferta> obterPorId(Long id){
		Optional<Oferta> oferta = ofertaRepository.findById(id);
		
		if(oferta.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return oferta;
	}
	
	public Oferta atualizar(Long id, Oferta oferta) {
		Optional<Oferta> ofertaId = ofertaRepository.findById(id);
		
		if(ofertaId.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		oferta.setId(id);
		oferta.setId(id);
		ofertaRepository.save(oferta);
		return oferta;
	}
	
	public void deletar(Long id) {
		Optional<Oferta> oferta = ofertaRepository.findById(id);
		
		if(oferta.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		ofertaRepository.deleteById(id);
	}
}
