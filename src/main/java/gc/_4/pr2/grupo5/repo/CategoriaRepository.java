package gc._4.pr2.grupo5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import gc._4.pr2.grupo5.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}