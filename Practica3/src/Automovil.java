/* Creación de clase: Automóvil.*/

public class Automovil {

	private String tipoAutomovil;
	private String tipoTransmision;
	private String tipoFrenos;
	private int anio;
	private boolean conPeliculaAntiasalto;
	private int costo;

		public Automovil(String tipoAutomovil, String tipoTransmision, String tipoFrenos, int anio, boolean conPeliculaAntiasalto, int costo){
			this.tipoAutomovil = tipoAutomovil;
			this.tipoTransmision = tipoTransmision;
			this.tipoFrenos = tipoFrenos;
			this.anio = anio;
			this.conPeliculaAntiasalto = conPeliculaAntiasalto;
			this.costo = calcularCosto();

		}

//Tipos de Automóvil
	public static final String TIPOCOMPACTO = "Compacto";
	public static final String TIPOSEMICOMPACTO = "Semi-Compacto";
	public static final String TIPOSEDAN = "Sedán";
	public static final String TIPODEPORTIVO = "Deportivo";

//Tipo de Transmisión
	public static final String TRANSMISIONMANUAL = "Manual";
	public static final String TRANSMISIONAUTOMATICA = "Automática";

//Tipo de Frenos
	public static final String FRENODISCO = "Disco";
	public static final String FRENOTAMBOR = "Tambor";

//Año 
	public static final int ANIO2023 = 2023;
	public static final int ANIO2024 = 2024;
	public static final int ANIO2025 = 2025;

//Calculo de Costos
	public static int costoTipoAutomovil(String tipoAutomovil) {
        if (tipoAutomovil.equals(TIPOCOMPACTO)) return 40000;
        if (tipoAutomovil.equals(TIPOSEMICOMPACTO)) return 80000;
        if (tipoAutomovil.equals(TIPOSEDAN)) return 120000;
        if (tipoAutomovil.equals(TIPODEPORTIVO)) return 200000;
        return 0;
    }

    public static int costoTipoTransmision(String tipoTransmision) {
    	if (tipoTransmision.equals(TRANSMISIONMANUAL)) return 40000;
    	if (tipoTransmision.equals(TRANSMISIONAUTOMATICA)) return 80000;
    	return 0;
    }

    public static int costoTipoFrenos(String tipoFrenos) {
    	if (tipoFrenos.equals(FRENODISCO)) return 3200;
    	if (tipoFrenos.equals(FRENOTAMBOR)) return 2100;
    	return 0;
    }

    public static int costoAnio(int anio) {
    	if (anio == ANIO2023) return 30000;
    	if (anio == ANIO2024) return 40000;
    	if (anio == ANIO2025) return 50000;
    	return 0;
    }

    public static int costoConPeliculaAntiasalto(boolean conPeliculaAntiasalto){
    	return conPeliculaAntiasalto ? 40000 : 0;
    }

    
    public int obtenerCostoTipoAutomovil(){
    	return costoTipoAutomovil(this.tipoAutomovil);
    }

    public int obtenerCostoTipoTransmision(){
    	return costoTipoTransmision(this.tipoTransmision);
    }

    public int obtenerCostoTipoFrenos(){
    	return costoTipoFrenos(this.tipoFrenos);
    }

    public int obtenerCostoAnio(){
    	return costoAnio(this.anio);
    }

    public int calcularCosto() {
		return costoTipoAutomovil(tipoAutomovil) + costoTipoTransmision(tipoTransmision) + costoTipoFrenos(tipoFrenos) + costoAnio(anio) + costoConPeliculaAntiasalto(conPeliculaAntiasalto);
	}

	public int obtenerCosto() {
		return costo;
	}


@Override
public String toString(){
	return "Automovil{" + "tipoAutomovil=" + tipoAutomovil + ", " + "tipoTransmision=" + tipoTransmision + ", " + "tipoFrenos=" + tipoFrenos + ", " + "anio=" + anio + ", " + "conPeliculaAntiasalto=" + (conPeliculaAntiasalto ? "Si" : "No") +  '}';
	
	}
}