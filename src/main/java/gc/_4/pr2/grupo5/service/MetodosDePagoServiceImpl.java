package gc._4.pr2.grupo5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo5.entity.MetodosDePago;
import gc._4.pr2.grupo5.repo.MetodosDePagoRepository;

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
	public MetodosDePago obtenerMetodosDePagoPorId(Long id) {
		return metodosdepagoRepository.findById(id).orElse(null);
	}
	
	@Override
	public MetodosDePago actualizarMetodosDePago(Long id, MetodosDePago metodosdepago) {
		MetodosDePago metodosdepagoExistente = metodosdepagoRepository.findById(id).orElse(null);
		if (metodosdepagoExistente != null) {
			return metodosdepagoRepository.save(metodosdepagoExistente);
		} else {
			return null;
		}
	}
	
	@Override
	public void eliminarMetodosDePago(Long id) {
		metodosdepagoRepository.deleteById(id);
	}
}
