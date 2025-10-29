/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Barco */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//Clase
public class Tablero {
    
//Atributos
    private char[][] tablero;
    private List<Barco> barcos;
    private int filas = 10;
    private int columnas = 10;

    //Constructores
        public Tablero() {
            tablero = new char[filas][columnas];
            barcos = new ArrayList<>();
            for (int i = 0; i < filas; i++) {
                Arrays.fill(tablero[i], '~');
        }
    }

    //Observadores
        public void mostrarTablero(boolean mostrarBarcos) {
                System.out.print("   ");
            for (int c = 1; c <= columnas; c++) {
                System.out.print(c + " ");
            }
            System.out.println();

            for (int f = 0; f < filas; f++) {
                System.out.printf("%2d ", f + 1);
                for (int c = 0; c < columnas; c++) {
                    char ch = tablero[f][c];
                    if (!mostrarBarcos && ch == '\u26F4') {
                        System.out.print("~ ");
                    } else {
                        System.out.print(ch + " ");
                    }
                }
                System.out.println();
            }
        }

        public boolean obtenerHundidos() {
            for (Barco b : barcos) {
                if (!b.seHundio()) return false;
            }
            return true;
        }

    //Modificadores
        public void colocarBarcosAleatorios() {
            int[] longitudes = {4, 3, 3, 2};
                Random rand = new Random();

            for (int l : longitudes) {
                boolean colocado = false;
                while (!colocado) {
                    int fila = rand.nextInt(filas);
                    int col = rand.nextInt(columnas);
                    boolean horizontal = rand.nextBoolean();
                    colocado = colocarBarco(fila, col, l, horizontal);
                }
            }
        }

        public boolean colocarBarco(int fila, int col, int longitud, boolean horizontal) {
            if (horizontal) {
                if (col + longitud > columnas) return false;
                    for (int c = col; c < col + longitud; c++) {
                        if (tablero[fila][c] != '~') return false;
                    }
                for (int c = col; c < col + longitud; c++) {
                    tablero[fila][c] = '\u26F4';
                }
            } else {
                if (fila + longitud > filas) return false;
                    for (int f = fila; f < fila + longitud; f++) {
                        if (tablero[f][col] != '~') return false;
                    }
                    for (int f = fila; f < fila + longitud; f++) {
                        tablero[f][col] = '\u26F4';
                    }
            }

            barcos.add(new Barco(fila, col, longitud, horizontal));
            return true;
        }

        public boolean recibirDisparo(int fila, int col) {
            if (tablero[fila][col] == '\u26F4') {
                    tablero[fila][col] = '\u2734'; 
                for (Barco b : barcos) {
                    if (b.posicion(fila, col)) {
                        b.agregarImpacto();
                    break;
                    }
                }
                return true;
            } else if (tablero[fila][col] == '~') {
                tablero[fila][col] = 'X'; 
            }
            return false;
        }

    
    //Calculadores
        public boolean disparoValido(int fila, int col) {
            return fila >= 0 && fila < filas && col >= 0 && col < columnas && tablero[fila][col] != 'X' && tablero[fila][col] != 'O';
        }
    

@Override
    public String toString() {
        String salida = "   ";
        for (int c = 0; c < columnas; c++) {
            salida += (c + 1) + " ";
        }
        salida += "\n";
        for (int f = 0; f < filas; f++) {
            salida += (f + 1) + "  ";
            for (int c = 0; c < columnas; c++) {
                salida += tablero[f][c] + " ";

            }
        salida += "\n";
        }
        return salida;
    }    
}
