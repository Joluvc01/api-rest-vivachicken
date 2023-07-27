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

import com.vivachicken.api.model.Local;
import com.vivachicken.api.service.LocalService;

@RestController
@RequestMapping("/locales")
public class LocalController {

    @Autowired
    private LocalService localService;

    // Endpoint para obtener todos los locales
    @GetMapping
    public ResponseEntity<List<Local>> getAllLocales() {
        List<Local> locales = localService.findAll();
        return ResponseEntity.ok(locales);
    }

    // Endpoint para obtener un local por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable Integer id) {
        Optional<Local> local = localService.findById(id);
        if (local.isPresent()) {
            return ResponseEntity.ok(local.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear un nuevo local
    @PostMapping("/create")
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        Local savedLocal = localService.save(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocal);
    }

    // Endpoint para actualizar un local existente por su ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateLocal(@PathVariable Integer id, @RequestBody Local local) {
        Optional<Local> existingLocal = localService.findById(id);
        if (existingLocal.isPresent()) {
            local.setId(id);
            localService.update(local);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un local por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Integer id) {
        Optional<Local> existingLocal = localService.findById(id);
        if (existingLocal.isPresent()) {
            localService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

