package com.vivachicken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Categoria;
import com.vivachicken.api.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findByCategoria(Categoria categoria);
}
