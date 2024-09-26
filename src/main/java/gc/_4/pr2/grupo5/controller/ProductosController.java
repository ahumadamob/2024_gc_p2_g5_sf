package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Long id) {
        Productos producto = productosService.getProductoById(id); // Cambiado de Optional a Productos
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        return productosService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable Long id, @RequestBody Productos producto) {
        try {
            return ResponseEntity.ok(productosService.updateProducto(id, producto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        try {
            productosService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
