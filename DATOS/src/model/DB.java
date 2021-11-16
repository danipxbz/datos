package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private String basedatos;
	private String login;
	private String password;
	private String url;
	private Connection conexion;
	
	
	public DB( String url, String basedatos, String login, String password) {
		this.basedatos = basedatos;
		this.login = login;
		this.password = password;
		this.url = url;
	}
	
	public DB() {
		
	}

	public String getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(String basedatos) {
		this.basedatos = basedatos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void conexionDB() throws SQLException {
		conexion=DriverManager.getConnection(this.url+this.basedatos, this.login,this.password);
	}

}
