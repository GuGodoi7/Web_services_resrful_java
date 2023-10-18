package br.com.fiap.megafarma.model.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory instace;
	private Connection conexao;
	private String url;
	private String user;
	private String pass;
	private String driver;
	
	public ConnectionFactory(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.driver = driver;
	}

	public static ConnectionFactory getInstace() {
		ConnectionFactory result = instace;
		if (result != null) {
			return result;
		}
		Properties prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./src/main/resource/application.properties ");
			prop.load(file);
			String url = prop.getProperty("datasource.url");
			String user = prop.getProperty("datasource.username ");
			String pass = prop.getProperty("datasource.password ");
			String driver = prop.getProperty("datasource.driver-class-name ");
			file.close();
			if (instace == null) {
				instace = new ConnectionFactory(url, user, pass, driver);
			}
			return instace;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	catch (IOException e) {
				System.out.println(e.getMessage());
			}
		return null;
	}

	public Connection getConexao() {
		try {
			if (this.conexao != null && !this.conexao.isClosed()) {
				return this.conexao;
			}
			if (getDriver() == null || this.getDriver().equals(" ")) {	
				System.out.println("Erro: nome da classe");
				throw new RuntimeException("Erro: nome da classe");
			}
			if (this.getUser() == null || this.getUser().equals("")) {
				System.out.println("Erro: usuario incorreto");
				throw new RuntimeException("Erro: usuario incorreto");
			}
			if (this.getUrl() == null || this.getUrl().equals("")) {
				System.out.println("Erro: url da conexao");
				throw new RuntimeException("Erro: url da conexao");
			}
			Class.forName(this.getDriver());
			this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(),this.getPass());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro nome da classe: " + e.getMessage());
		}  catch (SQLException e) {
			System.out.println("Erro de sql: " + e.getMessage());
		}
		return conexao;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getDriver() {
		return driver;
	}
	
	
	
}
