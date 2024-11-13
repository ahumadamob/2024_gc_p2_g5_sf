package gc._4.pr2.grupo5.dto;

// DTO para encapsular el estado, mensaje y datos de envío en las respuestas del controlador
public class EnviosResponseDTO {
    // Atributos privados para garantizar el acceso controlado (encapsulamiento)
    private boolean estado;
    private String mensaje;
    private Object envio;

    // Constructor para inicializar el DTO
    public EnviosResponseDTO(boolean estado, String mensaje, Object envio) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.envio = envio;
    }

    // Ejemplo de getter para obtener el valor de 'estado' (encapsulamiento)
    public boolean isEstado() {
        return estado;
    }

    // Ejemplo de setter para modificar el valor de 'estado' (encapsulamiento)
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Getter y setter para el atributo 'mensaje'
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getter y setter para el atributo 'envio'
    public Object getEnvio() {
        return envio;
    }

    public void setEnvio(Object envio) {
        this.envio = envio;
    }
}
