/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.*/

//Recibe información: Scanner
import java.util.Scanner;

//Programa
public class CatalogoDeJuego {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeJuegos lista = new ListaDeJuegos(20);

    boolean salir = false;
        while (!salir) {

    //Bienvenida
    System.out.println("\n ~~~ CATÁLOGO DE JUEGOS DE MESA ~~~ ");
    System.out.println("\n   ¡Bienvenido al Catálogo! \nPara comenzar, selecciona una opción: \n");
    System.out.println(" 1.Registrar un nuevo juego. \n 2.Mostrar listado de juegos. \n 0.Salir.");
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        if (opcion == 1) { 
            System.out.print("~~ Nuevo Registro ~~ \nNombre del juego: ");
                String nombre = scanner.nextLine();
            System.out.print("Género: ");
                String genero = scanner.nextLine();
            System.out.print("Calificación (0-10): ");
                double calificacion = scanner.nextDouble();
            scanner.nextLine();

        JuegoDeMesa juego = new JuegoDeMesa(nombre, genero, calificacion);
            lista.agregarJuego(juego);
            System.out.println("\nJuego agregado correctamente.");

        } else if (opcion == 0) {
            System.out.println("¡Vuelva pronto!");
                salir = true;
        }

        else if (opcion ==2) {
            System.out.println("~~Mostrar Juegos~~ \nSelecciona una opción: ");
            System.out.println("1.Mostrar todos los Juegos. \n2.Mostrar ordenados por Nombre. \n3.Mostrar ordenados por Género. \n4.Mostrar ordenados por Calificación.");
            System.out.println("5.Mostrar el Mejor Calificado. \n6.Mostrar el Peor Calificado.");
                int opcion2 = scanner .nextInt();
                scanner.nextLine();

                if (opcion2 == 1) {
                    System.out.println(" ~ Lista de Juegos:");
                    lista.mostrarJuegos();

                } else if (opcion2 == 2) {
                    System.out.println(" ~ Lista por Nombre:");
                    lista.ordenarPorNombre();
                    lista.mostrarJuegos();
                
                } else if (opcion2 == 3) {
                    System.out.println(" ~ Lista por Género:");
                    lista.ordenarPorGenero();
                    lista.mostrarJuegos();

                } else if (opcion2 == 4) {
                    System.out.println(" ~ Lista por Calificación:");
                    lista.ordenarPorCalificacion();
                    lista.mostrarJuegos();

                } else if (opcion2 == 5) {
                    JuegoDeMesa mejor = lista.obtenerMejorCalificado();
                        if (mejor != null) {
                            System.out.println("\nMejor Calificado:\n" + mejor);
                        } else {
                            System.out.println("No hay juegos registrados.");
                        }

                } else if (opcion2 == 6) {
                    JuegoDeMesa peor = lista.obtenerPeorCalificado();
                        if (peor != null) {
                            System.out.println("\nPeor Calificado:\n" + peor);
                        } else {
                            System.out.println("No hay juegos registrados.");
                        }
                } else {
                    System.out.println("Opción inválida.");
                }

            }
        }
    
    scanner.close();

    }
}




