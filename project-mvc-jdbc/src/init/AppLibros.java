package init;

import vista.MostrarLibros;
import modelo.Libros;
import vista.NuevoLibro;

public class AppLibros {

	public static void main(String[] args) throws Exception {
		
		MostrarLibros mostrar_libros = new MostrarLibros();
		// mostrar_libros.imprimirLista();
		
		NuevoLibro nuevo_libro = new NuevoLibro();
		Libros l = new Libros();
		l.setTitulo("Patron MVC");
		l.setAuthor("odiseoafcdev");
		l.setEditorial("undercode");
		
		nuevo_libro.createLibro(l);

	}

}
