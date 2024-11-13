package gc._4.pr2.grupo5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import dto.RespuestaDTO;
import gc._4.pr2.grupo5.entity.Inventario;
import gc._4.pr2.grupo5.service.InventarioService;

@RestController
public class InventarioController {
	
	@Autowired
	private InventarioService inventarioService;
	
	//Buscar todos los elementos:
		@GetMapping("/inventario")
		public RespuestaDTO<List<Inventario>> obtenerTodosLosInventarios() {
			List<Inventario> listaInventario;
			listaInventario = new ArrayList<Inventario>();
			listaInventario = inventarioService.obtenerTodosLosInventarios();
			
			RespuestaDTO<List<Inventario>> dto;
			 dto = new RespuestaDTO<List<Inventario>>();
			
			if(listaInventario.isEmpty()) {
				dto.setEstado(false);
				List<String> mensajes = new ArrayList<>();
				mensajes.add("No se encontraron Inventarios");
				dto.setData(null);
			} else {
				List<String> mensajes = new ArrayList<>();
				mensajes.add("Salió todo bien");
				mensajes.add("Se encontraron los siguientes inventarios: ");
				dto.setEstado(true);
				dto.setMensaje(mensajes);
				dto.setData(listaInventario);
			}
			return dto;
		}

		//Buscar inventario por ID:
		@GetMapping("/inventario/{id}")
		public RespuestaDTO<Inventario> obtenerInventarioPorId(@PathVariable("id") Long id) {
			if(inventarioService.existe(id)) {
				//Instancia del objeto inventario:
				Inventario inventario = new Inventario();
				
				inventario = inventarioService.obtenerInventarioPorId(id);
				//Inicialización del objeto inventario:
				RespuestaDTO<Inventario> dto;
				dto = new RespuestaDTO<Inventario>(true, "se encontró el siguiente inventario: ", inventario);
				return dto;
				
			} else {
				return new RespuestaDTO<Inventario>(false, "No existe inventario con el ID: " + id, null);
			}
		}
	
	// Crear un nuevo inventario:
	@PostMapping("/inventario")
	public RespuestaDTO<Inventario> crearInventario(@RequestBody Inventario inventario) {
		
		if (inventarioService.existe(inventario.getId())) {
			return new RespuestaDTO<Inventario>(false, "El inventario con este ID ya existe", null);
		
			} else {
				return new RespuestaDTO<Inventario>(true, "Inventario creado con exito", inventarioService.guardarInventario(inventario));
			}
		}
	
	
	
	//Actualizar un inventario existente:
	@PutMapping("/inventario")
	public RespuestaDTO<Inventario> guardarInventario(@RequestBody Inventario inventario) {
		if(inventarioService.existe(inventario.getId())) {
			return new RespuestaDTO<Inventario>(true, "Inventario actualizado con exito", inventarioService.guardarInventario(inventario));
		} else {
			return new RespuestaDTO<Inventario>(false, "No se encontró inventario con el ID: " + inventario.getId().toString(), null);
		}
	}
	
	//Eliminar un inventario:
	@DeleteMapping("/inventario/{id}")
	public RespuestaDTO<?> eliminarInventario(@PathVariable ("id") Long id) {
		if(inventarioService.existe(id)) {
			inventarioService.eliminarInventario(id);
			return new RespuestaDTO<>(true, "Inventario eliminado por el ID: " + id.toString(), null);
		} else {
			return new RespuestaDTO<>(false, "No se encontró inventario con el ID: " + id.toString(), null);
		}
	}

}