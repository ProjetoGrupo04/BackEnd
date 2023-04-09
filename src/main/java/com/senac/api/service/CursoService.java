package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.Curso;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso adicionar(Curso curso) {
		curso.setId(null);
		curso.setStatus(true);
		curso = cursoRepository.save(curso);
		curso.setId(curso.getId());
		return curso;
	}
	
	public List<Curso> obterTodos(){
		List<Curso> cursos = cursoRepository.findAll();
		return cursos;
	}
	
	public Optional<Curso> obterPorId(Long id){
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return curso;
	}
	
	public Curso atualizar(Long id, Curso curso) {
		Optional<Curso> cursoId = cursoRepository.findById(id);
		
		if(cursoId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		curso.setId(id);
		curso.setId(id);
		cursoRepository.save(curso);
		return curso;
	}
	
	
	public void deletar(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		cursoRepository.deleteById(id);
	}
	
	public List<Curso> findByCursosAtivos(){
		return cursoRepository.findByCursosAtivos();
	}
}
