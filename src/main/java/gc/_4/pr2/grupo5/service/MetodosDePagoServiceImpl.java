package gc._4.pr2.grupo5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo5.entity.MetodosDePago;
import gc._4.pr2.grupo5.repositorio.MetodosDePagoRepository;

@Service
public class MetodosDePagoServiceImpl implements MetodosDePagoService {
	@Autowired
	private MetodosDePagoRepository metodosdepagoRepository;
	@Override
	public MetodosDePago guardarMetodosDePago(MetodosDePago metodosdepago) {
		return metodosdepagoRepository.save(metodosdepago);
	}
	@Override
	public List<MetodosDePago> obtenerTodosLosMetodosDePago() {
		return metodosdepagoRepository.findAll();
	}
	@Override
	public Optional<MetodosDePago> obtenerMetodosDePagoPorId(Long id) {
		return metodosdepagoRepository.findById(id);
	}
	@Override
	public void eliminarMetodosDePago(Long id) {
		metodosdepagoRepository.deleteById(id);
	}
}
