package upeu.edu.pe.Mensaje.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import upeu.edu.pe.Mensaje.Dao.MensajeDao;
import upeu.edu.pe.Mensaje.Entity.Mensaje;
import upeu.edu.pe.Mensaje.Util.Conexion;

public class MensajeDaoImp implements MensajeDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;

	@Override
	public int create(Mensaje m) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO mensaje (idmensaje, titulo, descripcion, idusuario) VALUES (null,?,?,?)";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, m.getTitulo());
			ps.setString(2, m.getDescripcion());
			ps.setInt(3, m.getIdusuario());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear mensaje..." + e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM mensaje WHERE idmensaje = ?";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar..." + e);
		}
		return x;
	}

	@Override
	public int update(Mensaje m) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE mensaje set titulo = ?, descripcion = ? WHERE idmensaje = ?";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, m.getTitulo());
			ps.setString(2, m.getDescripcion());
			ps.setInt(3, m.getIdmensaje());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modificar.." + e);
		}
		return x;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = new ArrayList<>();
		String SQL = "SELECT m.idmensaje, m.titulo, m.descripcion, m.idusuario,"+"u.nombre, u.idusuario FROM mensaje AS m, usuario AS u WHERE m.idusuario = u.idusuario";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("idmensaje", rs.getInt("idmensaje"));
				map.put("nombre", rs.getString("nombre"));
				map.put("titulo", rs.getString("titulo"));
				map.put("descripcion", rs.getString("descripcion"));
				map.put("idusuario", rs.getInt("idusuario"));
				lista.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar mensaje.." + e);
		}
		return lista;
	}

	@Override
	public List<Map<String, Object>> readAll(int id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = new ArrayList<>();
		String SQL = "SELECT m.idmensaje, m.titulo, m.descripcion, m.idusuario,"
		+"u.nombre, u.idusuario FROM mensaje AS m, usuario AS u WHERE m.idusuario = u.idusuario AND idmensaje = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("idmensaje", rs.getInt("idmensaje"));
				map.put("nombre", rs.getString("nombre"));
				map.put("titulo", rs.getString("titulo"));
				map.put("descripcion", rs.getString("descripcion"));
				map.put("idusuario", rs.getInt("idusuario"));
				lista.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar mensaje.." + e);
		}
		return lista;
	}

	@Override
	public Mensaje read(int id) {
		// TODO Auto-generated method stub
		String SQL = "SELECT FROM mensaje WHERE idmensaje = ?";
		Mensaje m =  new Mensaje();
		try {
			cx =  Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				m.setIdmensaje(rs.getInt("idmensaje"));
				m.setTitulo(rs.getString("titulo"));
				m.setDescripcion(rs.getString("descripcion"));
				m.setIdusuario(rs.getInt("idusuario"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al modi"+e);
		}
		return m;
	}

}
