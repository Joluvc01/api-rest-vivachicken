package com.vivachicken.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.Orden;
import com.vivachicken.api.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	@Override
	public Optional<Orden> findById(Integer id) {
		// TODO Auto-generated method stub
		return ordenRepository.findById(id);
	}

	@Override
	public List<Orden> findByCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return ordenRepository.findByCliente(cliente);
	}

	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return ordenRepository.save(orden);
	}

	@Override
	public void update(Orden orden) {
		// TODO Auto-generated method stub
		ordenRepository.save(orden);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		ordenRepository.deleteById(id);
	}

	@Override
	public List<Orden> findBeforeDate(Date fecha) {
		// TODO Auto-generated method stub
		return ordenRepository.findBeforeDate(fecha);
	}

}
