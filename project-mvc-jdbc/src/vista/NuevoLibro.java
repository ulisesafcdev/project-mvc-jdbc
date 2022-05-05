package vista;

import java.sql.PreparedStatement;

import modelo.Libros;

public class NuevoLibro extends MostrarLibros{
	
	public void createLibro(Libros l) throws Exception{
		
		try {
			
			this.Conectar();
			String query = "INSERT INTO libros(titulo, author, editorial) VALUES(?,?,?)";
			PreparedStatement pstmt = this.getConn().prepareStatement(query);
			pstmt.setString(1, l.getTitulo());
			pstmt.setString(2, l.getAuthor());
			pstmt.setString(3, l.getEditorial());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			this.imprimirLista();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Desconectar();
		}
		
	}

}
