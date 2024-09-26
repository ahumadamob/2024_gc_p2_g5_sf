package gc._4.pr2.grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.service.ICarritoComprasService;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoComprasController {
    @Autowired
    private ICarritoComprasService carritocomprasService;

    @PostMapping
    public CarritoCompras crearCarritoCompras(@RequestBody CarritoCompras carritocompras) {
        return carritocomprasService.guardarCarritoCompras(carritocompras);
    }

    @GetMapping
    public List<CarritoCompras> listarCarritoCompras() {
        return carritocomprasService.obtenerTodosLosCarritoCompras();
    }

    @GetMapping("/{id}")
    public CarritoCompras obtenerCarritoComprasPorId(@PathVariable Long id) {
        return carritocomprasService.obtenerCarritoComprasPorId(id);
    }
    
    @PutMapping("/{id}")
	public CarritoCompras actualizarCarritoCompras(@PathVariable Long id,
	@RequestBody CarritoCompras carritocompras) {
    	CarritoCompras carritocomprasExistente = carritocomprasService.obtenerCarritoComprasPorId(id);
    	if (carritocomprasExistente != null) {
    		return carritocomprasService.guardarCarritoCompras(carritocomprasExistente);
    	} else {
    		return null;
    	}
	}

    @DeleteMapping("/{id}")
    public void eliminarCarritoCompras(@PathVariable Long id) {
        carritocomprasService.eliminarCarritoCompras(id);
    }
}