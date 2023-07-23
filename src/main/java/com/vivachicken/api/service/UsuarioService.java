package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Cargo;
import com.vivachicken.api.model.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Optional<Usuario> findById(Integer id);
	public List<Usuario> findByCargo(Cargo cargo);
	public Optional<Usuario> findByUsername(String username);
	public Usuario save(Usuario usuario);
	public void update(Usuario usuario);
	public void deleteById(Integer id);
}
