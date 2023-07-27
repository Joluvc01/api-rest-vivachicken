package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivachicken.api.model.Cargo;
import com.vivachicken.api.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	public List<Cargo> findAll() {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}

	@Override
	public Optional<Cargo> findById(Integer id) {
		// TODO Auto-generated method stub
		return cargoRepository.findById(id);
	}

	@Override
	public Cargo save(Cargo cargo) {
		// TODO Auto-generated method stub
		return cargoRepository.save(cargo);
	}

	@Override
	public void update(Cargo cargo) {
		// TODO Auto-generated method stub
		cargoRepository.save(cargo);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		cargoRepository.deleteById(id);
	}

}
