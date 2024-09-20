package gc._4.pr2.grupo5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo5.repo.CategoriaRepository;
import gc._4.pr2.grupo5.entity.Categoria;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).get();  
    }

    @Override
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id).get();  

        existingCategoria.setNombre(categoria.getNombre());

        return categoriaRepository.save(existingCategoria);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}


