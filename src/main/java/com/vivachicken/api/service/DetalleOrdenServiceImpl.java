package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivachicken.api.model.DetalleOrden;
import com.vivachicken.api.model.Orden;
import com.vivachicken.api.repository.DetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{

	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public List<DetalleOrden> findAll() {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.findAll();
	}

	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.save(detalleOrden);
	}

	@Override
	public void update(DetalleOrden detalleOrden) {
		// TODO Auto-generated method stub
		detalleOrdenRepository.save(detalleOrden);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		detalleOrdenRepository.deleteById(id);
	}

	@Override
	public Optional<DetalleOrden> findById(Integer id) {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.findById(id);
	}

	@Override
	public List<DetalleOrden> findByOrden(Orden orden) {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.findByOrden(orden);
	}

}
