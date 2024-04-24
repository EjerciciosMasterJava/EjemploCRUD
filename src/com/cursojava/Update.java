package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		
		try (Connection conn = DriverManager.getConnection(conexion, "root", "abc123.");){
			System.out.println(conn);
			Statement sentencia = conn.createStatement();
			String update = "UPDATE personas SET edad = 28 WHERE nombre = 'jorge'";
			sentencia.executeUpdate(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
