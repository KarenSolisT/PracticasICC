/* Creación de clase: Llanta.*/

public class Llanta {

	private String marca;
	private String tamanoRin;	
	private String tipoMaterial;
	private int costoMarca;
	private int costoTipoMaterial;

		public Llanta(String marca, String tamanoRin, String tipoMaterial, int costoMarca, int costoTipoMaterial){
			this.marca = marca; 
			this.tamanoRin = tamanoRin;
			this.tipoMaterial = tipoMaterial;
			this.costoMarca = obtenerCostoMarca(this.marca);
			this.costoTipoMaterial = obtenerCostoTipoMaterial(this.tipoMaterial);
	}


//Marcas de llantas
	public static final String FIRESTONE = "Firestone";
	public static final String PIRELLI = "Pirelli";
	public static final String MICHELIN = "Michelin";
	public static final String GOODYEAR = "Goodyear";
	public static final String YOKOHAMA = "Yokohama";

//Tipo de material del Rin
	public static final String ALUMINIO = "Aluminio";
	public static final String ACERO = "Acero";

//Tamaño de Rin
	public static final String[] RINESDISPONIBLES = {"Rin 15 \nRin 16 \nRin 17 \nRin 18"};
	public static final int COSTORINES = 0;

//Calculo costos
	public static int obtenerCostoMarca(String marca){
		if (marca.equals(FIRESTONE)) return 8000;
		if (marca.equals(PIRELLI)) return 6500;
		if (marca.equals(MICHELIN)) return 10000;
		if (marca.equals(GOODYEAR)) return 6000;
		if (marca.equals(YOKOHAMA)) return 5000;
		return 0;
	}
	public static int obtenerCostoTipoMaterial(String tipoMaterial){
		if (tipoMaterial.equals(ALUMINIO)) return 8000;
		if (tipoMaterial.equals(ACERO)) return 3000;
		return 0;
	}

	public int obtenerCostoRin(int tamanoRin){
		return 0;
	}
	
	public int obtenerCostoMarca(){
		return costoMarca;
	}

	public int obtenerCostoTipoMaterial(){
		return costoTipoMaterial;
	}



@Override
public String toString(){
	return "Llanta{" + "marca=" + marca + ", " + "tamanoRin=" + tamanoRin + ", " + "tipoMaterial=" + tipoMaterial + '}';
	
	}

}