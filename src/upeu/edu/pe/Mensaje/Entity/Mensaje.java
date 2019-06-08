package upeu.edu.pe.Mensaje.Entity;

public class Mensaje {
	private int idmensaje;
	private String titulo;
	private String descripcion;
	private int idusuario;

	public Mensaje() {

	}

	public Mensaje(int idmensaje, String titulo, String descripcion, int idusuario) {
		super();
		this.idmensaje = idmensaje;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idusuario = idusuario;
	}

	public int getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(int idmensaje) {
		this.idmensaje = idmensaje;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

}
