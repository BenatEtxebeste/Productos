package modelos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Producto;

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
				producto.setCodigo(resultado.getInt("codigo"));
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
			
			pst.setInt(1, producto.getCodigo());
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
	
	public boolean validarProducto(int codigo) {
		boolean encontrado = false;
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos WHERE codigo = ?");
			
			pst.setInt(1, codigo);
			
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
}
