package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prepared {

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "abc123.";
		String query = "SELECT * FROM personas WHERE edad < ?;";
		int valor = 25;

		try (Connection conn = DriverManager.getConnection(conexion, user, pwd);
				PreparedStatement ps = conn.prepareStatement(query);) {
			System.out.println(conn);
			ps.setInt(1, valor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellido"));
				System.out.println(rs.getString("edad"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
