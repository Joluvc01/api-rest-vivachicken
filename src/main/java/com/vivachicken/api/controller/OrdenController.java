package com.vivachicken.api.controller;

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
	public ResponseEntity<List<Orden>> obtenerTodasLasOrdenes() {
		List<Orden> listaOrdenes = ordenService.findAll();
		return new ResponseEntity<>(listaOrdenes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orden> obtenerOrdenPorId(@PathVariable Integer id) {
		Optional<Orden> orden = ordenService.findById(id);
		if (orden.isPresent()) {
			return new ResponseEntity<>(orden.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ordenesxcliente/{clienteId}")
	public ResponseEntity<List<Orden>> getOrdenesByCliente(@PathVariable Integer clienteId) {
	    // Primero, obtenemos el cliente por su ID
	    Optional<Cliente> cliente = clienteService.findById(clienteId);

	    if (cliente.isPresent()) {
	        // Si el cliente existe, buscamos las órdenes asociadas a él
	        List<Orden> ordenesPorCliente = ordenService.findByCliente(cliente.get());
	        return new ResponseEntity<>(ordenesPorCliente, HttpStatus.OK);
	    } else {
	        // Si el cliente no existe, devolvemos un error 404
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping("/create")
	public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
		Orden ordenCreada = ordenService.save(orden);
		return new ResponseEntity<>(ordenCreada, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> actualizarOrden(@PathVariable Integer id, @RequestBody Orden orden) {
		Optional<Orden> ordenExistente = ordenService.findById(id);
		if (ordenExistente.isPresent()) {
			orden.setId(id);
			ordenService.update(orden);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> eliminarOrden(@PathVariable Integer id) {
		Optional<Orden> orden = ordenService.findById(id);
		if (orden.isPresent()) {
			ordenService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



	@GetMapping("/antesDeFecha/{fecha}")
	public ResponseEntity<List<Orden>> obtenerOrdenesAntesDeFecha(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
		List<Orden> listaOrdenes = ordenService.findBeforeDate(fecha);
		return new ResponseEntity<>(listaOrdenes, HttpStatus.OK);
	}
}
