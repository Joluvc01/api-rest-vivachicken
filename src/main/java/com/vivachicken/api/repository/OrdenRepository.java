package com.vivachicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{

}
