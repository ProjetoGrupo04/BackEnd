package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.EncontroTipo;

@Repository
public interface EncontroTipoRepository extends JpaRepository<EncontroTipo, Long>{

}
