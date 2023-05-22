package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.modeloProducto;
import clases.Producto;

/**
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		int id_seccion = Integer.parseInt(request.getParameter("seccion"));
		
		Producto producto = new Producto();
		
		mP.Conectar();
		boolean codigoEncontrado = mP.validarProducto(codigo);
		mP.cerrar();
		
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setCantidad(cantidad);
		producto.setPrecio(precio);
		try {
			producto.setCaducidad(formato.parse(request.getParameter("caducidad")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setId_seccion(id_seccion);

			if ((codigoEncontrado == true) || (precio <= 0) || (cantidad <= 0) || (producto.getCaducidad().before(new Date()))) {
				System.out.println("Datos introducidos erroneos. Introduce datos validos.");
			} else {
				mP.Conectar();
				mP.insertarProducto(producto);
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
