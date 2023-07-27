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
import com.vivachicken.api.model.Orden;
import com.vivachicken.api.service.DetalleOrdenService;
import com.vivachicken.api.service.OrdenService;


@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ResponseEntity<List<DetalleOrden>> obtenerTodosLosDetallesOrden() {
        List<DetalleOrden> listaDetallesOrden = detalleOrdenService.findAll();
        return new ResponseEntity<>(listaDetallesOrden, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrden> obtenerDetalleOrdenPorId(@PathVariable Integer id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenService.findById(id);
        if (detalleOrden.isPresent()) {
            return new ResponseEntity<>(detalleOrden.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DetalleOrden> crearDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        DetalleOrden detalleOrdenCreado = detalleOrdenService.save(detalleOrden);
        return new ResponseEntity<>(detalleOrdenCreado, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> actualizarDetalleOrden(@PathVariable Integer id, @RequestBody DetalleOrden detalleOrden) {
        Optional<DetalleOrden> detalleOrdenExistente = detalleOrdenService.findById(id);
        if (detalleOrdenExistente.isPresent()) {
            detalleOrden.setId(id);
            detalleOrdenService.update(detalleOrden);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarDetalleOrden(@PathVariable Integer id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenService.findById(id);
        if (detalleOrden.isPresent()) {
            detalleOrdenService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Agregar un método para obtener todos los detallesOrden por ID de Orden
    @GetMapping("/detallesPorOrden/{ordenId}")
    public ResponseEntity<List<DetalleOrden>> getDetallesPorOrden(@PathVariable Integer ordenId) {
        // Primero, obtenemos la orden por su ID
        Optional<Orden> orden = ordenService.findById(ordenId);

        if (orden.isPresent()) {
            // Si la orden existe, buscamos los detalles asociados a ella
            List<DetalleOrden> detallesPorOrden = detalleOrdenService.findByOrden(orden.get());
            return new ResponseEntity<>(detallesPorOrden, HttpStatus.OK);
        } else {
            // Si la orden no existe, devolvemos un error 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
