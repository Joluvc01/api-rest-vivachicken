package com.vivachicken.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.model.Orden;
import com.vivachicken.api.service.ClienteService;
import com.vivachicken.api.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Integer id) {
        Optional<Orden> ordenOptional = ordenService.findById(id);
        if (ordenOptional.isPresent()) {
            return ResponseEntity.ok(ordenOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ordenxcliente/{clienteId}")
    public List<Orden> getOrdenesByCliente(@PathVariable Integer clienteId) {
        Optional<Cliente> clienteOptional = clienteService.findById(clienteId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return ordenService.findByCliente(cliente);
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/fecha")
    public List<Orden> getOrdenesByFecha(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        return ordenService.findBeforeDate(fecha);
    }

    @PostMapping("/create")
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        Orden createdOrden = ordenService.save(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrden);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateOrden(@PathVariable Integer id, @RequestBody Orden orden) {
        Optional<Orden> ordenOptional = ordenService.findById(id);
        if (ordenOptional.isPresent()) {
            orden.setId(id); // Ensure the ID is set in the entity before updating
            ordenService.update(orden);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Integer id) {
        Optional<Orden> ordenOptional = ordenService.findById(id);
        if (ordenOptional.isPresent()) {
            ordenService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
