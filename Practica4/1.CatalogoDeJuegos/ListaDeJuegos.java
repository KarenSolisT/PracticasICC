/* Alumna: Solis Torres Karen Rocio
Practica 4. Arreglos.
Creación de clase: Juego de Mesa */

//Clase
public class ListaDeJuegos {

//Atributos
    private JuegoDeMesa[] lista;
    private int cantidad;

    //Constructores
        public ListaDeJuegos(int capacidad){
           lista = new JuegoDeMesa[capacidad];
           cantidad = 0;
        }

    //Observadores
        public void mostrarJuegos() {
            System.out.println(this.toString());    
        }

    //Modificadores
        public void agregarJuego(JuegoDeMesa juego){
            if (cantidad < lista.length) { 
                lista[cantidad] = juego;
                cantidad++;
            } else { 
                System.out.println("¡Cátalogo Lleno!\nNo es posible agregar más Juegos.");
            }
        }
        
    //Calculadores (Ordenar:BubbleSort)
        public void ordenarPorNombre() {
            for (int i = 0; i < cantidad - 1; i++){
                for (int j = 0; j < cantidad - i - 1; j++) {
                    if (lista[j].obtenerNombre().compareTo(lista[j + 1].obtenerNombre()) > 0) {
                        JuegoDeMesa temp = lista [j];
                        lista[j] = lista[j + 1];
                        lista[j + 1] = temp;
                    }
                }
            }
        }
        
        public void ordenarPorGenero() { 
            for (int i  = 0; i < cantidad - 1; i++) {
                for (int j = 0; j < cantidad - i - 1; j++) {
                    if (lista[j].obtenerGenero().compareTo(lista[j + 1].obtenerGenero()) > 0) {
                        JuegoDeMesa temp = lista[j];
                        lista[j] = lista[j + 1];
                        lista[j + 1] = temp;
                    }
                }
            }
        }

        public void ordenarPorCalificacion() {
            for (int i = 0; i < cantidad - 1; i++){
                for (int j = 0; j < cantidad - i - 1; j++) {
                    if (lista[j].obtenerCalificacion() > lista[j + 1].obtenerCalificacion()) {
                        JuegoDeMesa temp = lista[j];
                        lista[j] = lista[j + 1];
                        lista[j + 1] = temp;
                    }

                }
            }
        }

        public JuegoDeMesa obtenerMejorCalificado() {
            if (cantidad == 0) { 
                return null;
            }
            
            JuegoDeMesa mejor = lista[0];
                for (int i = 1; i < cantidad; i++) {
                    if (lista[i].obtenerCalificacion() > mejor.obtenerCalificacion()) {
                    mejor = lista[i];
                }
            }
                return mejor;
        }

        public JuegoDeMesa obtenerPeorCalificado() {
            if (cantidad == 0) { 
                return null;
            }

            JuegoDeMesa peor = lista[0];
                for (int i = 1; i < cantidad; i++) {
                    if (lista[i].obtenerCalificacion() < peor.obtenerCalificacion()) {
                    peor = lista[i];
                }
            }
                return peor;
        }



@Override
    public String toString() {
        if (cantidad == 0) {
            return "¡No existen juegos registrados!";    
        }
        
        String salida = "";
        for (int i = 0; i < cantidad; i++) {
            salida += lista[i].toString() + "\n";
        }
            return salida;
    }

}