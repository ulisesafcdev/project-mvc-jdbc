package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBBDD {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String database = "ejercicios";
	private String user = "root";
	private String pass = "ulisesafcdev";
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void Conectar() throws Exception{
		
		try {
			// Class.forName(driver);
			this.conn = DriverManager.getConnection(url, user, pass);
			
			if(this.conn != null) {
				System.out.println("Conectado Exitosamente...");
			} else {
				System.out.println("No se pudo conectar a la base de datos...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Desconectar() throws Exception{
		
		try {
			if(this.conn != null) {
				if(this.conn.isClosed() == false) {
					this.conn.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Error al desconectarse de la BBDD");
			e.printStackTrace();
		}
		
	}
	
}
