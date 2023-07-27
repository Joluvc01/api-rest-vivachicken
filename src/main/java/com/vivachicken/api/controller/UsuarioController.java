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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivachicken.api.model.Cargo;
import com.vivachicken.api.model.Usuario;
import com.vivachicken.api.service.CargoService;
import com.vivachicken.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private CargoService cargoService;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obtener usuarios por cargo
    @GetMapping("/usuarioxcargo/{cargoId}")
    public ResponseEntity<List<Usuario>> getUsuariosByCargo(@PathVariable Integer cargoId) {
        Optional<Cargo> cargo = cargoService.findById(cargoId);
        if (cargo.isPresent()) {
            List<Usuario> usuarios = usuarioService.findByCargo(cargo.get());
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 // Endpoint para autenticar un usuario por su nombre de usuario y contraseña
    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se requieren los campos 'username' y 'password'");
        }
        // Buscar al usuario por su email (nombre de usuario)
        Optional<Usuario> usuarioEncontrado = usuarioService.findByUsername(usuario.getUsername());

        if (!usuarioEncontrado.isPresent()) {
        	System.out.println("Usuario no encontrado.");
            return ResponseEntity.notFound().build();
        }

        // Comparar las contraseñas
        if (!usuarioEncontrado.get().getPassword().equals(usuario.getPassword())) {
        	System.out.println("Contraseña incorrecta para el usuario: " + usuario.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // Autenticación exitosa, devolver el usuario autenticado
        System.out.println("Usuario autenticado correctamente: " + usuario.getUsername());
        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping("/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.findById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            usuarioService.update(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

