package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.DetalleOrden;

public interface DetalleOrdenService {
	public List<DetalleOrden> findAll();
	public Optional<DetalleOrden> findById(Integer id);
	public DetalleOrden save(DetalleOrden detalleOrden);
	public void update(DetalleOrden detalleOrden);
	public void deleteById(Integer id);
}
