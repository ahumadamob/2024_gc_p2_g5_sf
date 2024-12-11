package gc._4.pr2.grupo5.service;

import java.util.List;


import gc._4.pr2.grupo5.entity.CarritoCompras;

public interface ICarritoComprasService {
	
	CarritoCompras guardarCarritoCompras(CarritoCompras producto);
    List<CarritoCompras> obtenerTodosLosCarritoCompras();
    CarritoCompras obtenerCarritoComprasPorId(Long id);
    void eliminarCarritoCompras(Long id);
    public boolean existe(Long id);
    /*public boolean estado(Long id);*/
}