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

import com.vivachicken.api.model.DetalleOrden;
import com.vivachicken.api.service.DetalleOrdenService;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;


    // Endpoint para obtener todos los detalles de órdenes
    @GetMapping
    public List<DetalleOrden> getAllDetalleOrdenes() {
        return detalleOrdenService.findAll();
    }

    // Endpoint para obtener un detalle de orden por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrden> getDetalleOrdenById(@PathVariable Integer id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenService.findById(id);
        if (detalleOrden.isPresent()) {
            return ResponseEntity.ok(detalleOrden.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear un nuevo detalle de orden
    @PostMapping("/create")
    public ResponseEntity<DetalleOrden> createDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        DetalleOrden createdDetalleOrden = detalleOrdenService.save(detalleOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDetalleOrden);
    }

    // Endpoint para actualizar un detalle de orden existente
    @PutMapping("/update/{id}")
    public ResponseEntity<DetalleOrden> updateDetalleOrden(@PathVariable Integer id, @RequestBody DetalleOrden detalleOrden) {
        Optional<DetalleOrden> existingDetalleOrden = detalleOrdenService.findById(id);
        if (existingDetalleOrden.isPresent()) {
            detalleOrden.setId(id); // Asegurarse de establecer el ID correcto para actualizar el registro existente
            DetalleOrden updatedDetalleOrden = detalleOrdenService.save(detalleOrden);
            return ResponseEntity.ok(updatedDetalleOrden);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un detalle de orden por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDetalleOrden(@PathVariable Integer id) {
        detalleOrdenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}