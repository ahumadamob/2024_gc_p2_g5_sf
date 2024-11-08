package gc._4.pr2.grupo5.service;

import gc._4.pr2.grupo5.entity.Categoria;
import gc._4.pr2.grupo5.repo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null); // Devuelve null si no se encuentra la categoría
    }

    @Override
    public Categoria create(Categoria categoria) {
        // Verificamos si la categoría ya existe (por ID)
        Optional<Categoria> existingCategoria = categoriaRepository.findById(categoria.getId());
        if (existingCategoria.isPresent()) {
            return null; // Retorna null si ya existe la categoría con ese ID
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findById(id);
        
        if (existingCategoria.isEmpty()) {
            return null; // Retorna null si no se encuentra la categoría para actualizar
        }

        Categoria updatedCategoria = existingCategoria.get();
        updatedCategoria.setNombre(categoria.getNombre());
        return categoriaRepository.save(updatedCategoria);
    }

    @Override
    public void delete(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);  // Elimina la categoría si existe
        } else {
            throw new RuntimeException("Categoría no encontrada para eliminar");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return categoriaRepository.existsById(id); // Verifica si una categoría existe por ID
    }
}


