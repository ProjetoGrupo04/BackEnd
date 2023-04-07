package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Bibliografia;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Long>{

}
