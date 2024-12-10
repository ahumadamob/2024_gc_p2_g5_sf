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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo5.dto.RespuestaDTO;
import gc._4.pr2.grupo5.entity.MetodosDePago;
import gc._4.pr2.grupo5.service.MetodosDePagoService;

@RestController
@RequestMapping("/metodosdepago")
public class MetodosDePagoController {
	@Autowired
	private  MetodosDePagoService metodosdepagoService;
	
	//Crear un nuevo elemento de pago
	@PostMapping
	public RespuestaDTO<MetodosDePago> crearMetodosDePago(@RequestBody MetodosDePago metodosdepago) {
		if(metodosdepagoService.existe(metodosdepago.getId())) {
			return new RespuestaDTO<MetodosDePago>(false, "Este ID ya existe", null);
		}else {
			return new RespuestaDTO<MetodosDePago>(true, "Metodo de pago creado con exito", metodosdepagoService.guardarMetodosDePago(metodosdepago));	
		}
	}

	//Buscar todos los elementos de pago
	@GetMapping
	public RespuestaDTO <List<MetodosDePago>> obtenerTodosLosMetodosDePago() {
		List<MetodosDePago> listaMetodosDePago;
		listaMetodosDePago = new ArrayList<MetodosDePago>();
		listaMetodosDePago = metodosdepagoService.obtenerTodosLosMetodosDePago();
		
		RespuestaDTO <List<MetodosDePago>> dto;
		dto = new RespuestaDTO<List<MetodosDePago>>();
		
		if (listaMetodosDePago.isEmpty()){
            dto.setEstado(false);
            List<String> mensajes = new ArrayList<>();
            mensajes.add("No hay metodos de pago");
            dto.setData(null);
        } else {
            List<String> mensajes = new ArrayList<>();
            mensajes.add("Salio todo bien");
            mensajes.add("Se encontraron los siguentes metodos de pago:");
            dto.setEstado(true);
            dto.setMensaje(mensajes);
            dto.setData(listaMetodosDePago);
        }
        return dto;
	}
	
	//Buscar por ID
	@GetMapping("/{id}")
	public RespuestaDTO<MetodosDePago> obtenerMetodosDePagoPorId(@PathVariable ("id") Long id) {
		if(metodosdepagoService.existe(id)) {
			MetodosDePago metodosdepago = new MetodosDePago();
			metodosdepago = metodosdepagoService.obtenerMetodosDePagoPorId(id);
			RespuestaDTO<MetodosDePago> dto;
			dto = new RespuestaDTO<MetodosDePago>(true, "Se encontraron los siguentes metodos de pago:", metodosdepago);
			return dto;
		}else {
			return new RespuestaDTO<MetodosDePago>(false, "No existe ningun metodo de pago con el id", null);
		}
	}
	
	//Actualizar un elemento de pago existente
	@PutMapping
	public RespuestaDTO<MetodosDePago> guardarMetodosDePago(@RequestBody MetodosDePago metodosdepago) {
		if(metodosdepagoService.existe(metodosdepago.getId())) {
			return new RespuestaDTO<MetodosDePago>(true, "Metodo de pago actualizado con exito", metodosdepagoService.guardarMetodosDePago(metodosdepago));
		}else {
			return new RespuestaDTO<MetodosDePago>(false, "No se encontro el ID:" + metodosdepago.getId().toString(), null);
		}
	}
	
	//Eliminar un elemento de pago 
	@DeleteMapping("/{id}")
	public RespuestaDTO<?> eliminarMetodosDePago(@PathVariable("id") Long id) {
		if(metodosdepagoService.existe(id)) {
			metodosdepagoService.eliminarMetodosDePago(id);
			return new RespuestaDTO<>(true, "Se elimino el metodo de pago por el ID: " + id.toString(), null);
		}else {
			return new RespuestaDTO<>(false, "No se elimino el metodo de pago con el ID: " + id.toString(), null);
		}
	}
	
	@PostMapping("/{metodosdepago}")
	public RespuestaDTO<?> crearMetodosDePago1(@RequestBody MetodosDePago metodosdepago) {
		if (metodosdepago.getLimiteMonto() <1000.00) {
		return new RespuestaDTO<MetodosDePago>(false, "El límite de monto debe ser mayor o igual a 1000.00", metodosdepago);
		} else {
			return new RespuestaDTO<MetodosDePago>(true, "Metodo de pago creado con exito", metodosdepagoService.guardarMetodosDePago(metodosdepago));
		}
	}
}