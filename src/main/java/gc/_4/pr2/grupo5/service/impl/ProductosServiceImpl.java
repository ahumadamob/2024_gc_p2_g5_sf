package gc._4.pr2.grupo5.service.impl;

import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.repo.ProductosRepository;
import gc._4.pr2.grupo5.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductoById(Long id) {
        return productosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Productos createProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos updateProducto(Long id, Productos productoDetails) {
        if (!productosRepository.existsById(productoDetails.getId())) {
            throw new RuntimeException("Producto no encontrado");
        }
        return productosRepository.save(productoDetails);
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

