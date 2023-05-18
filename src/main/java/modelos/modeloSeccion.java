package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Seccion;

public class modeloSeccion extends Conexion{

	public Seccion getSeccion(int id_seccion) {
		Seccion seccion = new Seccion();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM secciones WHERE id = ?");
			
			pst.setInt(1, id_seccion);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			
			seccion.setId(id_seccion);
			seccion.setNombre(resultado.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seccion;
	}

	public ArrayList<Seccion> getSecciones(){
		ArrayList<Seccion> secciones = new ArrayList<Seccion>();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM secciones");
			
			ResultSet resultado = pst.executeQuery();
			
			while (resultado.next()) {
				Seccion seccion = new Seccion();
				
				seccion.setId(resultado.getInt("id"));
				seccion.setNombre(resultado.getString("nombre"));
				
				secciones.add(seccion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secciones;
	}
}
