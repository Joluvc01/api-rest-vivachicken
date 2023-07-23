package com.vivachicken.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivachicken.api.model.Local;
import com.vivachicken.api.repository.LocalRepository;

@Service
public class LocalServiceImpl implements LocalService{

	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public List<Local> findAll() {
		// TODO Auto-generated method stub
		return localRepository.findAll();
	}

	@Override
	public Optional<Local> findById(Integer id) {
		// TODO Auto-generated method stub
		return localRepository.findById(id);
	}

	@Override
	public Local save(Local local) {
		// TODO Auto-generated method stub
		return localRepository.save(local);
	}

	@Override
	public void update(Local local) {
		// TODO Auto-generated method stub
		localRepository.save(local);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		localRepository.deleteById(id);
	}

}
