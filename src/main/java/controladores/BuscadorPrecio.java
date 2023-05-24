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
 * Servlet implementation class BuscadorPrecio
 */
@WebServlet("/BuscadorPrecio")
public class BuscadorPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorPrecio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		double min = Double.parseDouble(request.getParameter("minPrecio"));
		double max = Double.parseDouble(request.getParameter("maxPrecio"));
		
		mP.Conectar();
		ArrayList<Producto> productos = mP.getProductos();
		mP.cerrar();
		
		Iterator<Producto> iterator = productos.iterator();
		
		while(iterator.hasNext()) {
			Producto producto = iterator.next();
			double precio = producto.getPrecio();
			if (min <= precio && precio <= max) {
				
			}else {
				iterator.remove();
			}
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
