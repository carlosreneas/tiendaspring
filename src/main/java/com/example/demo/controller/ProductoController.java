package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Producto;
import com.example.demo.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping
	public List<Producto> getProductoAll() {

		return productoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Producto getProductosbyId(@PathVariable Integer id) {
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		if (producto.isPresent()) {
			return producto.get();
		}
		
		return null;

	}
	
}
