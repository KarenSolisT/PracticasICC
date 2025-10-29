/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Memorama */

//Recibe informacion: Scanner
import java.util.Scanner;


public class Memorama {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(4,4);

        int movimientos = 0;
        boolean juegoTerminado = false;

        System.out.println("\n~~~ JUEGO DE MEMORAMA ~~~");
        System.out.println("¡Bienvenido al Juego! \nEl objetivo del juego es encontrar todas las parejas de símbolos.\n \nInstrucciones: \nSelecciona las coordenadas de la carta que deseas descubrir. \nSi los simbolos coinciden, ¡Encontraste la pareja!\nSi no coinciden, ¡sigue intentandolo! \n¡Buena Suerte!\n");

        while (!juegoTerminado) {

            System.out.println(tablero);

        // Primer símbolo
                System.out.print("Selecciona una Fila: ");
                    int fila1 = scanner.nextInt() - 1;
                System.out.print("Selecciona una Columna: ");
                    int col1 = scanner.nextInt() - 1;
                    
                        if (fila1 < 0 || fila1 >= 4 || col1 < 0 || col1 >= 4) {
                            System.out.println("Coordenadas inválidas. Intenta de nuevo.\n");
                        continue;
                        }

            tablero.descubrir(fila1, col1);
            System.out.println(tablero);


        // Segundo símbolo
                System.out.print("Selecciona una Fila: ");
                    int fila2 = scanner.nextInt() - 1;
                System.out.print("Selecciona una Columna: ");
                    int col2 = scanner.nextInt() - 1;

                         if (fila2 < 0 || fila2 >= 4 || col2 < 0 || col2 >= 4) {
                            System.out.println("Coordenadas inválidas. Intenta de nuevo.\n");
                            tablero.cubrir(fila1, col1);
                        continue;
                        }

            tablero.descubrir(fila2, col2);
            System.out.println(tablero);

        //Comparar seleccion:
            char simbolo1 = tablero.obtenerSimbolo(fila1, col1);
            char simbolo2 = tablero.obtenerSimbolo(fila2, col2);

                movimientos++;

            if (simbolo1 == simbolo2 && !(fila1 == fila2 && col1 == col2)) {
                System.out.println("\n¡Pareja Encontrada!\n");
            } else {
                System.out.println("\n¡No coinciden! Intenta de nuevo.\n");
                    tablero.cubrir(fila1, col1);
                    tablero.cubrir(fila2, col2);
            }

        //Verificar juego completo
            if (tablero.estaCompleto()) {
                juegoTerminado = true;
            }
        }

        System.out.println("\n     ~~¡Felicidades!~~ \n¡Has completado el juego!");
        System.out.println("Total de Movimientos Realizados: " + movimientos);

        scanner.close();
    }

}