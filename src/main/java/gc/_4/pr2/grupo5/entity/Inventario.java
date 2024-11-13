package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Encapsulamiento: El acceso y visibilidad es limitado
    private String producto;
    private int cantidadStock;
    private int umbralReabastecimiento;
    
  
    @OneToOne
    @JoinColumn(name = "producto_id")  // Nombre de la columna que actúa como clave foránea
    private Productos productoRelacion;
    

	public Inventario() {
        // Constructor vacío requerido por JPA
    }

    // Getters y setters
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getUmbralReabastecimiento() {
        return umbralReabastecimiento;
    }

    public void setUmbralReabastecimiento(int umbralReabastecimiento) {
        this.umbralReabastecimiento = umbralReabastecimiento;
    }
    
    
    public Productos getProductoRelacion() {
		return productoRelacion;
	}

	public void setProductoRelacion(Productos productoRelacion) {
		this.productoRelacion = productoRelacion;
	}
}











