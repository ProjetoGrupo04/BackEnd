package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.senac.api.entity.Badge;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.BadgeRepository;


@Service
public class BadgeService {
	
	@Autowired
	private BadgeRepository badgeRepository;
	
	public Badge adicionar(Badge badge) {
		badge.setId(null);	
		badge = badgeRepository.save(badge);
		badge.setId(badge.getId());
		return badge;
	}
	
	public Badge upload(MultipartFile file, Badge badge) throws Exception {
		   //ModelMapper mapper = new ModelMapper();
	       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence " + fileName);
	            }

	            return badgeRepository.save(badge);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}

	public List<Badge> buscar(Badge badge){
		//ModelMapper mapper = new ModelMapper();
		//Badge filter = mapper.map(badge,  Badge.class);
		Example<Badge> badgesFiltrados = Example.of(badge, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return badgeRepository.findAll(badgesFiltrados);
	}
	
	
	public List<Badge> obterTodos(){
		List<Badge> badges = badgeRepository.findAll();
		return badges;//badges.stream().map(badge -> new ModelMapper().map(badge, Badge.class)).collect((Collectors.toList()));
	}
	
	public Optional<Badge> obterPorId(Long id){
		Optional<Badge> badge = badgeRepository.findById(id);
		
		if(badge.isEmpty()) {
			throw new ObjectnotFoundException("BADGE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return badge;
	}
	
	public List<Badge> obterPorNivel(Long id){
		List<Badge> badges = badgeRepository.findByNivel(id);
		
		if(badges.isEmpty()) {
			throw new ObjectnotFoundException("NÍVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return badges; //.stream().map(badge -> new ModelMapper().map(badge, Badge.class)).collect((Collectors.toList()));
	}
	
	
	public void deletar(Long id) {
		Optional<Badge> badge = badgeRepository.findById(id);
		
		if(badge.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		badgeRepository.deleteById(id);
	}
	
	public Badge atualizar(Long id, Badge badge) {
		Optional<Badge> badgeId = badgeRepository.findById(id);
		if(badgeId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		badge.setId(id);
		badge.setId(id);
		badgeRepository.save(badge);
		return badge;
	}
	
}
