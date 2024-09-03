package gc._4.pr2.grupo5.service;

import java.util.List;
import java.util.Optional;

import gc._4.pr2.grupo5.entity.MetodosDePago;

public interface MetodosDePagoService {
	MetodosDePago guardarMetodosDePago(MetodosDePago metodosdepago);
	List<MetodosDePago> obtenerTodosLosMetodosDePago();
	Optional<MetodosDePago> obtenerMetodosDePagoPorId(Long id);
	void eliminarMetodosDePago(Long id);
}
