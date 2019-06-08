package upeu.edu.pe.Mensaje.Test;

import com.google.gson.Gson;

import upeu.edu.pe.Mensaje.Dao.UsuarioDao;
import upeu.edu.pe.Mensaje.DaoImp.UsuarioDaoImp;

public class TestUsuario {
	private static UsuarioDao ud = new UsuarioDaoImp();
	private static Gson g = new Gson();

	public static void main(String[] args) {
		listarU();
	}

	static void listarU() {
		System.out.println(g.toJson(ud.readAll()));
	}
}
