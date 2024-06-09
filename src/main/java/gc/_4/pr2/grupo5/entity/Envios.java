
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "envios")
public class Envios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String direccionEnvio;
	private int fechaEnvio;
	private String empresaTrasnporte;
	private int numeroSeguimiento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	
	public int getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(int fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getEmpresaTrasnporte() {
		return empresaTrasnporte;
	}
	public void setEmpresaTrasnporte(String empresaTrasnporte) {
		this.empresaTrasnporte = empresaTrasnporte;
	}
	public int getNumeroSeguimiento() {
		return numeroSeguimiento;
	}
	public void setNumeroSeguimiento(int numeroSeguimiento) {
		this.numeroSeguimiento = numeroSeguimiento;
	}
	
	
	
	


}
