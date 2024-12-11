package gc._4.pr2.grupo5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo5.entity.CarritoCompras;
import gc._4.pr2.grupo5.entity.Productos;

public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {


}