/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Juego de Mesa */

//Clase
public class JuegoDeMesa {

//Atributos
    private String nombre;
    private String genero;
    private double calificacion;

    //Constructores
        public JuegoDeMesa(String nombre, String genero, double calificacion){
            this.nombre = nombre;
            this.genero = genero;
            this.calificacion = calificacion;
        }

    //Observadores
        public String obtenerNombre() {
            return nombre;
        }

        public String obtenerGenero() {
            return genero;
        }
        
        public double obtenerCalificacion() {
            return calificacion;
        }

    //Modificadores
        public void asignarNombre(String nombre){
            this.nombre = nombre;
        }
        
        public void asignarGenero(String genero){
            this.genero = genero;
        }

        public void asignarCalificacion(double calificacion){
            this.calificacion = calificacion;
        }

    //toString
@Override
        public String toString(){
            return "Juego: " + nombre + "\nGénero: " + genero + "\nCalificación: " + calificacion;
        }
        
}