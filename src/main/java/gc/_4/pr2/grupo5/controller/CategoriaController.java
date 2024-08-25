package gc._4.pr2.grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo5.service.CategoriaService;
import gc._4.pr2.grupo5.entity.Categoria;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.create(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}