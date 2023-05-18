package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author benat
 *
 */
public class Conexion {
	
	protected  Connection conexion;

	/**
	 * 
	 */
	public void Conectar() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.conexion = DriverManager.getConnection("jdbc:mysql://" + ParametrosConexion.HOST + "/" + ParametrosConexion.BBDD, ParametrosConexion.USERNAME, ParametrosConexion.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	/**
	 * 
	 */
	public void cerrar() {
		
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return una conexion
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * 
	 * @param conexion recibe una conexion
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}