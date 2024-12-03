package gc._4.pr2.grupo5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gc._4.pr2.grupo5.entity.Inventario;
import gc._4.pr2.grupo5.repo.InventarioRepository;

@Service
public class InventarioServiceImpl implements InventarioService {
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Override
	public Inventario guardarInventario(Inventario inventario) {
		return inventarioRepository.save(inventario);
		}
	
	@Override
	public List<Inventario> obtenerTodosLosInventarios() {
	return inventarioRepository.findAll();
	}
	
	@Override
	public Inventario obtenerInventarioPorId(Long id) {
	return inventarioRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public void eliminarInventario(Long id) {
	inventarioRepository.deleteById(id);
	}
	
	//Reemplazo actualizarInventario por existe:
	@Override
	public boolean existe(Long id) {
		if(id == null) {
			return false;
		} else {
		return inventarioRepository.existsById(id);
		}
	}

	@Override
	public Inventario crearInventario(Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	
	@Override
	public List<Inventario> findByRequiereReabastecimiento(boolean requiereReabastecimiento) {
		return inventarioRepository.findByRequiereReabastecimiento(requiereReabastecimiento);
		}
}
		