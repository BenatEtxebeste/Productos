package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.modeloProducto;

/**
 * Servlet implementation class EliminarMultiple
 */
@WebServlet("/EliminarMultiple")
public class EliminarMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarMultiple() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		String cadenaCodigos = request.getParameter("codigos");
		String [] codigos = cadenaCodigos.split(",");
		boolean codigoExistente = true;
		boolean error = false;
		
		for (String codigo : codigos) {
			mP.Conectar();
			boolean existe = mP.validarProducto(codigo); //Mira si el código existe.
			mP.cerrar();
			if (existe == false) {
				codigoExistente = false;
				error = true;
				request.setAttribute("error", error);
				break;
			}
		}
		
		if (codigoExistente == true) {
			mP.Conectar();
			mP.eliminarCodigos(codigos);
			mP.cerrar();
		}
		
		request.getRequestDispatcher("VerProductos").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
