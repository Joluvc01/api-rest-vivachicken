package com.vivachicken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivachicken.api.model.DetalleOrden;
import com.vivachicken.api.model.Orden;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer>{
	List<DetalleOrden> findByOrden(Orden orden);
}
