package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritocompras")
public class CarritoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private Long id;
    //Ejemplo de ENCAPSULAMIENTO (Atributos privados, se restringe el acceso directo)
    private String usuario;
    
    private String productosAnadidos;
    
    private int cantidad;
    
    private double precioTotal;
    
    private boolean estado;//nueva propiedad agregada
    
    //Ejemplos de getters y setters dentro de la clase
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProductosAnadidos() {
        return productosAnadidos;
    }

    public void setProductosAnadidos(String productosAnadidos) {
        this.productosAnadidos = productosAnadidos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
