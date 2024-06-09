package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Ordenes")
public class OrdenPedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int numeroOrden;
	private int fecha;
	private String usuario;
	private String estado;
	private String productosAdquiridos;
	private int totalCompras;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProductosAdquiridos() {
		return productosAdquiridos;
	}
	public void setProductosAdquiridos(String productosAdquiridos) {
		this.productosAdquiridos = productosAdquiridos;
	}
	public int getTotalCompras() {
		return totalCompras;
	}
	public void setTotalCompras(int totalCompras) {
		this.totalCompras = totalCompras;
	}
	
	
}
