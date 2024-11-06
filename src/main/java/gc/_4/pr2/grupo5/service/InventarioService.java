package gc._4.pr2.grupo5.service;

import java.util.List;
import gc._4.pr2.grupo5.entity.Inventario;

public interface InventarioService {
	Inventario guardarInventario(Inventario inventario);
	List<Inventario> obtenerTodosLosInventarios();
	Inventario obtenerInventarioPorId(Long id);
	Inventario  crearInventario(Inventario inventario);
	public boolean existe(Long id); //Cambiado de actualizarProducto a existe
	void eliminarInventario(Long id);

}
