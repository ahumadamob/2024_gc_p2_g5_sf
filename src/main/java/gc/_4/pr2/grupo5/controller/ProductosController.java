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
        Productos producto = productosService.getProductoById(id); // Se mantiene como Productos, no Optional
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        return productosService.createProducto(producto);
    }

    // Cambiado de updateProducto a saveProducto
    @PutMapping("/{id}")
    public ResponseEntity<Productos> saveProducto(@PathVariable Long id, @RequestBody Productos productoDetails) {
        try {
            productoDetails.setId(id); // Establece el id recibido en la URL en el objeto productoDetails
            return ResponseEntity.ok(productosService.saveProducto(productoDetails));
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

