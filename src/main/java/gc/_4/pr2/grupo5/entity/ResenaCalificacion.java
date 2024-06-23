package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="resena_calificacion")
public class ResenaCalificacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	
	private String producto;
	
	private int calificacion;
	
	private String comentario;
	
	public Long getId() {
		return id;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "id_productos")
	private Productos productosRelacion;


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public int getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Productos getProductosRelacion() {
		return productosRelacion;
	}


	public void setProductosRelacion(Productos productosRelacion) {
		this.productosRelacion = productosRelacion;
	}

}
