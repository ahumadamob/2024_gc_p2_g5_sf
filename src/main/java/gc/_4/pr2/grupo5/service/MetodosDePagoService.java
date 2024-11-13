package gc._4.pr2.grupo5.service;

import java.util.List;
import gc._4.pr2.grupo5.entity.MetodosDePago;

public interface MetodosDePagoService {
	MetodosDePago guardarMetodosDePago(MetodosDePago metodosdepago);
	List<MetodosDePago> obtenerTodosLosMetodosDePago();
	MetodosDePago obtenerMetodosDePagoPorId(Long id);
	MetodosDePago actualizarMetodosDePago (Long id, MetodosDePago metodosdepago);
	MetodosDePago crearMetodosDePago(MetodosDePago metodosdepago);
	public boolean existe(Long id);
	void eliminarMetodosDePago(Long id);
}