package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

}
