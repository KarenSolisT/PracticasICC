/* Alumna: Solís Torres Karen Rocío
Práctica 2. Uso de objetos.*/


// El programa necesita leer información dada por el usuario, por lo que se necesita la clase Scanner
import java.util.Scanner;

public class ProgramaBiblioteca {
	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

//Requiere que al inicio del programa como título se muestre el nombre de una biblioteca famosa.
//Requiere que todas las impresiones en pantalla tengan colores distintos.

	System.out.println(TextoColor.daColorTexto("\n¡Bienvenidos a la Biblioteca Central de la Universidad Nacional Autónoma de México!",TextoColor.AMARILLO));
	System.out.println(TextoColor.daColorTexto("\nIndica el número de la opción a realizar:", TextoColor.AZUL));
	System.out.println(TextoColor.daColorTexto("\n1. Registrar un libro.\n 2. Buscar un libro\n 3. Enlistar todos los libros", TextoColor.CYAN));

		int opcion = scanner.nextInt();
		scanner.nextLine();

// Registrar datos de un libro: ISBN (unico), título, autor, géneros literarios.

	if (opcion == 1){
		System.out.println(TextoColor.daColorTexto("~~Registro de Libros~~", TextoColor.MORADO));
		System.out.println("Ingresa el Título del Libro");
			String titulo = scanner.nextLine();
		System.out.println("Ingresa el Autor del Libro");
			String autor = scanner.nextLine();
		System.out.println("Ingresa el Género del Libro");
			String genero = scanner.nextLine();
		System.out.println("Ingresa el ISBN del Libro");
			String isbn = scanner.nextLine();	

		Libro nuevoLibro = new Libro(isbn, titulo, autor, genero);

//No se puede registrar un libro con ISBN ya existente en la biblioteca.

		Libro registrado = biblioteca.obtenLibroPorISBN(isbn);
		if (registrado != null) {
			System.out.println(TextoColor.daColorTexto("El ISBN ya fue registrado", TextoColor.ROJO));

    	} else {
        	boolean agregarLibro = biblioteca.agregaLibro(nuevoLibro);
        	if (agregarLibro) {
            System.out.println(TextoColor.daColorTexto("¡El libro fue registrado correctamente!", TextoColor.VERDE));
			} else {
			System.out.println(TextoColor.daColorTexto("No fue posible registrar el libro.", TextoColor.ROJO));
			}
		}
//Requiere buscar libros por autor, título o género literario según se elija uno de estos criterios a la vez.

}
	else if (opcion == 2) {
	
		System.out.println(TextoColor.daColorTexto("~~Busqueda de Libros~~", TextoColor.MORADO));
		System.out.println(TextoColor.daColorTexto("\nSelecciona una opción:", TextoColor.AZUL));
		System.out.println(TextoColor.daColorTexto("1. Buscar libro por ISBN.\n2. Buscar Autor.\n3. Buscar Título.\n4. Buscar por Género literario.", TextoColor.CYAN));
			int subOpcion = scanner.nextInt();
			scanner.nextLine();

		if (subOpcion == 1) {
			System.out.println("Ingresa el ISBN");
			String obtenISBN = scanner.nextLine();
			Libro libroEncontrado = biblioteca.obtenLibroPorISBN(obtenISBN);
				if (libroEncontrado != null){
					System.out.println(TextoColor.daColorTexto("Libro Encontrado:\n" + libroEncontrado.toString(), TextoColor.VERDE));
				} else { 
					System.out.println(TextoColor.daColorTexto("No se encontraron libros con el ISBN ingresado", TextoColor.ROJO));
				}
		} 
		else if (subOpcion == 2) {
			System.out.println("Ingresa el Autor");
			String obtenAutor = scanner.nextLine();
			String resultadosAutor = biblioteca.filtraPor("autor", obtenAutor, "");
		if (resultadosAutor != null && !resultadosAutor.isEmpty()) {
            System.out.println(TextoColor.daColorTexto("Libros encontrados:\n" + resultadosAutor, TextoColor.VERDE));
        } else {
            System.out.println(TextoColor.daColorTexto("No se encontraron libros del autor ingresado.", TextoColor.ROJO));
        	}
    	} 
		else if (subOpcion == 3) {
			System.out.print("Ingresa el Título ");
        	String obtenTitulo = scanner.nextLine();
        	String resultadosTitulo = biblioteca.filtraPor("titulo", obtenTitulo, "");
        	if (resultadosTitulo != null && !resultadosTitulo.isEmpty()) {
            	System.out.println(TextoColor.daColorTexto("Libros encontrados:\n" + resultadosTitulo, TextoColor.VERDE));
        	} else {
        	    System.out.println(TextoColor.daColorTexto ("No se encontraron libros con el título ingresado.", TextoColor.ROJO));
        	}
    	} 
		else if (subOpcion == 4) {
        	System.out.print("Ingresa el Género literario: ");
        	String obtenGenero = scanner.nextLine();
        	String resultadosGenero = biblioteca.filtraPor("genero", obtenGenero, "");
        if (resultadosGenero != null && !resultadosGenero.isEmpty()) {
            System.out.println(TextoColor.daColorTexto("Libros encontrados:\n" + resultadosGenero, TextoColor.VERDE));
        } else {
            System.out.println(TextoColor.daColorTexto("No se encontraron libros con el género ingresado.", TextoColor.ROJO));
        	}
		}
		else {
        	System.out.println(TextoColor.daColorTexto("Opción no válida para la búsqueda.", TextoColor.ROJO));
}
// Requiere poder listar todos los libros.

	}
	else if (opcion == 3) {
    	System.out.println(TextoColor.daColorTexto("~~ Lista de todos los libros registrados ~~", TextoColor.MORADO));
			String todosLosLibros = biblioteca.obtenTodosLosLibros("\n");
		if (todosLosLibros != null && !todosLosLibros.isEmpty()) {
    	    System.out.println(TextoColor.daColorTexto("No hay libros registrados en la biblioteca.", TextoColor.ROJO));
 		} else {
        	System.out.println(todosLosLibros);
    }
}

 else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}










