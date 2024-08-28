package gc._4.pr2.grupo5.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo5.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
	@Autowired
	private InventarioRepository inventarioRepository;
	public Inventario guardarInventario(Inventario inventario) {
	return inventarioRepository.save(inventario);
	}
	public List<Inventario> obtenerTodosLosInventarios() {
	return inventarioRepository.findAll();
	}
	public Optional<Inventario> obtenerInventarioPorId(Long id) {
	return inventarioRepository.findById(id);
	}
	public void eliminarInventario(Long id) {
	inventarioRepository.deleteById(id);
	}
}
