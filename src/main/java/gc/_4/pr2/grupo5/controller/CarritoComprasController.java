package gc._4.pr2.grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.service.CarritoComprasService;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CarritoComprasController {
    @Autowired
    private CarritoComprasService carritocomprasService;

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
        return carritocomprasService.obtenerCarritoComprasPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarritoCompras(@PathVariable Long id) {
        carritocomprasService.eliminarCarritoCompras(id);
    }
}