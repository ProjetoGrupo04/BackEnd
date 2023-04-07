package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.ObjetoAprendizagem;

@Repository
public interface ObjetoAprendizagemRepository extends JpaRepository<ObjetoAprendizagem, Long>{

}
