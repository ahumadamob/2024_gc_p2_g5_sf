package gc._4.pr2.grupo5.service;

import java.util.List;
import java.util.Optional;

import gc._4.pr2.grupo5.entity.Inventario;

public interface InventarioService {
	Inventario guardarInventario(Inventario inventario);
	List<Inventario> obtenerTodosLosInventarios();
	Optional<Inventario> obtenerInventarioPorId(Long id);
	void eliminarInventario(Long id);

}
