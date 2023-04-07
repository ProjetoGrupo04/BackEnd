package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long>{
	
}
