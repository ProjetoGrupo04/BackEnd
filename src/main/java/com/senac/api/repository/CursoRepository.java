package com.senac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	@Query(value = "select * from curso where curso_status = 0", nativeQuery = true)
	List<Curso> findByCursosAtivos();
	
	
}
