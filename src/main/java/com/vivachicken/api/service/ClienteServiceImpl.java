package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Optional<Cliente> findByEmail(String email) {
		// TODO Auto-generated method stub
		return clienteRepository.findByEmail(email);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

}
