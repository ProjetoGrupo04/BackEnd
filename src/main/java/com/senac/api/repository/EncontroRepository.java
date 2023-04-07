package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Encontro;

@Repository
public interface EncontroRepository extends JpaRepository<Encontro, Long>{

}
