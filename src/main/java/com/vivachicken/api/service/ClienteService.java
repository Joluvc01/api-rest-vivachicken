package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Cliente;

public interface ClienteService {
	public List<Cliente> findAll();
	public Optional<Cliente> findById(Integer id);
	public List<Cliente> findByEmail(String email);
	public Cliente save(Cliente cliente);
	public void update(Cliente cliente);
	public void deleteById(Integer id);
}
