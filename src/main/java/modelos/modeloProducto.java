package modelos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Producto;
import clases.Supermercado;

public class modeloProducto extends Conexion{

	public ArrayList<Producto> getProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		modeloSeccion mS = new modeloSeccion();
		mS.Conectar();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos");
			
			ResultSet resultado = pst.executeQuery();
			
			while (resultado.next()) {
				Producto producto = new Producto();
				
				producto.setId(resultado.getInt("id"));
				producto.setCodigo(resultado.getString("codigo"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setCantidad(resultado.getInt("cantidad"));
				producto.setPrecio(resultado.getDouble("precio"));
				producto.setCaducidad(resultado.getDate("caducidad"));
				producto.setSeccion(mS.getSeccion(resultado.getInt("id_seccion")));
				
				
				productos.add(producto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mS.cerrar();
		return productos;
	}
	
	public void insertarProducto(Producto producto) {
		try {
			PreparedStatement pst = conexion.prepareStatement("INSERT INTO productos (codigo, nombre, cantidad, precio, caducidad, id_seccion) VALUES (?,?,?,?,?,?)");
			
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date (producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getId_seccion());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarProducto(int id) {
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM productos WHERE id = ?");
			
			pst.setInt(1, id);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validarProducto(String codigo) {
		boolean encontrado = false;
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos WHERE codigo = ?");
			
			pst.setString(1, codigo);
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				encontrado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encontrado;
	}

	public Producto getProducto(int id) {
		Producto producto = new Producto();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos WHERE id = ?");
			
			pst.setInt(1, id);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			
			producto.setId(id);
			producto.setCodigo(resultado.getString("codigo"));
			producto.setNombre(resultado.getString("nombre"));
			producto.setCantidad(resultado.getInt("cantidad"));
			producto.setPrecio(resultado.getDouble("precio"));
			producto.setCaducidad(resultado.getDate("caducidad"));
			producto.setId_seccion(resultado.getInt("id_seccion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return producto;
	}

	public void modificarProducto(Producto producto) {
		try {
			PreparedStatement pst = conexion.prepareStatement("UPDATE productos SET codigo = ?, nombre = ?, cantidad = ?, precio = ?, caducidad = ?, id_seccion = ? WHERE id = ?");
			
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date (producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getId_seccion());
			pst.setInt(7, producto.getId());
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Supermercado> getSupermercado(){
		ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM supermercados");
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Supermercado supermercado = new Supermercado();
				
				supermercado.setId(resultado.getInt("id"));
				supermercado.setNombre(resultado.getString("nombre"));
				
				supermercados.add(supermercado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return supermercados;
	}

	public int idMasAlto() {
		int idMasAlto = 0;
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT MAX(id) FROM productos");
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			
			idMasAlto = resultado.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idMasAlto;
	}

	public void insertarProductoSupermercado(int idMasAlto, String[] supermercados) {
		try {
			PreparedStatement pst = conexion.prepareStatement("INSERT INTO productos_supermercados (id_producto, id_supermercado) VALUES (?, ?)");
			
			pst.setInt(1, idMasAlto);
			
			for (String supermercado : supermercados) {
				pst.setInt(2, Integer.parseInt(supermercado));
				pst.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void eliminarUnaUnidad(int id, int cantidad) {
		try {
			PreparedStatement pst = conexion.prepareStatement("UPDATE productos SET cantidad = ? WHERE id = ?");
			
			pst.setInt(1, cantidad - 1);
			pst.setInt(2, id);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean buscarProductoEnSupermercado(int id) {
		boolean encontrado = false;
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos_supermercados WHERE id_producto = ?");
			
			pst.setInt(1, id);
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				encontrado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encontrado;
	}

	public void eliminarProductoDeSupermercados(int id) {
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM productos_supermercados WHERE id_producto = ?");
			
			pst.setInt(1, id);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarCodigos(String[] codigos) {
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM productos WHERE codigo = ?");
			
			for (String codigo : codigos) {
				pst.setString(1, codigo);
				pst.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
