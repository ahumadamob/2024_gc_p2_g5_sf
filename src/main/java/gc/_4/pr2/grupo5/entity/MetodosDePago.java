package gc._4.pr2.grupo5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodosdepago")
public class MetodosDePago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoMetodo;
	private String detallesMetodoPago;
	private boolean activo;
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoMetodo() {
		return tipoMetodo;
	}
	public void setTipoMetodo(String tipoMetodo) {
		this.tipoMetodo = tipoMetodo;
	}
	public String getDetallesMetodoPago() {
		return detallesMetodoPago;
	}
	public void setDetallesMetodoPago(String detallesMetodoPago) {
		this.detallesMetodoPago = detallesMetodoPago;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	} 
}
