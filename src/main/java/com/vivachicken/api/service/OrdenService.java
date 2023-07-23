package com.vivachicken.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.Orden;

public interface OrdenService {
	public List<Orden> findAll();
	public Optional<Orden> findById(Integer id);
	public List<Orden> findByCliente(Cliente cliente);
	public List<Orden> findByDate(Date fecha);
	public Orden save(Orden orden);
	public void update (Orden orden);
	public void deleteById(Integer id);
}
