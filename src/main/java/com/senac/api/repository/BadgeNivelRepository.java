package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.BadgeNivel;

@Repository
public interface BadgeNivelRepository extends JpaRepository<BadgeNivel, Long>{

}
