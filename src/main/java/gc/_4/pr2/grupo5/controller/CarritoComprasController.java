package gc._4.pr2.grupo5.controller;

import dto.RespuestaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.service.ICarritoComprasService;


import java.util.ArrayList;
import java.util.List;


@RestController

public class CarritoComprasController {
    @Autowired
    private ICarritoComprasService carritocomprasService;
    
  //Buscar todos los carrito de compras
  	@GetMapping("/carrito")
  	public RespuestaDTO <List<CarritoCompras>> obtenerTodosLosCarritoCompras(){
  		List<CarritoCompras> listaCarritoCompras;
  		listaCarritoCompras = new ArrayList<>();
  		listaCarritoCompras = carritocomprasService.obtenerTodosLosCarritoCompras();
  		
  		RespuestaDTO<List<CarritoCompras>> dto;
  		dto = new RespuestaDTO<List<CarritoCompras>>();		
  		
  		if(listaCarritoCompras.isEmpty()) {
  			dto.setEstado(false);
  			List<String> mensajes = new ArrayList<>();
  			mensajes.add("No existen Carritos de compras");
  			dto.setData(null);
  		}else {
  			List<String> mensajes = new ArrayList<>();
  			mensajes.add("Se encontraron los siguientes Carritos de compras: ");
  			mensajes.add("Todo salio bien");
  			dto.setEstado(true);
  			dto.setMensaje(mensajes);
  			dto.setData(listaCarritoCompras);
  		}		
  		return dto;
  		
  	}

  	//Buscar por ID
    @GetMapping("/carrito/{id}")
    public RespuestaDTO<CarritoCompras> obtenerCarritoComprasPorId(@PathVariable("id") Long id){
		if(carritocomprasService.existe(id)) {
			CarritoCompras carritocompras = new CarritoCompras();
			carritocompras = carritocomprasService.obtenerCarritoComprasPorId(id);
			RespuestaDTO<CarritoCompras> dto;
			dto = new RespuestaDTO<CarritoCompras>(true, "Se encontro el siguiente carrito de compras: ", carritocompras);
			return dto;
		}else {			
			return new RespuestaDTO<CarritoCompras>(false, "No existen un carrito de compras con el id ", null);
		}
    }
    
    // Intancia de un objeto, se crea un objeto de tipo CarritoCompras
    //Se crea un nuevo carrito de compras
    @PostMapping("/carrito")								//Se usa RequestBody para inicializar el objeto automaticamente
    public RespuestaDTO<CarritoCompras> crearCarritoCompras(@RequestBody CarritoCompras carritocompras){
		if(carritocomprasService.existe(carritocompras.getId())) {
			return new RespuestaDTO<CarritoCompras>(false, "El ID ingresado ya existe", null);
		}else {
			return new RespuestaDTO<CarritoCompras>(true, "Carrito de compras creado con exito", carritocomprasService.guardarCarritoCompras(carritocompras));
		}
		
	}

    //Update de un carrito
    @PutMapping("/carrito")
    public RespuestaDTO<CarritoCompras> actualizarCarritoCompras(@RequestBody CarritoCompras carritocompras){
		if(carritocomprasService.existe(carritocompras.getId())) {
			return new RespuestaDTO<CarritoCompras>(true, "Se actualizó la compra del carrito con exito", carritocomprasService.guardarCarritoCompras(carritocompras));
		}else {
			return new RespuestaDTO<CarritoCompras>(false, "No se encontró el ID del carrito " + carritocompras.getId().toString(), null);
		}		
	}
  //Eliminar un carrito
    @DeleteMapping("/carrito/{id}")
    public RespuestaDTO<?> eliminarCarritoCompras(@PathVariable("id") Long id){
		if(carritocomprasService.existe(id)) {
			carritocomprasService.eliminarCarritoCompras(id);
			return new RespuestaDTO<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDTO<>(false, "No se encontró el ID " + id.toString(), null);
		}
		
	}
     
    @PostMapping("/carrito/crear") 
    public RespuestaDTO<CarritoCompras> verificarCarritoCompras(@RequestBody CarritoCompras carritocompras){
		if(carritocompras.isEstado()) {
			return new RespuestaDTO<CarritoCompras>(true, "Carrito de compras creado con éxito", carritocomprasService.guardarCarritoCompras(carritocompras));
		}else {
			return new RespuestaDTO<CarritoCompras>(false, "El carrito está cerrado y no se pueden agregar productos", null);
		}
		
	}
}