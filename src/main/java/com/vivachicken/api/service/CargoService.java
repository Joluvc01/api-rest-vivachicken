package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Cargo;

public interface CargoService {
	public List<Cargo> findAll();
	public Optional<Cargo> findById(Integer id);
	public Cargo save(Cargo cargo);
	public void update(Cargo cargo);
	public void deleteById(Integer id);
}
