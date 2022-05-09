package Tema11BaseDatos.Relacion01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SentenciasMetodos {
	// Variables
	static String id = "actor_id";
	static String nombre = "first_name";
	static String apellidos = "last_name";
	static String ciudadID = "city_id";
	static String nombreCiudad = "city";
	static String paisID = "country_id";
	static String peliculaID= "film_id";
	static String titulo = "title";
	static String duracionPelicula = "length";

	// Metodo Ejercicio01
	public static void nombreScarlett(Connection con) throws SQLException {
		String sql = "SELECT * FROM sakila.actor WHERE upper(first_name) = 'SCARLETT'";
		PreparedStatement sentencia = con.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();

		// Mostramos
		System.out.println("Ejercicio01");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(id) + "\t" + rs.getString(nombre) + "\t" + rs.getString(apellidos));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio02
	public static void apellidoJohansson(Connection con) throws SQLException {
		String sql = "SELECT * FROM sakila.actor WHERE upper(last_name) = 'JOHANSSON'";
		PreparedStatement sentencia = con.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio02");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(id) + "\t" + rs.getString(nombre) + "\t\t" + rs.getString(apellidos));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio03
	public static void cotengaOnombre(Connection con) throws SQLException {
		String sql = "SELECT * FROM sakila.actor WHERE upper(first_name) LIKE '%O'";
		PreparedStatement sentencia = con.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio03");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(id) + "\t" + rs.getString(nombre) + "\t\t" + rs.getString(apellidos));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio04
	public static void cotenOnombreAapellido(Connection con) throws SQLException {
		String sql = "SELECT * FROM sakila.actor WHERE upper(first_name) LIKE '%O' AND upper(last_name) LIKE '%A%'";
		PreparedStatement sentencia = con.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio04");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(id) + "\t" + rs.getString(nombre) + "\t\t" + rs.getString(apellidos));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio05
	public static void cotenDosOnombreAapellido(Connection con) throws SQLException {
		String sql = "SELECT * FROM sakila.actor WHERE upper(first_name) LIKE '%O%O%' AND upper(last_name) LIKE '%A%'";
		PreparedStatement sentencia = con.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio05");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(id) + "\t" + rs.getString(nombre) + "\t\t" + rs.getString(apellidos));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio06
	public static void paisID(Connection con, int id) throws SQLException {
		String sql = "SELECT * FROM sakila.city WHERE country_id = ?";
		PreparedStatement sentencia = con.prepareStatement(sql);
		sentencia.setInt(1, id); // Se buscara el ID introducido por teclado
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio06");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out
					.println(rs.getString(ciudadID) + "\t" + rs.getString(nombreCiudad) + "\t" + rs.getString(paisID));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio07
	public static void ciudadxPais(Connection con, String nomciudad) throws SQLException {
		String sql = "SELECT * FROM sakila.city WHERE country_id = (SELECT country_id FROM country WHERE upper(country) = ?)";
		PreparedStatement sentencia = con.prepareStatement(sql);
		sentencia.setString(1, nomciudad); // Se buscara el ID introducido por teclado
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio07");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out
					.println(rs.getString(ciudadID) + "\t" + rs.getString(nombreCiudad) + "\t" + rs.getString(paisID));
			System.out.println("---------------------------------");
		}
	}

	// Metodo Ejercicio08
	public static void duracionPeliculas(Connection con, int minutoMin, int minutoMax) throws SQLException {
		String sql = "SELECT * FROM sakila.film WHERE length Between ? AND  ?";
		PreparedStatement sentencia = con.prepareStatement(sql);
		sentencia.setInt(1, minutoMin); // minuto minimo
		sentencia.setInt(2, minutoMax); // minuto maximo
		ResultSet rs = sentencia.executeQuery();
		System.out.println("Ejercicio08");
		System.out.println("_________________________________");
		System.out.println("ID" + "\tNombre" + "\t\tApellidos");
		System.out.println("_________________________________");
		while (rs.next()) {
			System.out.println(rs.getString(peliculaID) + "\t" + rs.getString(titulo) + "\t" + rs.getString(duracionPelicula));
			System.out.println("---------------------------------");
		}
	}
}

