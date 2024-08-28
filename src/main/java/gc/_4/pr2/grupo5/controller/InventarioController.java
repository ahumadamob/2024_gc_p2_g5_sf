package gc._4.pr2.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo5.entity.Inventario;
import gc._4.pr2.grupo5.service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
	@Autowired
	private InventarioService inventarioService;
	
	@PostMapping
	public Inventario crearInventario(@RequestBody Inventario
	inventario) {
	return inventarioService.guardarInventario(inventario);
	}
	@GetMapping
	public List<Inventario> listarInventarios() {
	return inventarioService.obtenerTodosLosInventarios();
	}
	@GetMapping("/{id}")
	public Inventario obtenerInventarioPorId(@PathVariable Long
	id) {
	return
	inventarioService.obtenerInventarioPorId(id).orElse(null);
	}
	@DeleteMapping("/{id}")
	public void eliminarInventario(@PathVariable Long id) {
	inventarioService.eliminarInventario(id);
	}

}
