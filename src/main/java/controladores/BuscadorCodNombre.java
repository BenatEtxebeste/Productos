package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelos.modeloProducto;

/**
 * Servlet implementation class BuscadorCodNombre
 */
@WebServlet("/BuscadorCodNombre")
public class BuscadorCodNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorCodNombre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		String cadena = request.getParameter("codOnombre");
		
		mP.Conectar();
		ArrayList<Producto> productos = mP.getProductos();
		mP.cerrar();
		
		Iterator<Producto> iterator = productos.iterator();
		
		while (iterator.hasNext()) {
			Producto producto = iterator.next();
			String codProducto = producto.getCodigo();
			String nombreProducto = producto.getNombre();
			if (cadena == "") {
				request.getRequestDispatcher("VerProductos").forward(request, response);
			}else if (codProducto.contains(cadena) || nombreProducto.contains(cadena)) {
				
			}else {
				iterator.remove();
			}
		}
		for (Producto producto : productos) {
			System.out.println(producto);
		}
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("VistaProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
