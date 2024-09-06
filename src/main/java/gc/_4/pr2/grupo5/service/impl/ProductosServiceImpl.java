package gc._4.pr2.grupo5.service.impl;

import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.repository.ProductosRepository;
import gc._4.pr2.grupo5.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Optional<Productos> getProductoById(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    public Productos createProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos updateProducto(Long id, Productos productoDetails) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            Productos productoActualizado = producto.get();
            productoActualizado.setNombre(productoDetails.getNombre());
            productoActualizado.setDescripcion(productoDetails.getDescripcion());
            productoActualizado.setCategoria(productoDetails.getCategoria());
            productoActualizado.setPrecio(productoDetails.getPrecio());
            productoActualizado.setTamaño(productoDetails.getTamaño());
            productoActualizado.setColor(productoDetails.getColor());
            productoActualizado.setCantidadStock(productoDetails.getCantidadStock());
            productoActualizado.setImagenes(productoDetails.getImagenes());
            return productosRepository.save(productoActualizado);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    @Override
    public void deleteProducto(Long id) {
        if (productosRepository.existsById(id)) {
            productosRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}
