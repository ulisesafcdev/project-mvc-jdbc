package vista;

import java.sql.ResultSet;
import java.sql.Statement;

import controlador.ConexionBBDD;

public class MostrarLibros extends ConexionBBDD{
	
	public void readLibros() throws Exception{
		
		try {
			this.Conectar();
			
			String query = "SELECT * FROM libros";
			
			Statement stmt = this.getConn().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("\t..:::..LIBROS..:::..\n");
			
			while(rs.next()) {
				
				System.out.println("Titulo: \t" + rs.getString(1));
				System.out.println("Author: \t" + rs.getString(2));
				System.out.println("Editorial:\t" + rs.getString(3));
				System.out.println("----------------------------------------------");
				
			}
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Desconectar();
		}
		
	}

}
