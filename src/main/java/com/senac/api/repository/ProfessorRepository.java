package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
