package gc._4.pr2.grupo5.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo5.entity.MetodosDePago;

public interface MetodosDePagoRepository extends  JpaRepository<MetodosDePago, Long> {
	@Autowired
	private MetodosDePagoRepository metodosdepagoRepository;
	public MetodosDePago guardarMetodosDePago(MetodosDePago metodosdepago) {
		return metodosdepagoRepository.save(metodosdepago);
	}
	public List<MetodosDePago> obtenerTodosLosMetodosDePago() {
		return metodosdepagoRepository.findAll();
	}
	public Optional<MetodosDePago> obtenerMetodosDePagoPorId(Long id) {
		return metodosdepago.findById(id);
	}
	public void eliminarMetodosDePago(Long id) {
		metodosdepagoRepository.deleteById(id);
	}
}