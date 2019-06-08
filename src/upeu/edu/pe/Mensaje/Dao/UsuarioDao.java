package upeu.edu.pe.Mensaje.Dao;

import java.util.List;

import upeu.edu.pe.Mensaje.Entity.Usuario;

public interface UsuarioDao {
	int create(Usuario u);

	List<Usuario> readAll();
}
