package br.com.fiap.megafarma.model.repository;

import java.sql.Connection;

public abstract class Repository {
	protected static Connection connection;

	public Repository() {
		
	}

	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstace().getConexao();
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void closeConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
