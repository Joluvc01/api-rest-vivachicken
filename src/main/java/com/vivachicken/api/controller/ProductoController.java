package com.vivachicken.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vivachicken.api.model.Categoria;
import com.vivachicken.api.model.Producto;
import com.vivachicken.api.service.CategoriaService;
import com.vivachicken.api.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
    private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Producto>> getAllProductos() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductoById(@PathVariable Integer id) {
		return productoService.findById(id)
				.map(producto -> ResponseEntity.ok(producto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/productosxcat/{categoriaId}")
	public ResponseEntity<List<Producto>> getProductosByCategoria(@PathVariable Integer categoriaId) {
	    // Primero, obtenemos la categoría por su ID
	    Optional<Categoria> categoria = categoriaService.findById(categoriaId);

	    if (categoria.isPresent()) {
	        // Si la categoría existe, buscamos los productos asociados a ella
	        List<Producto> productosPorCategoria = productoService.findByCategoria(categoria.get());
	        return new ResponseEntity<>(productosPorCategoria, HttpStatus.OK);
	    } else {
	        // Si la categoría no existe, devolvemos un error 404
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	@PostMapping("/create")
	public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProducto(@PathVariable Integer id, @RequestBody Producto updatedProducto) {
		return productoService.findById(id)
				.map(producto -> {
					updatedProducto.setId(id);
					productoService.update(updatedProducto);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
		productoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
