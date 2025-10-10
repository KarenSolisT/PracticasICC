/*Creación de clase Chasis*/

public class Chasis {
	
	private String coloresDisponibles;
	private String tipoAcabado;
	private int costoColor;
	private int costoTipoAcabado;

		public Chasis(String coloresDisponibles, String tipoAcabado){
			this.coloresDisponibles = coloresDisponibles;
			this.tipoAcabado = tipoAcabado;
			this.costoColor = obtenerCostoColor();
			this.costoTipoAcabado = obtenerCostoAcabado();
		}

//Color del chasis
	public static final String[] COLORESDISPONIBLES = {"Marrón \nOro \nGris \nBlanco \nRojo \nNegro \nVerde \nAzul \nAmarillo"};
	public static final int COSTOCOLOR = 0;

//Tipo de Acabado del color
	public static final String ACABADOMATE = "Mate";
	public static final String ACABADOBRILLANTE = "Brillante";
	public static final String ACABADOMETALICO = "Metálico";

//Cálculo de costos
	public static int obtenerCostoAcabado(String tipoAcabado){
		if (tipoAcabado.equals(ACABADOBRILLANTE)) return 10000;
		if (tipoAcabado.equals(ACABADOMETALICO)) return 15000;
		return 0;
	}

	public static int obtenerCostoColor(){
		return COSTOCOLOR;
	}

	public int obtenerCostoAcabado(){
		return obtenerCostoAcabado(this.tipoAcabado);
	}


@Override
public String toString() {
	return "Chasis{" + "coloresDisponibles=" + coloresDisponibles + ", "+ "tipoAcabado=" + tipoAcabado + '}';

	}

}