package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		
		try (Connection conn = DriverManager.getConnection(conexion, "root", "abc123.");){
			System.out.println(conn);
			Statement sentencia = conn.createStatement();
			String insert = "DELETE FROM personas WHERE nombre = 'jorge'";
			sentencia.executeUpdate(insert);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
