package com.senac.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.BadgeNivel;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.BadgeNivelRepository;


@Service
public class BadgeNivelService {

	@Autowired
	private BadgeNivelRepository badgeNivelRepository;
	
	public BadgeNivel adicionar(BadgeNivel badgeNivel) {
		badgeNivel.setId(null);
		badgeNivel = badgeNivelRepository.save(badgeNivel);
		badgeNivel.setId(badgeNivel.getId());
		return badgeNivel;
	}
	
	public List<BadgeNivel> obterTodos(){
		List<BadgeNivel> badgeNiveis = badgeNivelRepository.findAll();
		return badgeNiveis.stream().map(badgeNivel -> new ModelMapper().map(badgeNivel, BadgeNivel.class)).collect((Collectors.toList()));
	}
	
	public Optional<BadgeNivel> obterPorId(Long id){
		Optional<BadgeNivel> badgeNivel = badgeNivelRepository.findById(id);
		
		if(badgeNivel.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return badgeNivel;
	}
	
	public void deletar(Long id) {
		Optional<BadgeNivel> badgeNivel = badgeNivelRepository.findById(id);
		
		if(badgeNivel.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		badgeNivelRepository.deleteById(id);
	}
	
	public BadgeNivel atualizar(Long id, BadgeNivel badgeNivel) {
		Optional<BadgeNivel> badgeNivelEncontrado = badgeNivelRepository.findById(id);
		
		if(badgeNivelEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		badgeNivel.setId(id);
		badgeNivel.setId(id);
		badgeNivelRepository.save(badgeNivel);
		return badgeNivel;
	}
	
}
