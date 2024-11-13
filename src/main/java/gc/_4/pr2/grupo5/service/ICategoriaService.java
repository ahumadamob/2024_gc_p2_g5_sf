package gc._4.pr2.grupo5.service;

import java.util.List;
import gc._4.pr2.grupo5.entity.Categoria;

public interface ICategoriaService {
    
    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria create(Categoria categoria);

    Categoria update(Long id, Categoria categoria);  

    void delete(Long id);

    boolean existsById(Long id);
}

