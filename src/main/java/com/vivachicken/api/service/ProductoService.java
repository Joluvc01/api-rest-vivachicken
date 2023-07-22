package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;


import com.vivachicken.api.model.Categoria;
import com.vivachicken.api.model.Producto;


public interface ProductoService {
	public List<Producto> findAll();
	public Optional<Producto>findById(Integer id);
	public List<Producto> findByCategoria(Categoria categoria);
	public Producto save(Producto producto);
	public void update(Producto producto);
	public void deleteById(Integer id);
}
