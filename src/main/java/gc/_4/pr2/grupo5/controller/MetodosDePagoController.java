package gc._4.pr2.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo5.entity.MetodosDePago;
import gc._4.pr2.grupo5.service.MetodosDePagoService;

@RestController
@RequestMapping("/MetodosDePago")
public class MetodosDePagoController {
	@Autowired
	private  MetodosDePagoService metodosdepagoService;
	
	@PostMapping
	public MetodosDePago crearMetodosDePago(@RequestBody MetodosDePago metodosdepago) {
		return metodosdepagoService.guardarMetodosDePago(metodosdepago);
	}

	@GetMapping
	public List<MetodosDePago> listarMetodosDePago() {
		return metodosdepagoService.obtenerTodosLosMetodosDePago();
	}
	@GetMapping("/{id}")
	public MetodosDePago obtenerMetodosDePagoPorId(@PathVariable Long id) {
		return metodosdepagoService.obtenerMetodosDePagoPorId(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public MetodosDePago actualizarMetodosDePago(@PathVariable Long id, @RequestBody MetodosDePago metodosdepago) {
	return metodosdepagoService.actualizarMetodosDePago(id, metodosdepago);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarMetodosDePago(@PathVariable Long id) {
		metodosdepagoService.eliminarMetodosDePago(id);
	}
	
}