/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Batalla Naval */

import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\n~~~ BATALLA NAVAL ~~~");
        System.out.println("\n¡Bienvenido al Juego: Batalla Naval!\n \nIndicaciones: \nCuentas con: \n1 Tablero 10 x 10. \n1 Barco de longitud 4. \n2 Barcos de longitud 3. \n1 barco de longitud 2. \nDebes colocar los barcos sin salir del tablero, eligiendo las filas y columnas del 1 al 10.");
        System.out.println("Una vez realizado, elige las coordenadas en las que piensas que se encuentra el Barco de la IA. \nEl primero en hundir los barcos del otro, ¡Será el Ganador!\n");

        Tablero jugador = new Tablero();
        Tablero ia = new Tablero();
        ia.colocarBarcosAleatorios();

        int[] longitudes = {4, 3, 3, 2};
        for (int l : longitudes) {
            boolean colocado = false;
            while (!colocado) {
                jugador.mostrarTablero(true);
                    System.out.print("\nElige la ubicacion del Barco de longitud " + l + ":\n");
                    System.out.print("Fila inicial: ");
                        int fila = scanner.nextInt() - 1;
                    System.out.print("Columna inicial: ");
                        int col = scanner.nextInt() - 1;
                    System.out.print("¿Quieres que este Horizontal? (Si/No): ");
                        boolean horizontal = scanner.next().equals("Si");

                if (jugador.colocarBarco(fila, col, l, horizontal)) {
                    System.out.println("Barco colocado correctamente.\n");
                        colocado = true;
                } else {
                    System.out.println("No es posible colocar el Barco ahí. \nIntenta otra posición.\n");
                }
            }
        }

        System.out.println("\n¡Los Barcos han sido colocados correctamente! \n¡Comencemos!");
    

        boolean turnoJugador = rand.nextBoolean();
        System.out.println(turnoJugador ? "Tienes el primero turno.\n" : "La IA tiene el primer turno.\n");

        boolean juegoTerminado = false;
            while (!juegoTerminado) {
                if (turnoJugador) {
                    System.out.println("Es tu turno de atacar: \nTu tablero:");
                        jugador.mostrarTablero(true);
                    System.out.println("\nTablero de la IA:");
                        ia.mostrarTablero(false);
                    System.out.print("\nSelecciona fila a disparar (1-10): ");
                        int fila = scanner.nextInt() - 1;
                    System.out.print("Selecciona columna a disparar (1-10): ");
                        int col = scanner.nextInt() - 1;

                    if (!ia.disparoValido(fila, col)) {
                        System.out.println("¡Disparo inválido!. Intenta de nuevo.");
                        continue;
                    } 
                    
                    boolean acierto = ia.recibirDisparo(fila, col); 
                        System.out.println(acierto ? "¡Le Diste!" : "¡Fallaste!");
                    
                    if (ia.obtenerHundidos()) {
                        System.out.println("\n¡Has hundido todos los barcos enemigos! \n¡Felicidades, Ganaste!");
                    break;
                    }
                } else {
                    int fila, col;
                        do {
                            fila = rand.nextInt(10);
                            col = rand.nextInt(10);
                        } while (!jugador.disparoValido(fila, col));

                            boolean acierto = jugador.recibirDisparo(fila, col);
                                System.out.println(acierto ? "\n¡Te han dado en (" + (fila+1) + "," + (col+1) + ")!" :
                                           "\n¡La IA Fallo en (" + (fila+1) + "," + (col+1) + ")!");
                    if (jugador.obtenerHundidos()) {
                        System.out.println("\n¡Has perdido! \n ¡La IA ha hundido tus barcos! \n¡Suerte para la próxima! ");
                        juegoTerminado = true;
                    }
                }

                turnoJugador = !turnoJugador;
            }

        scanner.close();
    }
}
