package upeu.edu.pe.Mensaje.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import upeu.edu.pe.Mensaje.Dao.UsuarioDao;
import upeu.edu.pe.Mensaje.Entity.Usuario;
import upeu.edu.pe.Mensaje.Util.Conexion;

public class UsuarioDaoImp implements UsuarioDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;

	@Override
	public int create(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		String SQL = "SELECT * FROM usuario";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdusuario(rs.getInt("idusuario"));
				u.setNombre(rs.getString("nombre"));
				lista.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al lista usuario..." + e);
		}
		return lista;
	}

}
