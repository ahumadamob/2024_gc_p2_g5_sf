package gc._4.pr2.grupo5.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.repo.CarritoComprasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoComprasServiceImpl implements CarritoComprasService {
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
    public Optional<CarritoCompras> obtenerCarritoComprasPorId(Long id) {
        return carritocomprasRepository.findById(id);
    }

    @Override
    public void eliminarCarritoCompras(Long id) {
        carritocomprasRepository.deleteById(id);
    }
}