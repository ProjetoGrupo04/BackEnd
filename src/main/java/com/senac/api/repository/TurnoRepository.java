package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{

}
