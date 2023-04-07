package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.DiaLetivo;

@Repository
public interface DiaLetivoRepository extends JpaRepository<DiaLetivo, Long>{

}
