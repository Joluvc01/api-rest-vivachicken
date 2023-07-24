package com.vivachicken.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
	List<Orden> findByCliente(Cliente cliente);
	@Query("SELECT o FROM Orden o WHERE o.fecha < :fecha")
    List<Orden> findBeforeDate(@Param("fecha") Date fecha);
}


