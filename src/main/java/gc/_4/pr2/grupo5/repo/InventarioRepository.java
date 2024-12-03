package gc._4.pr2.grupo5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo5.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
	List<Inventario> findByRequiereReabastecimiento(boolean requiereReabastecimiento);
	
}
