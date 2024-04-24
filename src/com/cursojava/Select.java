package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		
		try (Connection conn = DriverManager.getConnection(conexion, "root", "abc123.");){
			System.out.println(conn);
			Statement sentencia = conn.createStatement();
			String select = "SELECT * FROM personas WHERE nombre = 'jorge'";
			ResultSet rs = sentencia.executeQuery(select);
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellido"));
				System.out.println(rs.getString("edad"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
