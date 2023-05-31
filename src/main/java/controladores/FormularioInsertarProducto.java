package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Seccion;
import clases.Supermercado;
import modelos.modeloProducto;
import modelos.modeloSeccion;

/**
 * Servlet implementation class FormularioInsertarProducto
 */
@WebServlet("/FormularioInsertarProducto")
public class FormularioInsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioInsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloSeccion mS = new modeloSeccion();
		modeloProducto mP = new modeloProducto();
		
		mS.Conectar();
		ArrayList<Seccion> secciones = mS.getSecciones();
		mS.cerrar();
		
		mP.Conectar();
		ArrayList<Supermercado>supermercados = mP.getSupermercado();
		mP.cerrar();
		
		request.setAttribute("secciones", secciones);
		request.setAttribute("supermercados", supermercados);
		request.getRequestDispatcher("InsertarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
