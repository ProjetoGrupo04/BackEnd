package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.senac.api.entity.ObjetoAprendizagem;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.ObjetoAprendizagemRepository;

@Service
public class ObjetoAprendizagemService {
	
	@Autowired
	private ObjetoAprendizagemRepository objetoAprendizagemRepository;
	
	public ObjetoAprendizagem adicionar(ObjetoAprendizagem obj) {
		obj.setId(null);
		obj = objetoAprendizagemRepository.save(obj);
		return obj;
	}
	
	public ObjetoAprendizagem upload(MultipartFile file, ObjetoAprendizagem obj) throws Exception{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new Exception("Nome do arquivo inválido ou não existe: " + fileName);
			}
			
			return objetoAprendizagemRepository.save(obj);
		} catch(Exception e) {
			throw new Exception("Formato do arquivo inválido" + fileName);
		}
	}
	
	public List<ObjetoAprendizagem> obterTodos(){
		List<ObjetoAprendizagem> objs = objetoAprendizagemRepository.findAll();
		return objs;
	}
	
	public Optional<ObjetoAprendizagem> obterPorId(Long id){
		Optional<ObjetoAprendizagem> obj = objetoAprendizagemRepository.findById(id);
		
		if(obj.isEmpty()) {
			throw new ObjectnotFoundException("Objeto de aprendizagem com id " + id + "não existe!");
		}
		
		return obj;
	}
	
	public ObjetoAprendizagem atualizar(Long id, ObjetoAprendizagem objAtualizado) {
		Optional<ObjetoAprendizagem> objEncontrado = objetoAprendizagemRepository.findById(id);
		
		if(objEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("Objeto de aprendizagem com id " + id + "não existe!");
		}
		
		objAtualizado.setId(id);
		objAtualizado.setId(id);
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagem obj = mapper.map(objAtualizado, ObjetoAprendizagem.class);
		objetoAprendizagemRepository.save(obj);
		return objAtualizado;
	}
	
	public Boolean deletar(long id) {
		Optional<ObjetoAprendizagem> objEncontrado = objetoAprendizagemRepository.findById(id);
		
		if(objEncontrado.isEmpty()) {
			return false;
		}
		objetoAprendizagemRepository.deleteById(id);
		return true;
	}
	
}
