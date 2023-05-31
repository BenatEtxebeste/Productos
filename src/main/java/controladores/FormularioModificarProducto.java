package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import clases.Seccion;
import modelos.modeloProducto;
import modelos.modeloSeccion;

/**
 * Servlet implementation class FormularioModificarProducto
 */
@WebServlet("/FormularioModificarProducto")
public class FormularioModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloSeccion mS = new modeloSeccion();
		modeloProducto mP = new modeloProducto();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		mP.Conectar();
		Producto producto = mP.getProducto(id);
		mP.cerrar();
		
		mS.Conectar();
		ArrayList<Seccion> secciones = mS.getSecciones();
		mS.cerrar();
		
		request.setAttribute("secciones", secciones);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
