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

import com.vivachicken.api.model.Cliente;
import com.vivachicken.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 // Endpoint para autenticar un usuario por su email y contraseña
    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody Cliente cliente) {
        if (cliente.getEmail() == null || cliente.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se requieren los campos 'email' y 'password'");
        }
        // Buscar al usuario por su email
        Optional<Cliente> clienteEncontrado = clienteService.findByEmail(cliente.getEmail());

        if (!clienteEncontrado.isPresent()) {
            System.out.println("Cliente no encontrado.");
            return ResponseEntity.notFound().build();
        }

        // Comparar las contraseñas
        if (!clienteEncontrado.get().getPassword().equals(cliente.getPassword())) {
            System.out.println("Contraseña incorrecta para el cliente: " + cliente.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // Autenticación exitosa, devolver el ID del cliente autenticado
        Integer idCliente = clienteEncontrado.get().getId();
        System.out.println("Cliente autenticado correctamente: " + cliente.getEmail() + ", ID: " + idCliente);
        
        // Devolver solo el ID como respuesta
        return ResponseEntity.ok(idCliente);
    }


    @PostMapping("/create")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            cliente.setId(id); // Ensure the ID is set in the entity before updating
            clienteService.update(cliente);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

