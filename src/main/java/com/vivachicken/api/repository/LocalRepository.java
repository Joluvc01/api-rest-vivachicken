package com.vivachicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivachicken.api.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer>{

}
