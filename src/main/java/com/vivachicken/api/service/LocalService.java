package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import com.vivachicken.api.model.Local;

public interface LocalService {
	public List<Local> findAll();
	public Optional<Local> findById(Integer id);
	public Local save(Local local);
	public void update(Local local);
	public void deleteById(Integer id);
	
}
