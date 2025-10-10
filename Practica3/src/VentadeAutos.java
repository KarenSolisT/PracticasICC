/*Alumna: Solís Torres Karen Rocío
Práctica 3. Objetos como Atributos*/

//Recibe informacion: Scanner
import java.util.Scanner;

public class VentadeAutos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//Bienvenida
	System.out.println(TextoColor.daColorTexto("\n ~~~ AUTO SALES PREMIER ~~~ ", TextoColor.CYAN));
	System.out.println(TextoColor.daColorTexto("\n¡Bienvenido a nuestro sistema de Compra de Autos!\n Aquí podrás elegir el Automóvil perfecto para ti,\n  ¡Solo sigue las indicaciones y selecciona las mejores opciones\n   deacuerdo a tu preferencia y presupuesto!.", TextoColor.AZUL));

//Elección de marca y país de origen
	System.out.println("\n - Para comenzar, selecciona la marca del Automóvil: \n~Honda \n~BYD \n~Volkswagen \n~Toyota \n~Nissan");
		System.out.println("\n Marca: ");
		String marca = scanner.nextLine();

			String[] paisesDisponibles = new String[0];
				if (marca.equals("Honda")){
					paisesDisponibles = MarcaAutomovil.PAISORIGENHONDA; 
				} else if (marca.equals("BYD")) {
					paisesDisponibles = MarcaAutomovil.PAISORIGENBYD;
				} else if (marca.equals("Volkswagen")){
					paisesDisponibles = MarcaAutomovil.PAISORIGENVOLKSWAGEN;
				} else if (marca.equals("Toyota")){
					paisesDisponibles = MarcaAutomovil.PAISORIGENTOYOTA;
				} else if (marca.equals("Nissan")){
					paisesDisponibles = MarcaAutomovil.PAISORIGENNISSAN;
				} else {
					System.out.println("Selección inválida, intente nuevamente");
					return;
				}

		System.out.println("\n Países de origen y costo de importación disponibles para " + marca + ":");
        	for (int i = 0; i < paisesDisponibles.length; i++) {
        		String paisOrigen = paisesDisponibles[i];
        		int calcularCosto = MarcaAutomovil.obtenerCostoImportacion(marca, paisOrigen);
            		System.out.println((i + 1) + ". " + paisOrigen + " - $" + String.format("%,d", calcularCosto));
            	}

        System.out.println("\n - Seleccione el país de origen de su preferencia: ");
        	String paisOrigenSeleccionado = scanner.nextLine();


//Costo actual
        	MarcaAutomovil seleccionMarca = new MarcaAutomovil(marca, paisOrigenSeleccionado);
        	int costoTotal = seleccionMarca.obtenerCostoImportacion();

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del Tipo de Transmisión
	System.out.println("\n - Selecciona el Tipo de Transmisión");
		System.out.println(Automovil.TRANSMISIONMANUAL + " - $" + String.format("%,d", Automovil.costoTipoTransmision(Automovil.TRANSMISIONMANUAL)));
		System.out.println(Automovil.TRANSMISIONAUTOMATICA + " - $" + String.format("%,d", Automovil.costoTipoTransmision(Automovil.TRANSMISIONAUTOMATICA)));
		
			String tipoTransmision = scanner.nextLine();

//Costo actual
        	int costoTipoTransmision = Automovil.costoTipoTransmision(tipoTransmision);
        	costoTotal += costoTipoTransmision;

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del Tipo de Automóvil
       	System.out.println("\n - Selecciona el Tipo de Auto");
		System.out.println(Automovil.TIPOCOMPACTO + " - $" + String.format("%,d", Automovil.costoTipoAutomovil(Automovil.TIPOCOMPACTO)));
		System.out.println(Automovil.TIPOSEMICOMPACTO + " - $" + String.format("%,d", Automovil.costoTipoAutomovil(Automovil.TIPOSEMICOMPACTO)));
		System.out.println(Automovil.TIPOSEDAN + " - $" + String.format("%,d", Automovil.costoTipoAutomovil(Automovil.TIPOSEDAN)));
		System.out.println(Automovil.TIPODEPORTIVO + " - $" + String.format("%,d", Automovil.costoTipoAutomovil(Automovil.TIPODEPORTIVO)));

			String tipoAutomovil = scanner.nextLine();

//Costo actual
			int costoTipoAutomovil = Automovil.costoTipoAutomovil(tipoAutomovil);
			costoTotal += costoTipoAutomovil;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del Año
        System.out.println("\n - Selecciona el Año del automóvil\n");
		System.out.println(Automovil.ANIO2023 + " - $" + String.format("%,d", Automovil.costoAnio(Automovil.ANIO2023)));
		System.out.println(Automovil.ANIO2024 + " - $" + String.format("%,d", Automovil.costoAnio(Automovil.ANIO2024)));
		System.out.println(Automovil.ANIO2025 + " - $" + String.format("%,d", Automovil.costoAnio(Automovil.ANIO2025)));

			int anioSeleccionado = scanner.nextInt();
			scanner.nextLine();

//Costo actual
			int costoExtraAnio = Automovil.costoAnio(anioSeleccionado);
			costoTotal += costoExtraAnio;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del color del Chasis 
	System.out.println("\n Colores del Chasis Disponibles (sin costo)");
		for (String color : Chasis.COLORESDISPONIBLES){
			System.out.println(color);
		}
	System.out.println("\n - Seleccione color de su preferencia: ");
		String colorSeleccionado = scanner.nextLine();

//Costo actual
		int costoColor = Chasis.obtenerCostoColor();
		costoTotal += costoColor;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del acabado del Chasis
	System.out.println("\n - Selecciona el Tipo de Acabado del Chasis");
		System.out.println(Chasis.ACABADOMATE + " - $" + String.format("%,d", Chasis.obtenerCostoAcabado(Chasis.ACABADOMATE)));
		System.out.println(Chasis.ACABADOBRILLANTE + " - $" + String.format("%,d", Chasis.obtenerCostoAcabado(Chasis.ACABADOBRILLANTE)));
		System.out.println(Chasis.ACABADOMETALICO + " - $" + String.format("%,d", Chasis.obtenerCostoAcabado(Chasis.ACABADOMETALICO)));

			String tipoAcabado = scanner.nextLine();

//Costo actual
		int costoTipoAcabado = Chasis.obtenerCostoAcabado(tipoAcabado);
		costoTotal += costoTipoAcabado;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección Ventanas con película antiasalto
	System.out.println("\n - ¿Deseas colocar una película antiasalto en los vidrios? (Sí/No)");
		System.out.println("Costo adicional :  $" + String.format("%,d", Automovil.costoConPeliculaAntiasalto(true)));
		
			String seleccionPeliculaAntiasalto = scanner.nextLine();
			boolean conPeliculaAntiasalto = seleccionPeliculaAntiasalto.equals("Sí");

//Costo actual
        	int costoPelicula = Automovil.costoConPeliculaAntiasalto(conPeliculaAntiasalto);
        	costoTotal += costoPelicula;

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección de la marca de las llantas
        System.out.println("\n - Selecciona la marca de Llantas de tu preferencia:\n");
		System.out.println(Llanta.FIRESTONE + " - $" + String.format("%,d", Llanta.obtenerCostoMarca(Llanta.FIRESTONE)));
		System.out.println(Llanta.PIRELLI + " - $" + String.format("%,d", Llanta.obtenerCostoMarca(Llanta.PIRELLI)));
		System.out.println(Llanta.MICHELIN + " - $" + String.format("%,d", Llanta.obtenerCostoMarca(Llanta.MICHELIN)));
		System.out.println(Llanta.GOODYEAR + " - $" + String.format("%,d", Llanta.obtenerCostoMarca(Llanta.GOODYEAR)));
		System.out.println(Llanta.YOKOHAMA + " - $" + String.format("%,d", Llanta.obtenerCostoMarca(Llanta.YOKOHAMA)));

			String seleccionMarcaLlantas = scanner.nextLine();
		
//Costo actual
			int costoMarcaLlantas = Llanta.obtenerCostoMarca(seleccionMarcaLlantas);
			costoTotal += costoMarcaLlantas;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del tamaño del Rin 
	System.out.println("\n Tamaños de Rin Disponibles (sin costo)");
		for (String tamanoRin  : Llanta.RINESDISPONIBLES){
			System.out.println(tamanoRin);
		}
	System.out.println("\n - Seleccione el tamaño de su preferencia: ");
			
		String tamanoRinSeleccionado = scanner.nextLine();

//Costo actual
		int costoTamanoRin = Llanta.COSTORINES;
		costoTotal += costoTamanoRin;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del material del Rin
        System.out.println("\n - Selecciona el Material del Rin de tu preferencia:\n");
		System.out.println(Llanta.ALUMINIO + " - $" + String.format("%,d", Llanta.obtenerCostoTipoMaterial(Llanta.ALUMINIO)));
		System.out.println(Llanta.ACERO + " - $" + String.format("%,d", Llanta.obtenerCostoTipoMaterial(Llanta.ACERO)));
		
			String seleccionTipoMaterial = scanner.nextLine();
		
//Costo actual
			int costoTipoMaterial = Llanta.obtenerCostoTipoMaterial(seleccionTipoMaterial);
			costoTotal += costoTipoMaterial;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del tipo de Freno
        System.out.println("\n - Selecciona el tipo de Frenos de tu preferencia:\n");
		System.out.println(Automovil.FRENODISCO + " - $" + String.format("%,d", Automovil.costoTipoFrenos(Automovil.FRENODISCO)));
		System.out.println(Automovil.FRENOTAMBOR + " - $" + String.format("%,d", Automovil.costoTipoFrenos(Automovil.FRENOTAMBOR)));
		
			String seleccionTipoFreno = scanner.nextLine();
		
//Costo actual
			int costoTipoFreno = Automovil.costoTipoFrenos(seleccionTipoFreno);
			costoTotal += costoTipoFreno;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección del Sistema de Audio
        System.out.println("\n - Selecciona el Sistema de Audio de tu preferencia:\n");
		System.out.println(SistemaElectronico.RADIO + " - $" + String.format("%,d", SistemaElectronico.costoSistemaAudio(SistemaElectronico.RADIO)));
		System.out.println(SistemaElectronico.PANTALLA + " - $" + String.format("%,d", SistemaElectronico.costoSistemaAudio(SistemaElectronico.PANTALLA)));
		
			String seleccionAudio = scanner.nextLine();
		
//Costo actual
			int costoAudio = SistemaElectronico.costoSistemaAudio(seleccionAudio);
			costoTotal += costoAudio;

			System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección espejos electrico
	System.out.println("\n - ¿Deseas que los Espejos sean Eléctricos? (Sí/No)");
		System.out.println("Costo adicional :  $" + String.format("%,d", SistemaElectronico.costoConEspejosElectricos(true)));
		
			String seleccionEspejos = scanner.nextLine();
			boolean conEspejosElectricos = seleccionEspejos.equals("Sí");

//Costo actual
        	int costoEspejos = SistemaElectronico.costoConEspejosElectricos(conEspejosElectricos);
        	costoTotal += costoEspejos;

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección sensor reversa
	System.out.println("\n - ¿Deseas que el automóvil tenga Sensor de Reversa? (Sí/No)");
		System.out.println("Costo adicional :  $" + String.format("%,d", SistemaElectronico.costoConSensorReversa(true)));
		
			String seleccionSensor = scanner.nextLine();
			boolean conSensorReversa = seleccionSensor.equals("Sí");

//Costo actual
        	int costoSensor = SistemaElectronico.costoConSensorReversa(conSensorReversa);
        	costoTotal += costoSensor;

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Elección cámara de reversa
	System.out.println("\n - ¿Deseas que el automóvil tenga Cámara de Reversa? (Sí/No)");
		System.out.println("Costo adicional :  $" + String.format("%,d", SistemaElectronico.costoConCamaraReversa(true)));
		
			String seleccionCamara = scanner.nextLine();
			boolean conCamaraReversa = seleccionCamara.equals("Sí");

//Costo actual
        	int costoCamara = SistemaElectronico.costoConCamaraReversa(conCamaraReversa);
        	costoTotal += costoCamara;

        		System.out.println(TextoColor.daColorTexto("\n ~ Resumen actual de Compra ~ ", TextoColor.AMARILLO));
        		System.out.println(TextoColor.daColorTexto("	Costo actual : $" + String.format("%,d", costoTotal), TextoColor.AMARILLO));

//Mostrar Selecciones y Costos

		System.out.println(TextoColor.daColorTexto("\n ~ Resumen Total de Compra ~ ", TextoColor.VERDE));
        	System.out.println("Marca seleccionada        : " + seleccionMarca.obtenerMarcaAutomovil() + "\n" + "País de Origen            : " + seleccionMarca.obtenerPaisOrigen() + "\n" + "Costo de Importación      : $" + String.format("%,d", seleccionMarca.obtenerCostoImportacion()));
        	System.out.println("Tipo de Transmisión       : " + tipoTransmision + "\n" + "Costo por Transmisión     : $" + String.format("%,d", costoTipoTransmision));        		
        	System.out.println("Tipo de Automóvil         : " + tipoAutomovil + "\n" + "Costo por Tipo de Auto    : $" + String.format("%,d", costoTipoAutomovil));        		
        	System.out.println("Año                       : " + anioSeleccionado + "\n" + "Costo Extra por Año       : $" + String.format("%,d", costoExtraAnio));
        	System.out.println("Color del Chasis          : " + colorSeleccionado + "\n" + "Costo por Selección       : $" + String.format("%,d,", costoColor));
        	System.out.println("Acabado del Chasis        : " + tipoAcabado + "\n" + "Costo por Tipo de Acabado : $" + String.format("%,d", costoTipoAcabado));        		
        	System.out.println("Película Antiasalto       : " + (conPeliculaAntiasalto ? "Sí" : "No") + "\n" + "Costo por Película        : $" + String.format("%,d", costoPelicula));
        	System.out.println("Marca de las Llantas      : " + seleccionMarcaLlantas + "\n" + "Costo por Marca de Llantas: $" + String.format("%,d", costoMarcaLlantas));        		
        	System.out.println("Tamaño del Rin            : " + tamanoRinSeleccionado + "\n" + "Costo por Tamaño del Rin  : $" + String.format("%,d", costoTamanoRin));
        	System.out.println("Material del Rin          : " + seleccionTipoMaterial + "\n" + "Costo por Material del Rin: $" + String.format("%,d", costoTipoMaterial));
        	System.out.println("Tipo de Frenos            : " + seleccionTipoFreno + "\n" + "Costo por Tipo de Frenos  : $" + String.format("%,d", costoTipoFreno));        		
        	System.out.println("Sistema de Audio          : " + seleccionAudio + "\n" + "Costo por Sistema de Audio: $" + String.format("%,d", costoAudio));        		
		System.out.println("Espejos Eléctricos        : " + (conEspejosElectricos ? "Sí" : "No") + "\n" + "Costo por Espejos         : $" + String.format("%,d", costoEspejos));
	 	System.out.println("Sensor de Reversa         : " + (conSensorReversa ? "Sí" : "No") + "\n" + "Costo por Sensor          : $" + String.format("%,d", costoSensor));
	 	System.out.println("Cámara de Reversa         : " + (conCamaraReversa ? "Sí" : "No") + "\n" + "Costo por Cámara          : $" + String.format("%,d", costoCamara));		
        	System.out.println(TextoColor.daColorTexto("               Costo Total: $" + String.format("%,d", costoTotal), TextoColor.VERDE));

//Selección final del usuario
        	System.out.print("\n¿Desea comprar el Automóvil? (Sí/No): ");
			String respuesta = scanner.nextLine();

		if (respuesta.equals("Sí")) {
		System.out.println(TextoColor.daColorTexto("\n ¡Gracias por su compra!\n¡Nuestros agentes se contactarán inmediatamente para mayor información!\n", TextoColor.VERDE));
		} else if (respuesta.equals("No")) {
		System.out.println(TextoColor.daColorTexto("\n ¡Sentimos mucho que no hayas completado la compra!\n ¡Vuelve Pronto!\n", TextoColor.ROJO));
		} else {
		System.out.println("\nRespuesta no válida. Intente nuevamente.");
		}	


	scanner.close();

	
	}
}