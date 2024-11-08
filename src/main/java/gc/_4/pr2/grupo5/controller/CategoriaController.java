package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.entity.Categoria;
import gc._4.pr2.grupo5.service.CategoriaService;
import gc._4.pr2.grupo5.dto.CategoriaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public CategoriaResponseDTO getAllCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        if (categorias.isEmpty()) {
            response.setEstado(false);
            response.setMensaje("No hay categorías disponibles");
            response.setCategoria(null);
        } else {
            response.setEstado(true);
            response.setMensaje("Categorías encontradas");
            response.setCategoria(categorias);
        }
        return response;
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO getCategoriaById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        if (categoria == null) {
            response.setEstado(false);
            response.setMensaje("Categoría no encontrada");
            response.setCategoria(null);
        } else {
            response.setEstado(true);
            response.setMensaje("Categoría encontrada");
            response.setCategoria(categoria);
        }
        return response;
    }

    @PostMapping
    public CategoriaResponseDTO createCategoria(@RequestBody Categoria categoria) {
        Categoria createdCategoria = categoriaService.create(categoria);
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        if (createdCategoria == null) {
            response.setEstado(false);
            response.setMensaje("Categoría ya existe");
            response.setCategoria(null);
        } else {
            response.setEstado(true);
            response.setMensaje("Categoría creada con éxito");
            response.setCategoria(createdCategoria);
        }
        return response;
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria updatedCategoria = categoriaService.update(id, categoria);
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        if (updatedCategoria == null) {
            response.setEstado(false);
            response.setMensaje("Categoría no encontrada para actualizar");
            response.setCategoria(null);
        } else {
            response.setEstado(true);
            response.setMensaje("Categoría actualizada con éxito");
            response.setCategoria(updatedCategoria);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public CategoriaResponseDTO deleteCategoria(@PathVariable Long id) {
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        try {
            categoriaService.delete(id);
            response.setEstado(true);
            response.setMensaje("Categoría eliminada");
            response.setCategoria(null);
        } catch (RuntimeException e) {
            response.setEstado(false);
            response.setMensaje(e.getMessage()); // Mensaje de error si no se encuentra la categoría
            response.setCategoria(null);
        }
        return response;
    }

    @GetMapping("/exists/{id}")
    public CategoriaResponseDTO existsCategoria(@PathVariable Long id) {
        boolean exists = categoriaService.existsById(id);
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        
        if (exists) {
            response.setEstado(true);
            response.setMensaje("La categoría existe");
        } else {
            response.setEstado(false);
            response.setMensaje("La categoría no existe");
        }
        response.setCategoria(null); // No se devuelve la categoría, solo el mensaje
        return response;
    }
}


