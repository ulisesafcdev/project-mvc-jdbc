package vista;

import java.sql.PreparedStatement;

public class NuevoLibro extends MostrarLibros{
	
	public void createLibro(String titulo, String author, String editorial) throws Exception{
		
		try {
			this.Conectar();
			
			String query = "INSERT INTO libros(titulo, author, editorial) VALUES(?,?,?)";
			
			PreparedStatement pstmt = this.getConn().prepareStatement(query);
			pstmt.setString(1, titulo);
			pstmt.setString(2, author);
			pstmt.setString(3, editorial);
			
			pstmt.executeUpdate();
			
			this.readLibros();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Desconectar();
		}
		
	}

}
