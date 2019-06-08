package upeu.edu.pe.Mensaje.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.javafx.logging.Logger;

import upeu.edu.pe.Mensaje.Dao.MensajeDao;
import upeu.edu.pe.Mensaje.Dao.UsuarioDao;
import upeu.edu.pe.Mensaje.DaoImp.MensajeDaoImp;
import upeu.edu.pe.Mensaje.DaoImp.UsuarioDaoImp;
import upeu.edu.pe.Mensaje.Entity.Mensaje;

/**
 * Servlet implementation class MensajeController
 */
@WebServlet("/mc")
public class MensajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson g = new Gson();
	private UsuarioDao ud = new UsuarioDaoImp();
	private MensajeDao md = new MensajeDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MensajeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			out.println(g.toJson(md.readAll()));
			break;
		case 2:
			out.println(g.toJson(md.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		case 3:
			out.println(g.toJson(md.read(Integer.parseInt(request.getParameter("id")))));
		case 4:
			out.println(g.toJson(ud.readAll()));
			break;
		case 5:
			Mensaje men = new Mensaje(0, request.getParameter("titu"), request.getParameter("descr"), Integer.parseInt(request.getParameter("user")));
			out.println(g.toJson(md.create(men)));
			break;
		case 6:
			
			Mensaje mens = new Mensaje(Integer.parseInt(request.getParameter("id")), request.getParameter("titu2"), request.getParameter("descr2"), 0);
			out.println(g.toJson(md.update(mens)));
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
