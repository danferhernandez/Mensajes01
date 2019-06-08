package upeu.edu.pe.Mensaje.Dao;

import java.util.List;
import java.util.Map;

import upeu.edu.pe.Mensaje.Entity.Mensaje;

public interface MensajeDao {
	int create(Mensaje m);

	int delete(int id);

	int update(Mensaje m);

	Mensaje read(int id);

	List<Map<String, Object>> readAll();

	List<Map<String, Object>> readAll(int id);
}
