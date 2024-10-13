package gc._4.pr2.grupo5.repo; // cambiado a repo

import org.springframework.data.jpa.repository.JpaRepository;
import gc._4.pr2.grupo5.entity.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
}