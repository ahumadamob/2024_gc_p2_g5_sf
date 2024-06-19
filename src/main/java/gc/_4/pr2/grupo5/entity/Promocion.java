package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePromocion;

    private double porcentajeDescuento;

    private String productosAplicables;

    private Date fechaInicio;

    private Date fechaFinal;
    
    @ManyToMany(mappedBy = "promociones")
    private Set<Productos> productos = new HashSet<>();

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getProductosAplicables() {
        return productosAplicables;
    }

    public void setProductosAplicables(String productosAplicables) {
        this.productosAplicables = productosAplicables;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

	public Set<Productos> getProductos() {
		return getProductos();
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}
    
}
