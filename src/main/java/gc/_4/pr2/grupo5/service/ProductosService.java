package gc._4.pr2.grupo5.service;

import gc._4.pr2.grupo5.entity.Productos;
import java.util.List;

public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductoById(Long id);
    Productos createProducto(Productos producto);
    Productos saveProducto(Productos producto); // Cambiado de updateProducto a saveProducto
    void deleteProducto(Long id);
    public boolean existe(Long id);
    List<Productos> findByDestacado(boolean destacado);

}
