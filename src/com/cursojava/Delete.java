package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "abc123.";
		
		
		try (Connection conn = DriverManager.getConnection(conexion, user,  pwd);){
			System.out.println(conn);
			Statement sentencia = conn.createStatement();
			String insert = "INSERT INTO bdpersonas.personas (nombre, apellido, edad) VALUES ('pepe','gomez',20)";
			sentencia.executeUpdate(insert);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
