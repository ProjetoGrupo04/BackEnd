package com.senac.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.api.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);
	
    @Query(value = "SELECT user_email FROM usuario", nativeQuery = true)
    Optional<Usuario> find(String email);
    
}
