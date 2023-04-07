package com.senac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long>{

}
