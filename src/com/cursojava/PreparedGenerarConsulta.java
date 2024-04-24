package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedGenerarConsulta {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "abc123.";
		String query = "SELECT * FROM personas WHERE nombre = ?";
		String nombre = "pepe";

		// Buscar en la base de datos una persona cuyo nombre sea pepe y mostrarlo por pantalla,
		// para ello asignarmos a la variable PreparedStatement la llamada al metodo estatico getPersonaPorNombre
		// con los parametros necesarios
		try (Connection conn = DriverManager.getConnection(conexion, user, pwd);
				PreparedStatement ps = getPersonasPorNombre(query, nombre, conn);
				// Ejecutamos el PreparedStatement y asignamos el resultado al ResultSet
				ResultSet rs = ps.executeQuery();
				) {
			
			// Iteramos sobre el ResultSet y mostramos los datos por pantalla
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellido"));
				System.out.println(rs.getString("edad"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * PreparedStatement para seleccionar una persona en la base de datos por su nombre
	 * @param sql la query
	 * @param nombre el nombre de la persona a buscar
	 * @param conn la conexion
	 * @return el PreparedStatement para luego ejecutarlo
	 * @throws SQLException
	 */
	public static PreparedStatement getPersonasPorNombre(String sql, String nombre, Connection conn) throws SQLException {
		// Instanciar el PreparedStatement con la Conexion y la query
		PreparedStatement ps = conn.prepareStatement(sql);
		// Asignar el nombre en la primera variable de la query
		ps.setString(1, nombre);
		return ps;
	}
	
}
