/* Creación de clase Sistema Electrónico*/

public class SistemaElectronico { 

	private String sistemaAudio;
	private boolean conEspejosElectricos;
	private boolean conSensorReversa;
	private boolean conCamaraReversa;

		public SistemaElectronico(String sistemaAudio, boolean conEspejosElectricos, boolean conSensorReversa, boolean conCamaraReversa){
			this.sistemaAudio = sistemaAudio;
			this.conEspejosElectricos = conEspejosElectricos;
			this.conSensorReversa = conSensorReversa;
			this.conCamaraReversa = conCamaraReversa;
		}

//Opciones del sistema de Audio:
	public static final String PANTALLA = "Pantalla";
	public static final String RADIO = "Radio"; 

//Calculo costos
	public static int costoSistemaAudio(String sistemaAudio) {
    	if (sistemaAudio.equals(PANTALLA)) return 3000;
    	if (sistemaAudio.equals(RADIO)) return 0;
    	return 0;
    }

	public static int costoConEspejosElectricos(boolean conEspejosElectricos){
    	return conEspejosElectricos ? 5000 : 0;
    }
    
    public static int costoConSensorReversa(boolean conSensorReversa){
    	return conSensorReversa ? 7000 : 0;
    }
	
	public static int costoConCamaraReversa(boolean conCamaraReversa){
    	return conCamaraReversa ? 4000 : 0;
    }


@Override
public String toString() {
	return "SistemaElectronico{" + "sistemaAudio=" + sistemaAudio + ", " + "conEspejosElectricos=" + (conEspejosElectricos ? "Si" : "No") + ", " + "conSensorReversa=" + (conSensorReversa ? "Si" : "No") + ", " + "conCamaraReversa=" + (conCamaraReversa ? "Si" : "No") + '}';

	}


}