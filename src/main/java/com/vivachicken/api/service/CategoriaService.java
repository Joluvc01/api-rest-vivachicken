package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Categoria;

public interface CategoriaService {
	public List<Categoria> findAll();
	public Optional<Categoria>findById(Integer id);
	public Categoria save(Categoria categoria);
	public void update(Categoria categoria);
	public void deleteById(Integer id);
}
