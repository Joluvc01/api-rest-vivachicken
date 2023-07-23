package com.vivachicken.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Cargo;
import com.vivachicken.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByCargo(Cargo cargo);
	Optional<Usuario> findByUsername(String username);
}
