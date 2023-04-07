package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.GrauDificuldade;

@Repository
public interface GrauDificuldadeRepository extends JpaRepository<GrauDificuldade, Long>{

}
