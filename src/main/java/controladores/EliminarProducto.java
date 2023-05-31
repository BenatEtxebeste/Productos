package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.modeloProducto;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		int id = Integer.parseInt(request.getParameter("id"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		mP.Conectar();
		boolean encontrado = mP.buscarProductoEnSupermercado(id);
		mP.cerrar();
		 
		if (cantidad > 0) {
			mP.Conectar();
			mP.eliminarUnaUnidad(id, cantidad);
			mP.cerrar();
		}else if (cantidad == 0 && encontrado == true) {
			mP.Conectar();
			mP.eliminarProductoDeSupermercados(id);
			mP.cerrar();
		}else if (cantidad == 0 && encontrado == false) {
			mP.Conectar();
			mP.eliminarProducto(id);
			mP.cerrar();
		}
		
		response.sendRedirect("VerProductos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
