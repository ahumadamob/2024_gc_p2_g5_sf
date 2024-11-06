package gc._4.pr2.grupo5.service.impl;

import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.repo.ProductosRepository; // Cambiado a "repo"
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
        return productosRepository.findById(id).get();
    }

    @Override
    public Productos createProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    // Reemplazo de updateProducto por saveProducto
    @Override
    public Productos saveProducto(Productos productoDetails) {
        Productos producto = productosRepository.findById(productoDetails.getId()).get();

        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setCategoria(productoDetails.getCategoria());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setTamaño(productoDetails.getTamaño());
        producto.setColor(productoDetails.getColor());
        producto.setCantidadStock(productoDetails.getCantidadStock());
        producto.setImagenes(productoDetails.getImagenes());

        return productosRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productosRepository.deleteById(id);
    }

    @Override
	public boolean existe(Long id) {
		if(id == null) {
			return false;
		}else {
			return productosRepository.existsById(id);
		}
	}

    

}   