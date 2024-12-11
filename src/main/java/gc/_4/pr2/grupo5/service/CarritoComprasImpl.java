package gc._4.pr2.grupo5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.repo.CarritoComprasRepository;

import java.util.List;

@Service
public class CarritoComprasImpl implements ICarritoComprasService {
    @Autowired
    private CarritoComprasRepository carritocomprasRepository;

    @Override
    public CarritoCompras guardarCarritoCompras(CarritoCompras carritocompras) {
        return carritocomprasRepository.save(carritocompras);
    }

    @Override
    public List<CarritoCompras> obtenerTodosLosCarritoCompras() {
        return carritocomprasRepository.findAll();
    }

    @Override
    public CarritoCompras obtenerCarritoComprasPorId(Long id) {
        return carritocomprasRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCarritoCompras(Long id) {
        carritocomprasRepository.deleteById(id);
    }
    
    @Override
   	public boolean existe(Long id) {
   		if(id == null) {
   			return false;
   		}else {
   			return carritocomprasRepository.existsById(id);
   		}
   	}
    
    @Override
   	public boolean estado(Long id) {
   		if(id == null) {
   			return false;
   		}else {
   			return carritocomprasRepository.existsById(id);
   		}
   	}

    
}