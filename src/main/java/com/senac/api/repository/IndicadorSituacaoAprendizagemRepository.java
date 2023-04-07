package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.IndicadorSituacaoAprendizagem;

@Repository
public interface IndicadorSituacaoAprendizagemRepository extends JpaRepository<IndicadorSituacaoAprendizagem, Long>{

}
