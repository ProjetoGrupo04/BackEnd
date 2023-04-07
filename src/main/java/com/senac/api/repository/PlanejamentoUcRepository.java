package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.PlanejamentoUc;

@Repository
public interface PlanejamentoUcRepository extends JpaRepository<PlanejamentoUc, Long>{

}
