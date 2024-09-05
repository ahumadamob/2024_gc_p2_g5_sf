package gc._4.pr2.grupo5.service;

import java.util.List;
import java.util.Optional;

import gc._4.pr2.grupo5.entity.CarritoCompras;

public interface CarritoComprasService {
	CarritoCompras guardarCarritoCompras(CarritoCompras carritocompras);
    List<CarritoCompras> obtenerTodosLosCarritoCompras();
    Optional<CarritoCompras> obtenerCarritoComprasPorId(Long id);
    void eliminarCarritoCompras(Long id);
}