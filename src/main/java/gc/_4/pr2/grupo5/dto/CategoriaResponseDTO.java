package gc._4.pr2.grupo5.dto;

public class CategoriaResponseDTO {

    private boolean estado;
    private String mensaje;
    private Object categoria;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getCategoria() {
        return categoria;
    }

    public void setCategoria(Object categoria) {
        this.categoria = categoria;
    }
}

