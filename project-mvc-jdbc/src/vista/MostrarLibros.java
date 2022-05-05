package vista;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionBBDD;
import modelo.Libros;

public class MostrarLibros extends ConexionBBDD{
	
/*	public void readLibros() throws Exception{
		
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
		
	}*/
	
	private ArrayList<Libros> readLibros() throws Exception{
		
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		try {
			this.Conectar();
			String query = "SELECT * FROM libros";
			Statement stmt = this.getConn().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				Libros l = new Libros();
				l.setTitulo(rs.getString(1));
				l.setAuthor(rs.getString(2));
				l.setEditorial(rs.getString(3));
				
				lista.add(l);
				
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Desconectar();
		}
		
		return lista;
		
	}
	
	public void imprimirLista() throws Exception{
		
		readLibros().forEach(list -> {
			System.out.println("Titulo: \t" + list.getTitulo());
			System.out.println("Author: \t" + list.getAuthor());
			System.out.println("Editorial:\t" + list.getEditorial());
			System.out.println("...............................................");
		});
		
	}

}
