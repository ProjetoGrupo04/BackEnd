package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.CopetenciaIndicador;

@Repository
public interface CopetenciaIndicadorRepository extends JpaRepository<CopetenciaIndicador, Long>{
	
	
}
