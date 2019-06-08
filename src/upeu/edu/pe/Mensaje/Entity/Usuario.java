package upeu.edu.pe.Mensaje.Entity;

public class Usuario {
	private int idusuario;
	private String nombre;

	public Usuario() {

	}

	public Usuario(int idusuario, String nombre) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
