package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private String categoria;
	private String precio;
	private String tamaño;
	private String color;
	private String cantidadStock;
	private String imagenes;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoriaRelacion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(String cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getImagenes() {
		return imagenes;
	}
	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}
	
	public Categoria getCategoriaRelacion() {
		return categoriaRelacion;
	}
	public void setCategoriaRelacion(Categoria categoriaRelacion) {
		this.categoriaRelacion = categoriaRelacion;
	}
	
}
