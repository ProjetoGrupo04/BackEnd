package com.senac.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long>{

	@Query(value = "SELECT * FROM badge WHERE badge_nivel_id = :id", nativeQuery = true)
	List<Badge> findByNivel(Long id); 

	Optional<Badge> findByBadgeNivelId(Long id);
}


