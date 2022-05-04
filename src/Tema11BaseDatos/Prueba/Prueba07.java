package Tema11BaseDatos.Prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba07 {

	public static void main(String[] args) {
		Connection con = null;
		Statement sentencia;
		String sql;
		String url = "jdbc:mysql://localhost:3306/circoivan";
		
		String nombre, atraccion;
		
		try {
			con = DriverManager.getConnection(url, "root", "carlos");
			// Necesitamos un statement para ejecutar una sentencia
			sentencia = con.createStatement();


			// Para la ejecucion de sentencias que devuelven algo, necesitamos el elemento
			// resultado
			// Inserta una pista y aforo por teclado.
			sql = "DELETE FROM circoivan.artistas WHERE artistas.nombre = 'Julio' AND artistas.apellidos = 'Fernandez Ramirez'";
			con.setAutoCommit(false);
			con.commit();
			con.setAutoCommit(true);
			
			sentencia.executeUpdate(sql);
			con.close();
		} catch (SQLException ex) {
			//con.rollback();
			ex.printStackTrace();
			System.out.println("SQLExcepion: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError " + ex.getErrorCode());
		} finally {
			//con.close();
		}
	}

}
