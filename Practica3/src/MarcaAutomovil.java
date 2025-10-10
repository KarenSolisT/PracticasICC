/* Creación de la clase "Marca Automóvil"*/

public class MarcaAutomovil{
	
	private String marcaAutomovil;
	private String paisOrigen;
	private int costoImportacion;

		public MarcaAutomovil(String marcaAutomovil, String paisOrigen) {
			this.marcaAutomovil = marcaAutomovil;
			this.paisOrigen = paisOrigen;
			this.costoImportacion = obtenerCostoImportacion(marcaAutomovil, paisOrigen);
		}

//Marca del automóvil
	public static final String MARCAHONDA = "Honda";
	public static final String MARCABYD = "BYD";
	public static final String MARCAVOLKSWAGEN = "Volkswagen";
	public static final String MARCATOYOTA = "Toyota";
	public static final String MARCANISSAN = "Nissan";

//País de origen
	public static final String[] PAISORIGENHONDA = new String[] {"México", "Japón", "India"};
	public static final String[] PAISORIGENBYD = new String[] {"China"};
	public static final String[] PAISORIGENVOLKSWAGEN = new String[] {"México", "Alemania", "China", "Brasil"};
	public static final String[] PAISORIGENTOYOTA = new String[] {"México", "Estados Unidos", "Brasil", "Francia"};
	public static final String[] PAISORIGENNISSAN = new String[] {"México", "Japón"};

//Calculo del costo de importación
	public static int obtenerCostoImportacion(String marca, String paisOrigen){
		if (marca.equals("Honda")) return costoHonda(paisOrigen);
		if (marca.equals("BYD")) return costoBYD(paisOrigen);
		if (marca.equals("Volkswagen")) return costoVolkswagen(paisOrigen);
		if (marca.equals("Toyota")) return costoToyota(paisOrigen);
		if (marca.equals("Nissan")) return costoNissan(paisOrigen);
		return 0;
	}

	private static int costoHonda(String paisOrigen) {
        if (paisOrigen.equals("México")) return 25000;
        if (paisOrigen.equals("Japón")) return 105000;
        if (paisOrigen.equals("India")) return 55000;
        return 0;
    }

    private static int costoBYD(String paisOrigen) {
        return 30000;
    }

	private static int costoVolkswagen(String paisOrigen) {
        if (paisOrigen.equals("México")) return 15000;
        if (paisOrigen.equals("Alemania")) return 80000;
        if (paisOrigen.equals("China")) return 32000;
        if (paisOrigen.equals("Brasil")) return 42000;
        return 0;
    }

    private static int costoToyota(String paisOrigen) {
        if (paisOrigen.equals("México")) return 20000;
        if (paisOrigen.equals("Estados Unidos")) return 40000;
        if (paisOrigen.equals("Brasil")) return 40000;
        if (paisOrigen.equals("Francia")) return 90000;
        return 0;
    }

    private static int costoNissan(String paisOrigen) {
        if (paisOrigen.equals("Japón")) return 100000;
        if (paisOrigen.equals("México")) return 18000;
        return 0;
    }    

//Obtener valores
    public String obtenerMarcaAutomovil() {
    	return marcaAutomovil;
    }

    public String obtenerPaisOrigen() {
    	return paisOrigen;
    }

    public int obtenerCostoImportacion() {
    	return costoImportacion;
    }

@Override 
public String toString() {
	return "MarcaAutomovil{" + "marcaAutomovil=" + marcaAutomovil + ", " + "paisOrigen=" + paisOrigen + ", " + "costoImportacion=" + costoImportacion +'}';


	}


}


