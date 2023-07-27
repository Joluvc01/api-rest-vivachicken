package com.vivachicken.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivachicken.api.model.Cargo;
import com.vivachicken.api.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    // Endpoint para obtener todos los cargos
    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.findAll();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }

    // Endpoint para obtener un cargo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Integer id) {
        Optional<Cargo> cargo = cargoService.findById(id);
        if (cargo.isPresent()) {
            return new ResponseEntity<>(cargo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo cargo
    @PostMapping("/create")
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo nuevoCargo = cargoService.save(cargo);
        return new ResponseEntity<>(nuevoCargo, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un cargo existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCargo(@PathVariable Integer id, @RequestBody Cargo cargo) {
        Optional<Cargo> cargoExistente = cargoService.findById(id);
        if (cargoExistente.isPresent()) {
            cargo.setId(id);
            cargoService.update(cargo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un cargo por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer id) {
        Optional<Cargo> cargo = cargoService.findById(id);
        if (cargo.isPresent()) {
            cargoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

