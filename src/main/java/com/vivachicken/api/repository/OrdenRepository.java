package com.vivachicken.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
	List<Orden> findByCliente(Cliente cliente);
	List<Orden> findByFecha(Date fecha);

}
