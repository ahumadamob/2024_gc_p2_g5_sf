package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.entity.Productos;
import gc._4.pr2.grupo5.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.RespuestaDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    //buscar todos los productos
    @GetMapping("/productos")
    public RespuestaDTO <List<Productos>> getAllProductos() { 
        List <Productos> listaProductos;
        listaProductos = new ArrayList();
        listaProductos = productosService.getAllProductos();

        RespuestaDTO <List<Productos>> dto;
        dto = new RespuestaDTO<List<Productos>>();

        if (listaProductos.isEmpty()){
            dto.setEstado(false);
            List<String> mensajes = new ArrayList<>();
            mensajes.add("No hay productos");
            dto.setData(null);
        }else{
            List<String> mensajes = new ArrayList<>();
            mensajes.add("Salio todo bien.");
            mensajes.add("Se encontraron los siguientes productos:");
            dto.setEstado(true);
            dto.setMensaje(mensajes);
            dto.setData(listaProductos);
        }

        return dto;
    }

    //buscar producto por id
    @GetMapping("/productos/{id}")
    public RespuestaDTO<Productos> getProductoById(@PathVariable ("id") Long id) {
        if(productosService.existe(id)) {
			Productos producto = new Productos();
            // En esta linea se instancia un producto
			producto = productosService.getProductoById(id);
            // En esta linea se inicializa un producto
			RespuestaDTO<Productos> dto;
			dto = new RespuestaDTO<Productos>(true, "Se encontro el siguiente producto: ", producto);
			return dto;
        }else{
            return new RespuestaDTO<Productos>(false, "No existen productos con el id: " + id, null);
        }


    }


    // Crear un nuevo producto
    @PostMapping("/productos")
    public RespuestaDTO<Productos> createProducto(@RequestBody Productos producto) {
        if (productosService.existe(producto.getId())) {
            return new RespuestaDTO<Productos>(false, "El id ingresado ya existe", null);
        } else {
            return new RespuestaDTO<Productos>(true, "Producto creado con éxito", productosService.createProducto(producto));
        }
    }


    //Actualizar un producto
    @PutMapping("/productos")
    public RespuestaDTO<Productos> saveProducto(@RequestBody Productos producto) {
        if (productosService.existe(producto.getId())) {
            return new RespuestaDTO<Productos>(true, "Producto actualizado con éxito", productosService.saveProducto(producto));
        }else{
            return new RespuestaDTO<Productos>(false, "No existen productos con el id: " + producto.getId().toString(), null);
        }
    }


    // Eliminar un producto por id
    @DeleteMapping("/productos/{id}")
    public RespuestaDTO<?> deleteProducto(@PathVariable ("id") Long id) {
        if (productosService.existe(id)) {
            productosService.deleteProducto(id);
            return new RespuestaDTO<>(true, "Producto con id: " + id.toString() + " eliminado con éxito", null);
        }else{
            return new RespuestaDTO<>(false, "No existen productos con el id: " + id.toString(), null);
        }
        
    }
}

