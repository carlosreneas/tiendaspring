package com.example.demo.controller;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> getCategoriaAll() {

		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Categoria getProductosbyId(@PathVariable Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if (categoria.isPresent()) {
			return categoria.get();
		}
		
		return null;

	}
	
	@PostMapping
	public Categoria postCategorias(@RequestBody Categoria categoria) {

		categoriaRepository.save(categoria);
		
		return categoria;
	}
	
	
	@PutMapping("/{id}")
	public Categoria putCategoriasbyId(@PathVariable Integer id, @RequestBody Categoria categoria) {
		
		Optional<Categoria> categoriaCurrent = categoriaRepository.findById(id);
		
		if (categoriaCurrent.isPresent()) {
			
			Categoria categoriaReturn = categoriaCurrent.get();

			categoriaReturn.setDescripcion(categoria.getDescripcion());

			categoriaRepository.save(categoriaReturn);
			
			return categoriaReturn;
		}
		
		return null;

	}
	
	@DeleteMapping("/{id}")
	public Categoria deleteCategoriasbyId(@PathVariable Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if (categoria.isPresent()) {
			
			Categoria categoriaReturn = categoria.get();

			categoriaRepository.deleteById(id);
			
			return categoriaReturn;
		}
		
		return null;
	}
}
