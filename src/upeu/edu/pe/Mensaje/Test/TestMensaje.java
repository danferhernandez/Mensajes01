package upeu.edu.pe.Mensaje.Test;

import com.google.gson.Gson;

import upeu.edu.pe.Mensaje.Dao.MensajeDao;
import upeu.edu.pe.Mensaje.DaoImp.MensajeDaoImp;

public class TestMensaje {
	private static MensajeDao md = new MensajeDaoImp();
	private static Gson g = new Gson();

	public static void main(String[] args) {
		listarm();
	}

	static void listarm() {
		System.out.println(g.toJson(md.readAll()));
	}
}
