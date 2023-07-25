package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.DetalleOrden;
import com.vivachicken.api.model.Orden;

public interface DetalleOrdenService {
	public List<DetalleOrden> findAll();
	public Optional<DetalleOrden> findById(Integer id);
	public List<DetalleOrden> findByOrden(Orden orden);
	public DetalleOrden save(DetalleOrden detalleOrden);
	public void update(DetalleOrden detalleOrden);
	public void deleteById(Integer id);
}
