/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Barco */

//Clase
public class Barco {

//Atributos
    private int fila;
    private int columna;
    private int longitud;
    private boolean horizontal;
    private int impactos;

    //Constructores
        public Barco(int fila, int columna, int longitud, boolean horizontal) {
            this.fila = fila;
            this.columna = columna;
            this.longitud = longitud;
            this.horizontal = horizontal;
            this.impactos = 0;
        }

    //Observadores:
        public int obtenerFila() {
            return fila;
        }  
        
        public int obtenerColumna() {
            return columna;
        }

        public int obtenerLongitud() {
            return longitud;
        }

        public boolean esHorizontal() {
            return horizontal;
        }

        public boolean posicion(int f, int c) {
            if (horizontal) {
                return f == fila && c >= columna && c < columna + longitud;
            } else {
                return c == columna && f >= fila && f < fila + longitud;
            }
        }

        public boolean seHundio() {
            return impactos >= longitud;
        }

    //Modificadores
        public void agregarImpacto() {
            impactos++;
        }


@Override
    public String toString() {
        return "Barco{" + "fila:" + fila + ", columna:" + columna + ", longitud:" + longitud + ", horizontal:" + horizontal + ", impactos:" + impactos + ", Fue Hundido" + seHundio() + '}';
    }
    
}
