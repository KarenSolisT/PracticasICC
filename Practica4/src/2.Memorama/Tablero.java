/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Tablero */

//Se necesita colocar los pares aleatorios.
import java.util.Random;

//Clase
public class Tablero {

//Atributos
    private char [][] tableroInicial;      
    private boolean[][] descubierto;   
    private int filas;
    private int columnas;

    //Constructores;
        public Tablero(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
            tableroInicial = new char [filas][columnas];
            descubierto = new boolean[filas][columnas];
            iniciaTablero();
            
        }

    //Observadores:
        public void mostrarTablero(){
            System.out.print(this.toString());
        }
    
    //Modificadores
        public void descubrir(int fila, int col) {
            if (fila >= 0 && fila < filas && col >= 0 && col < columnas) {
                descubierto[fila][col] = true;
            }
        }
        
        public void cubrir(int fila, int col) {
            if (fila >= 0 && fila < filas && col >= 0 && col < columnas) {
                descubierto[fila][col] = false;
            }
        }
    //Calculadores
        public boolean estaCompleto() {
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    if (!descubierto[f][c]) {
                    return false;
                    }
                }
            }
            return true;
        }

        public char obtenerSimbolo(int fila, int col) {
        if (fila >= 0 && fila < filas && col >= 0 && col < columnas) {
            return tableroInicial[fila][col];
        }
        return ' ';
    }

//Tablero Inicial
    private void iniciaTablero() {
        char[] simbolos = {'#','#','$','$','%','%','&','&','?','?','+','+','@','@','¬','¬'};
    
    Random rand = new Random();
        for (int i = 0; i < simbolos.length; i++) {
            int j = rand.nextInt(simbolos.length);
            char temp = simbolos[i];
            simbolos[i] = simbolos[j];
            simbolos[j] = temp;
        }
    int k = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                tableroInicial[f][c] = simbolos[k];
                k++;
            }
        }
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
                if (descubierto[f][c]) {
                    salida += tableroInicial[f][c] + " ";
                } else {
                    salida += "* ";
                }
            }
            salida += "\n";
        }
        return salida;
    }
}

