package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Professor;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public Professor adicionar(Professor professor) {
		professor.setId(null);
		professor.setStatus(true);
		professor = professorRepository.save(professor);
		professor.setId(professor.getId());
		return professor;
	}
	
	public List<Professor> obterTodos(){
		List<Professor> professores = professorRepository.findAll();
		return professores;
	}
	
	public Optional<Professor> obterPorId(Long id){
		Optional<Professor> professor = professorRepository.findById(id);
		
		if(professor.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		return professor;
	}
	
	public void deletar(Long id) {
		Optional<Professor> professor = professorRepository.findById(id);

		if(professor.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}		
		
		professorRepository.deleteById(id);
	}
	
	public Professor atualizar(Long id, Professor professor) {
		Optional<Professor> professorId = professorRepository.findById(id);
		
		if(professorId.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		professor.setId(id);
		professor.setId(id);
		professorRepository.save(professor);
		return professor;
	}
	
}
