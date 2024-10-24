package gc._4.pr2.grupo5.service;

import java.util.List;
import gc._4.pr2.grupo5.entity.Inventario;

public interface InventarioService {
	Inventario guardarInventario(Inventario inventario);
	List<Inventario> obtenerTodosLosInventarios();
	Inventario obtenerInventarioPorId(Long id);
	Inventario actualizarInventario(Long id, Inventario inventario);
	void eliminarInventario(Long id);

}
