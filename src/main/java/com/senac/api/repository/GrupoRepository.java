package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

}
