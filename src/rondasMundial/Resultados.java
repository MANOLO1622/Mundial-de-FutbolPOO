package rondasMundial;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import cl.Equipo;
import multis.*;

public class Resultados {
	
	private String nombreMundial;
	
    private Equipo[] primerCuadro = new Equipo[4];
    private Equipo[] segundoCuadro = new Equipo[4];
    private Equipo[] tercerCuadro = new Equipo[4];
    private Equipo[] cuartoCuadro = new Equipo[4];
    private Equipo[] quintoCuadro = new Equipo[4];
    private Equipo[] sextoCuadro = new Equipo[4];
    private Equipo[] septimoCuadro = new Equipo[4];
    private Equipo[] octavoCuadro = new Equipo[4];
    
    private Partido[] partidosPrimerCuadro = new Partido[6];
    private Partido[] partidosSegundoCuadro = new Partido[6];
    private Partido[] partidosTercerCuadro = new Partido[6];
    private Partido[] partidosCuartoCuadro = new Partido[6];
    private Partido[] partidosQuintoCuadro = new Partido[6];
    private Partido[] partidosSextoCuadro = new Partido[6];
    private Partido[] partidosSeptimoCuadro = new Partido[6];
    private Partido[] partidosOctavoCuadro = new Partido[6];
    
    private Equipo[] ganadoresPrimerCuadro = new Equipo[2];
    private Equipo[] ganadoresSegundoCuadro = new Equipo[2];
    private Equipo[] ganadoresTercerCuadro = new Equipo[2];
    private Equipo[] ganadoresCuartoCuadro = new Equipo[2];
    private Equipo[] ganadoresQuintoCuadro = new Equipo[2];
    private Equipo[] ganadoresSextoCuadro = new Equipo[2];
    private Equipo[] ganadoresSeptimoCuadro = new Equipo[2];
    private Equipo[] ganadoresOctavoCuadro = new Equipo[2];
    
    
    private Partido[] partidosOctavosFinal = new Partido[8];
    private Partido[] partidosCuartosFinal = new Partido[4];
    private Partido[] partidosSemiFinal = new Partido[2];
    private Partido[] juegosFinales = new Partido[2];
    
    private Equipo[] ganadoresPrimeraFase = new Equipo[16]; 
    private Equipo[] ganadoresOctavosFinal = new Equipo[8];
    private Equipo[] ganadoresCuartosFinal = new Equipo[4];
    
    private Equipo primerLugar;
    private Equipo segundoLugar;
    private Equipo tercerLugar;
    private Equipo cuartoLugar;
    
    
    
    
	//---------------------------------------------------------------------------------------Constructor.
    
    public Resultados() {
    	
    	
    }
    
    
    public Resultados(ArrayList<Equipo> equiposMundial, String nombreMundial) {
    	
    	this.nombreMundial = nombreMundial;
    	
    	int contador = 0;
    	
    	//-----------------------------------------------------Primero
    	
    	for(int i=0; i<4;i++) {
    		
    		primerCuadro[i] = equiposMundial.get(i);
    		new MultiPrimeraFase().crear(primerCuadro[i].getNombre(), 1, nombreMundial);
    		contador = i;
    		
    	}
    	contador++;
    	
    	//-----------------------------------------------------Segundo
    	
    	for(int i=0; i<4;i++) {
    		
    		segundoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(segundoCuadro[i].getNombre(), 2, nombreMundial);
    		contador++;
    		
    	}
    	
    	
    	//-----------------------------------------------------Tercero
    	
    	for(int i=0; i<4;i++) {
    		
    		tercerCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(tercerCuadro[i].getNombre(), 3, nombreMundial);
    		contador++;
    		
    	}

    	
    	//-----------------------------------------------------Cuarto

    	for(int i=0; i<4;i++) {
    		
    		cuartoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(cuartoCuadro[i].getNombre(), 4, nombreMundial);
    		contador++;
    		
    	}
 	
    	//-----------------------------------------------------Quinto

    	for(int i=0; i<4;i++) {
    		
    		quintoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(quintoCuadro[i].getNombre(), 5, nombreMundial);
    		contador++;
    		
    	}
    	
    	//-----------------------------------------------------Sexto

    	for(int i=0; i<4;i++) {
    		
    		sextoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(sextoCuadro[i].getNombre(), 6, nombreMundial);
    		contador++;
    		
    	}

    	//-----------------------------------------------------Septimo

    	for(int i=0; i<4;i++) {
    		
    		septimoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(septimoCuadro[i].getNombre(), 7, nombreMundial);
    		contador++;
    		
    	}

    	//-----------------------------------------------------Octavo

    	for(int i=0; i<4;i++) {
    		
    		octavoCuadro[i] = equiposMundial.get(contador);
    		new MultiPrimeraFase().crear(octavoCuadro[i].getNombre(), 8, nombreMundial);
    		contador++;
    		
    	}
    	
    	//Generacion de los partidos.
    	
    	generarJuegos();
    	
    	
    }
    

	//---------------------------------------------------------------------------------------Gets y Sets.
    
    
	public Equipo[] getPrimerCuadro() {
		return primerCuadro;
	}
	public void setPrimerCuadro(Equipo[] primerCuadro) {
		this.primerCuadro = primerCuadro;
	}
	public Equipo[] getSegundoCuadro() {
		return segundoCuadro;
	}
	public void setSegundoCuadro(Equipo[] segundoCuadro) {
		this.segundoCuadro = segundoCuadro;
	}
	public Equipo[] getTercerCuadro() {
		return tercerCuadro;
	}
	public void setTercerCuadro(Equipo[] tercerCuadro) {
		this.tercerCuadro = tercerCuadro;
	}
	public Equipo[] getCuartoCuadro() {
		return cuartoCuadro;
	}
	public void setCuartoCuadro(Equipo[] cuartoCuadro) {
		this.cuartoCuadro = cuartoCuadro;
	}
	public Equipo[] getQuintoCuadro() {
		return quintoCuadro;
	}
	public void setQuintoCuadro(Equipo[] quintoCuadro) {
		this.quintoCuadro = quintoCuadro;
	}
	public Equipo[] getSextoCuadro() {
		return sextoCuadro;
	}
	public void setSextoCuadro(Equipo[] sextoCuadro) {
		this.sextoCuadro = sextoCuadro;
	}
	public Equipo[] getSeptimoCuadro() {
		return septimoCuadro;
	}
	public void setSeptimoCuadro(Equipo[] septimoCuadro) {
		this.septimoCuadro = septimoCuadro;
	}
	public Equipo[] getOctavoCuadro() {
		return octavoCuadro;
	}
	public void setOctavoCuadro(Equipo[] octavoCuadro) {
		this.octavoCuadro = octavoCuadro;
	}
	
	
	public Partido[] getPartidosPrimerCuadro() {
		return partidosPrimerCuadro;
	}


	public void setPartidosPrimerCuadro(Partido[] partidosPrimerCuadro) {
		this.partidosPrimerCuadro = partidosPrimerCuadro;
	}


	public Partido[] getPartidosSegundoCuadro() {
		return partidosSegundoCuadro;
	}


	public void setPartidosSegundoCuadro(Partido[] partidosSegundoCuadro) {
		this.partidosSegundoCuadro = partidosSegundoCuadro;
	}


	public Partido[] getPartidosTercerCuadro() {
		return partidosTercerCuadro;
	}


	public void setPartidosTercerCuadro(Partido[] partidosTercerCuadro) {
		this.partidosTercerCuadro = partidosTercerCuadro;
	}


	public Partido[] getPartidosCuartoCuadro() {
		return partidosCuartoCuadro;
	}


	public void setPartidosCuartoCuadro(Partido[] partidosCuartoCuadro) {
		this.partidosCuartoCuadro = partidosCuartoCuadro;
	}


	public Partido[] getPartidosQuintoCuadro() {
		return partidosQuintoCuadro;
	}


	public void setPartidosQuintoCuadro(Partido[] partidosQuintoCuadro) {
		this.partidosQuintoCuadro = partidosQuintoCuadro;
	}


	public Partido[] getPartidosSextoCuadro() {
		return partidosSextoCuadro;
	}


	public void setPartidosSextoCuadro(Partido[] partidosSextoCuadro) {
		this.partidosSextoCuadro = partidosSextoCuadro;
	}


	public Partido[] getPartidosSeptimoCuadro() {
		return partidosSeptimoCuadro;
	}


	public void setPartidosSeptimoCuadro(Partido[] partidosSeptimoCuadro) {
		this.partidosSeptimoCuadro = partidosSeptimoCuadro;
	}


	public Partido[] getPartidosOctavoCuadro() {
		return partidosOctavoCuadro;
	}


	public void setPartidosOctavoCuadro(Partido[] partidosOctavoCuadro) {
		this.partidosOctavoCuadro = partidosOctavoCuadro;
	}
	
	public Equipo[] getGanadoresPrimerCuadro() {
		return ganadoresPrimerCuadro;
	}


	public void setGanadoresPrimerCuadro(Equipo[] ganadoresPrimerCuadro) {
		this.ganadoresPrimerCuadro = ganadoresPrimerCuadro;
	}


	public Equipo[] getGanadoresSegundoCuadro() {
		return ganadoresSegundoCuadro;
	}


	public void setGanadoresSegundoCuadro(Equipo[] ganadoresSegundoCuadro) {
		this.ganadoresSegundoCuadro = ganadoresSegundoCuadro;
	}


	public Equipo[] getGanadoresTercerCuadro() {
		return ganadoresTercerCuadro;
	}


	public void setGanadoresTercerCuadro(Equipo[] ganadoresTercerCuadro) {
		this.ganadoresTercerCuadro = ganadoresTercerCuadro;
	}


	public Equipo[] getGanadoresCuartoCuadro() {
		return ganadoresCuartoCuadro;
	}


	public void setGanadoresCuartoCuadro(Equipo[] ganadoresCuartoCuadro) {
		this.ganadoresCuartoCuadro = ganadoresCuartoCuadro;
	}


	public Equipo[] getGanadoresQuintoCuadro() {
		return ganadoresQuintoCuadro;
	}


	public void setGanadoresQuintoCuadro(Equipo[] ganadoresQuintoCuadro) {
		this.ganadoresQuintoCuadro = ganadoresQuintoCuadro;
	}


	public Equipo[] getGanadoresSextoCuadro() {
		return ganadoresSextoCuadro;
	}


	public void setGanadoresSextoCuadro(Equipo[] ganadoresSextoCuadro) {
		this.ganadoresSextoCuadro = ganadoresSextoCuadro;
	}


	public Equipo[] getGanadoresSeptimoCuadro() {
		return ganadoresSeptimoCuadro;
	}


	public void setGanadoresSeptimoCuadro(Equipo[] ganadoresSeptimoCuadro) {
		this.ganadoresSeptimoCuadro = ganadoresSeptimoCuadro;
	}


	public Equipo[] getGanadoresOctavoCuadro() {
		return ganadoresOctavoCuadro;
	}


	public void setGanadoresOctavoCuadro(Equipo[] ganadoresOctavoCuadro) {
		this.ganadoresOctavoCuadro = ganadoresOctavoCuadro;
	}


	public Partido[] getPartidosOctavosFinal() {
		return partidosOctavosFinal;
	}


	public void setPartidosOctavosFinal(Partido[] partidosOctavosFinal) {
		this.partidosOctavosFinal = partidosOctavosFinal;
	}


	public Partido[] getPartidosCuartosFinal() {
		return partidosCuartosFinal;
	}


	public void setPartidosCuartosFinal(Partido[] partidosCuartosFinal) {
		this.partidosCuartosFinal = partidosCuartosFinal;
	}


	public Partido[] getPartidosSemiFinal() {
		return partidosSemiFinal;
	}


	public void setPartidosSemiFinal(Partido[] partidosSemiFinal) {
		this.partidosSemiFinal = partidosSemiFinal;
	}

	public Partido[] getJuegosFinales() {
		return juegosFinales;
	}


	public void setJuegosFinales(Partido[] juegosFinales) {
		this.juegosFinales = juegosFinales;
	}


	public Equipo[] getGanadoresOctavosFinal() {
		return ganadoresOctavosFinal;
	}


	public void setGanadoresOctavosFinal(Equipo[] ganadoresOctavosFinal) {
		this.ganadoresOctavosFinal = ganadoresOctavosFinal;
	}


	public Equipo[] getGanadoresCuartosFinal() {
		return ganadoresCuartosFinal;
	}


	public void setGanadoresCuartosFinal(Equipo[] ganadoresCuartosFinal) {
		this.ganadoresCuartosFinal = ganadoresCuartosFinal;
	}	
	
	public Equipo getPrimerLugar() {
		return primerLugar;
	}


	public void setPrimerLugar(Equipo primerLugar) {
		this.primerLugar = primerLugar;
	}


	public Equipo getSegundoLugar() {
		return segundoLugar;
	}


	public void setSegundoLugar(Equipo segundoLugar) {
		this.segundoLugar = segundoLugar;
	}


	public Equipo getTercerLugar() {
		return tercerLugar;
	}


	public void setTercerLugar(Equipo tercerLugar) {
		this.tercerLugar = tercerLugar;
	}


	public Equipo getCuartoLugar() {
		return cuartoLugar;
	}


	public void setCuartoLugar(Equipo cuartoLugar) {
		this.cuartoLugar = cuartoLugar;
	}
	
	
	public Equipo[] getGanadoresPrimeraFase() {
		return ganadoresPrimeraFase;
	}


	public void setGanadoresPrimeraFase(Equipo[] ganadoresPrimeraFase) {
		this.ganadoresPrimeraFase = ganadoresPrimeraFase;
	}

	//---------------------------------------------------------------------------------------metodo to String


	@Override
	public String toString() {
		return "Resultados: primerCuadro= " + Arrays.toString(primerCuadro) + ", segundoCuadro= "
				+ Arrays.toString(segundoCuadro) + ", tercerCuadro= " + Arrays.toString(tercerCuadro) + ", cuartoCuadro= "
				+ Arrays.toString(cuartoCuadro) + ", quintoCuadro " + Arrays.toString(quintoCuadro) + ", sextoCuadro= "
				+ Arrays.toString(sextoCuadro) + ", septimoCuadro= " + Arrays.toString(septimoCuadro) + ", octavoCuadro= "
				+ Arrays.toString(octavoCuadro);
	}
    
    

	
	
	
	//---------------------------------------------------------------------------------------puntaje de partidos
    
    public void generarJuegos() {
    	
        partidosPrimerCuadro = organizarCuadroJuego(primerCuadro, 1);
        partidosSegundoCuadro = organizarCuadroJuego(segundoCuadro, 2);
        partidosTercerCuadro = organizarCuadroJuego(tercerCuadro, 3);
        partidosCuartoCuadro = organizarCuadroJuego(cuartoCuadro, 4);
        partidosQuintoCuadro = organizarCuadroJuego(quintoCuadro, 5);
        partidosSextoCuadro = organizarCuadroJuego(sextoCuadro, 6);
        partidosSeptimoCuadro = organizarCuadroJuego(septimoCuadro, 7);
        partidosOctavoCuadro = organizarCuadroJuego(octavoCuadro, 8);

        ganadoresPrimerCuadro = guardarGanadoresPrimeraFase(partidosPrimerCuadro,primerCuadro, 1);
        ganadoresSegundoCuadro = guardarGanadoresPrimeraFase(partidosSegundoCuadro,segundoCuadro,2);
        ganadoresTercerCuadro = guardarGanadoresPrimeraFase(partidosTercerCuadro,tercerCuadro, 3);
        ganadoresCuartoCuadro = guardarGanadoresPrimeraFase(partidosCuartoCuadro,cuartoCuadro, 4);
        ganadoresQuintoCuadro = guardarGanadoresPrimeraFase(partidosQuintoCuadro,quintoCuadro, 5);
        ganadoresSextoCuadro = guardarGanadoresPrimeraFase(partidosSextoCuadro,sextoCuadro, 6);
        ganadoresSeptimoCuadro = guardarGanadoresPrimeraFase(partidosSeptimoCuadro,septimoCuadro, 7);
        ganadoresOctavoCuadro = guardarGanadoresPrimeraFase(partidosOctavoCuadro,octavoCuadro, 8); 
        
        
        
        partidosOctavosFinal = guardarPartidosOctavosFinal(ganadoresPrimerCuadro, ganadoresSegundoCuadro, ganadoresTercerCuadro, ganadoresCuartoCuadro
        		, ganadoresQuintoCuadro, ganadoresSextoCuadro, ganadoresSeptimoCuadro, ganadoresOctavoCuadro);
        
        ganadoresOctavosFinal = guardarGanadoresOctavosFinal(partidosOctavosFinal);
        
        partidosCuartosFinal = guardarPartidosCuartosFinal(ganadoresOctavosFinal);

        ganadoresCuartosFinal = guardarGanadoresCuartosFinal(partidosCuartosFinal);
       
        partidosSemiFinal = guardarSemifinales(ganadoresCuartosFinal);
        
        juegosFinales = guardarFinales(partidosSemiFinal);
      
        this.primerLugar= juegosFinales[0].getEquipoGanador();
        this.segundoLugar = juegosFinales[0].getEquipoPerdedor();
        this.tercerLugar = juegosFinales[1].getEquipoGanador();
        this.cuartoLugar = juegosFinales[1].getEquipoPerdedor();
        
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(juegosFinales[0].getEquipoGanador().getNombre(), this.nombreMundial, 1);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(juegosFinales[0].getEquipoPerdedor().getNombre(), this.nombreMundial, 1);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(juegosFinales[1].getEquipoGanador().getNombre(), this.nombreMundial, 1);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(juegosFinales[1].getEquipoPerdedor().getNombre(), this.nombreMundial, 1);
    	
        
        ganadoresPrimerafase();
        
    }
    
    public Partido[] organizarCuadroJuego(Equipo[] cuadroJuego, int cuadro) {
		
    	Partido[] partidosCuadroTemp = new Partido[6];
    	int opcionOrden = (int)(Math.random()*3);
    	
    	switch(opcionOrden) {
    	
    	case 0:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[0].getEquipo1().getNombre(),partidosCuadroTemp[0].getEquipo2().getNombre(),
    		partidosCuadroTemp[0].getEquipoGanador().getNombre(),partidosCuadroTemp[0].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[0].getPuntajeEquipo1(), partidosCuadroTemp[0].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[1].getEquipo1().getNombre(),partidosCuadroTemp[1].getEquipo2().getNombre(),
    		partidosCuadroTemp[1].getEquipoGanador().getNombre(),partidosCuadroTemp[1].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[1].getPuntajeEquipo1(), partidosCuadroTemp[1].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[2].getEquipo1().getNombre(),partidosCuadroTemp[2].getEquipo2().getNombre(),
    		partidosCuadroTemp[2].getEquipoGanador().getNombre(),partidosCuadroTemp[2].getEquipoPerdedor().getNombre(),
    	    partidosCuadroTemp[2].getPuntajeEquipo1(), partidosCuadroTemp[2].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
      		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[3].getEquipo1().getNombre(),partidosCuadroTemp[3].getEquipo2().getNombre(),
      	    partidosCuadroTemp[3].getEquipoGanador().getNombre(),partidosCuadroTemp[3].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[3].getPuntajeEquipo1(), partidosCuadroTemp[3].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[4].getEquipo1().getNombre(),partidosCuadroTemp[4].getEquipo2().getNombre(),
      	    partidosCuadroTemp[4].getEquipoGanador().getNombre(),partidosCuadroTemp[4].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[4].getPuntajeEquipo1(), partidosCuadroTemp[4].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[5].getEquipo1().getNombre(),partidosCuadroTemp[5].getEquipo2().getNombre(),
      	    partidosCuadroTemp[5].getEquipoGanador().getNombre(),partidosCuadroTemp[5].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[5].getPuntajeEquipo1(), partidosCuadroTemp[5].getPuntajeEquipo2(), cuadro, nombreMundial);

    		break;
    		
    	case 1:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[0].getEquipo1().getNombre(),partidosCuadroTemp[0].getEquipo2().getNombre(),
    		partidosCuadroTemp[0].getEquipoGanador().getNombre(),partidosCuadroTemp[0].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[0].getPuntajeEquipo1(), partidosCuadroTemp[0].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[1].getEquipo1().getNombre(),partidosCuadroTemp[1].getEquipo2().getNombre(),
    		partidosCuadroTemp[1].getEquipoGanador().getNombre(),partidosCuadroTemp[1].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[1].getPuntajeEquipo1(), partidosCuadroTemp[1].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[2].getEquipo1().getNombre(),partidosCuadroTemp[2].getEquipo2().getNombre(),
    		partidosCuadroTemp[2].getEquipoGanador().getNombre(),partidosCuadroTemp[2].getEquipoPerdedor().getNombre(),
    	    partidosCuadroTemp[2].getPuntajeEquipo1(), partidosCuadroTemp[2].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
      		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[3].getEquipo1().getNombre(),partidosCuadroTemp[3].getEquipo2().getNombre(),
      	    partidosCuadroTemp[3].getEquipoGanador().getNombre(),partidosCuadroTemp[3].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[3].getPuntajeEquipo1(), partidosCuadroTemp[3].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[4].getEquipo1().getNombre(),partidosCuadroTemp[4].getEquipo2().getNombre(),
      	    partidosCuadroTemp[4].getEquipoGanador().getNombre(),partidosCuadroTemp[4].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[4].getPuntajeEquipo1(), partidosCuadroTemp[4].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[5].getEquipo1().getNombre(),partidosCuadroTemp[5].getEquipo2().getNombre(),
      	    partidosCuadroTemp[5].getEquipoGanador().getNombre(),partidosCuadroTemp[5].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[5].getPuntajeEquipo1(), partidosCuadroTemp[5].getPuntajeEquipo2(), cuadro, nombreMundial);

    		break;
    		
    	case 2:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[0].getEquipo1().getNombre(),partidosCuadroTemp[0].getEquipo2().getNombre(),
    		partidosCuadroTemp[0].getEquipoGanador().getNombre(),partidosCuadroTemp[0].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[0].getPuntajeEquipo1(), partidosCuadroTemp[0].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[1].getEquipo1().getNombre(),partidosCuadroTemp[1].getEquipo2().getNombre(),
    		partidosCuadroTemp[1].getEquipoGanador().getNombre(),partidosCuadroTemp[1].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[1].getPuntajeEquipo1(), partidosCuadroTemp[1].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[2].getEquipo1().getNombre(),partidosCuadroTemp[2].getEquipo2().getNombre(),
    		partidosCuadroTemp[2].getEquipoGanador().getNombre(),partidosCuadroTemp[2].getEquipoPerdedor().getNombre(),
    	    partidosCuadroTemp[2].getPuntajeEquipo1(), partidosCuadroTemp[2].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
      		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[3].getEquipo1().getNombre(),partidosCuadroTemp[3].getEquipo2().getNombre(),
      	    partidosCuadroTemp[3].getEquipoGanador().getNombre(),partidosCuadroTemp[3].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[3].getPuntajeEquipo1(), partidosCuadroTemp[3].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[4].getEquipo1().getNombre(),partidosCuadroTemp[4].getEquipo2().getNombre(),
      	    partidosCuadroTemp[4].getEquipoGanador().getNombre(),partidosCuadroTemp[4].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[4].getPuntajeEquipo1(), partidosCuadroTemp[4].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[5].getEquipo1().getNombre(),partidosCuadroTemp[5].getEquipo2().getNombre(),
      	    partidosCuadroTemp[5].getEquipoGanador().getNombre(),partidosCuadroTemp[5].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[5].getPuntajeEquipo1(), partidosCuadroTemp[5].getPuntajeEquipo2(), cuadro, nombreMundial);

    		break;
    		
    	default:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[0].getEquipo1().getNombre(),partidosCuadroTemp[0].getEquipo2().getNombre(),
    		partidosCuadroTemp[0].getEquipoGanador().getNombre(),partidosCuadroTemp[0].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[0].getPuntajeEquipo1(), partidosCuadroTemp[0].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[1].getEquipo1().getNombre(),partidosCuadroTemp[1].getEquipo2().getNombre(),
    		partidosCuadroTemp[1].getEquipoGanador().getNombre(),partidosCuadroTemp[1].getEquipoPerdedor().getNombre(),
    		partidosCuadroTemp[1].getPuntajeEquipo1(), partidosCuadroTemp[1].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[2].getEquipo1().getNombre(),partidosCuadroTemp[2].getEquipo2().getNombre(),
    		partidosCuadroTemp[2].getEquipoGanador().getNombre(),partidosCuadroTemp[2].getEquipoPerdedor().getNombre(),
    	    partidosCuadroTemp[2].getPuntajeEquipo1(), partidosCuadroTemp[2].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
      		new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[3].getEquipo1().getNombre(),partidosCuadroTemp[3].getEquipo2().getNombre(),
      	    partidosCuadroTemp[3].getEquipoGanador().getNombre(),partidosCuadroTemp[3].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[3].getPuntajeEquipo1(), partidosCuadroTemp[3].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[4].getEquipo1().getNombre(),partidosCuadroTemp[4].getEquipo2().getNombre(),
      	    partidosCuadroTemp[4].getEquipoGanador().getNombre(),partidosCuadroTemp[4].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[4].getPuntajeEquipo1(), partidosCuadroTemp[4].getPuntajeEquipo2(), cuadro, nombreMundial);
      	    		
      	    new MultiPartidos().crearPrimeraFase(partidosCuadroTemp[5].getEquipo1().getNombre(),partidosCuadroTemp[5].getEquipo2().getNombre(),
      	    partidosCuadroTemp[5].getEquipoGanador().getNombre(),partidosCuadroTemp[5].getEquipoPerdedor().getNombre(),
      	    partidosCuadroTemp[5].getPuntajeEquipo1(), partidosCuadroTemp[5].getPuntajeEquipo2(), cuadro, nombreMundial);
    		
    		break;    	
    	
    	}
    	return partidosCuadroTemp;
    }
    
    
	//---------------------------------------------------------------------------------------Sacar ganadores de cada cuadro
    
    public Equipo[] guardarGanadoresPrimeraFase(Partido[] partidosCuadro, Equipo[] equipoCuadro, int cuadro) {
		
    	int equipo1Contador = 0;
    	int equipo2Contador = 0;
    	int equipo3Contador = 0;
    	int equipo4Contador = 0;
    	
    	Equipo[] listaRetorno = new Equipo[2];
    	ArrayList<Equipo> listatemporal = new ArrayList();
    	
	
    	for(Partido e: partidosCuadro) {
    		
    		//Se genera el contador de cada equipo para ver cuantas veces ha logrado ganar.
    		
    		if(e.getEquipoGanador().getNombre().equals(equipoCuadro[0].getNombre())) {

    			equipo1Contador++;
    			
    		}
    		
    		if(e.getEquipoGanador().getNombre().equals(equipoCuadro[1].getNombre())) {
    			
    			equipo2Contador++;
    			
    		}

    		if(e.getEquipoGanador().getNombre().equals(equipoCuadro[2].getNombre())) {
    			
    			equipo3Contador++;
    			
    		}

    		if(e.getEquipoGanador().getNombre().equals(equipoCuadro[3].getNombre())) {
    			
    			equipo4Contador++;
    			
    		} 		
    		
    	}
    	
		//Se compara la cantidad de victorias para saber si se va a clasificar a la segunda fase.    	
    	
    	if(equipo1Contador == 3 || equipo2Contador == 3 || equipo3Contador == 3 || equipo4Contador == 3) {
    		
    		if(equipo1Contador == 3 && equipo2Contador == 1 && equipo3Contador == 1 && equipo4Contador == 1) {
    			
    		   	listaRetorno[0] = equipoCuadro[0];
    			listaRetorno[1] = retornarEquipoMayorRanking(equipoCuadro[1], equipoCuadro[2],equipoCuadro[3]);
    			
    		} else if(equipo2Contador == 3 && equipo1Contador == 1 && equipo3Contador == 1 && equipo4Contador == 1) {

    		   	listaRetorno[0] = equipoCuadro[1];
    			listaRetorno[1] = retornarEquipoMayorRanking(equipoCuadro[0], equipoCuadro[2],equipoCuadro[3]);
    			
    		}else if(equipo3Contador == 3 && equipo1Contador == 1 && equipo2Contador == 1 && equipo4Contador == 1) {
    			
    		   	listaRetorno[0] = equipoCuadro[2];
    			listaRetorno[1] = retornarEquipoMayorRanking(equipoCuadro[0], equipoCuadro[1],equipoCuadro[3]);
    			
    		}else if(equipo4Contador == 3 && equipo1Contador == 1 && equipo2Contador == 1 && equipo3Contador == 1) {
    			
    		   	listaRetorno[0] = equipoCuadro[3];
    			listaRetorno[1] = retornarEquipoMayorRanking(equipoCuadro[0], equipoCuadro[1],equipoCuadro[2]);
    			
    		} else {
    			
        		if(equipo1Contador>=2) {
        			
        			listatemporal.add(equipoCuadro[0]);
        			
        		}
        		
        		if(equipo2Contador>=2) {
        			
        			listatemporal.add(equipoCuadro[1]);    			
        			
        		}
        		
        		if(equipo3Contador>=2) {
        			
        			listatemporal.add(equipoCuadro[2]);    			
        			
        		}
        		
        		if(equipo4Contador>=2) {
        			
        			listatemporal.add(equipoCuadro[3]);    			
        			
        		} 
        		
        	   	listaRetorno[0] = listatemporal.get(0);
        		listaRetorno[1] = listatemporal.get(1);
    			
    			
    		}
    		
    	}else {
    		
    		
    		if(equipo1Contador>=2) {
    			
    			listatemporal.add(equipoCuadro[0]);
    			
    		}
    		
    		if(equipo2Contador>=2) {
    			
    			listatemporal.add(equipoCuadro[1]);    			
    			
    		}
    		
    		if(equipo3Contador>=2) {
    			
    			listatemporal.add(equipoCuadro[2]);    			
    			
    		}
    		
    		if(equipo4Contador>=2) {
    			
    			listatemporal.add(equipoCuadro[3]);    			
    			
    		} 
    		
    	   	listaRetorno[0] = listatemporal.get(0);
    		listaRetorno[1] = listatemporal.get(1);
    		
    	}
    	

    	

		
		//----------------------------------------------------------------------------
    	new MultiEquipos().registrarEquipoGanadorPrimeraFase(listaRetorno[0].getNombre(), this.nombreMundial, cuadro);
    	new MultiEquipos().registrarEquipoGanadorPrimeraFase(listaRetorno[1].getNombre(), this.nombreMundial, cuadro);
    	
    	return listaRetorno;
    	    	
    }
    
    
  //---------------------------------------------------------------------------------------Sacar ganadores los octavos de final
    
    
    public Equipo retornarEquipoMayorRanking(Equipo temp1, Equipo temp2, Equipo temp3) {
    	
    	if(temp1.getRanking()>temp2.getRanking() && temp1.getRanking()>temp3.getRanking()) {
    		
    		return temp1;
    		
    	} else if(temp2.getRanking()>temp1.getRanking() && temp2.getRanking()>temp3.getRanking()) {
    		
    		
    		return temp2;
    		
    	}else if(temp3.getRanking()>temp1.getRanking() && temp3.getRanking()>temp2.getRanking()) {
    		
    		return temp3;
    		
    	}else {
    		
    		return temp1;
    		
    	}
    	
    }
    
    
    
    public Partido[] guardarPartidosOctavosFinal(Equipo[] ganadores1, Equipo[] ganadores2,Equipo[] ganadores3,Equipo[] ganadores4,Equipo[] ganadores5,Equipo[] ganadores6
    		,Equipo[] ganadores7,Equipo[] ganadores8) {
    	
    	Partido[] partidosOctavosFinalTemp = new Partido[8];
    	
    	partidosOctavosFinalTemp[0] = new Partido(ganadores1[0], ganadores2[1]);
    	partidosOctavosFinalTemp[1] = new Partido(ganadores1[1], ganadores2[0]);
    	
    	partidosOctavosFinalTemp[2] = new Partido(ganadores3[0], ganadores4[1]);
    	partidosOctavosFinalTemp[3] = new Partido(ganadores3[1], ganadores4[0]);
    	
    	partidosOctavosFinalTemp[4] = new Partido(ganadores5[0], ganadores6[1]);
    	partidosOctavosFinalTemp[5] = new Partido(ganadores5[1], ganadores6[0]);
    	
    	partidosOctavosFinalTemp[6] = new Partido(ganadores7[0], ganadores8[1]);
    	partidosOctavosFinalTemp[7] = new Partido(ganadores7[1], ganadores8[0]);
    	
    	
		new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[0].getEquipo1().getNombre(),partidosOctavosFinalTemp[0].getEquipo2().getNombre(),
				partidosOctavosFinalTemp[0].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[0].getEquipoPerdedor().getNombre(),
				partidosOctavosFinalTemp[0].getPuntajeEquipo1(), partidosOctavosFinalTemp[0].getPuntajeEquipo2(),8, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[1].getEquipo1().getNombre(),partidosOctavosFinalTemp[1].getEquipo2().getNombre(),
				partidosOctavosFinalTemp[1].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[1].getEquipoPerdedor().getNombre(),
				partidosOctavosFinalTemp[1].getPuntajeEquipo1(), partidosOctavosFinalTemp[1].getPuntajeEquipo2(), 8, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[2].getEquipo1().getNombre(),partidosOctavosFinalTemp[2].getEquipo2().getNombre(),
				partidosOctavosFinalTemp[2].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[2].getEquipoPerdedor().getNombre(),
				partidosOctavosFinalTemp[2].getPuntajeEquipo1(), partidosOctavosFinalTemp[2].getPuntajeEquipo2(), 8, nombreMundial);
		
  		new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[3].getEquipo1().getNombre(),partidosOctavosFinalTemp[3].getEquipo2().getNombre(),
  				partidosOctavosFinalTemp[3].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[3].getEquipoPerdedor().getNombre(),
  				partidosOctavosFinalTemp[3].getPuntajeEquipo1(), partidosOctavosFinalTemp[3].getPuntajeEquipo2(), 8, nombreMundial);
  	    		
  	    new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[4].getEquipo1().getNombre(),partidosOctavosFinalTemp[4].getEquipo2().getNombre(),
  	    		partidosOctavosFinalTemp[4].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[4].getEquipoPerdedor().getNombre(),
  	    		partidosOctavosFinalTemp[4].getPuntajeEquipo1(), partidosOctavosFinalTemp[4].getPuntajeEquipo2(), 8, nombreMundial);
  	    		
  	    new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[5].getEquipo1().getNombre(),partidosOctavosFinalTemp[5].getEquipo2().getNombre(),
  	    		partidosOctavosFinalTemp[5].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[5].getEquipoPerdedor().getNombre(),
  	    		partidosOctavosFinalTemp[5].getPuntajeEquipo1(), partidosOctavosFinalTemp[5].getPuntajeEquipo2(), 8, nombreMundial);
  	    
 	    new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[6].getEquipo1().getNombre(),partidosOctavosFinalTemp[6].getEquipo2().getNombre(),
  	    		partidosOctavosFinalTemp[6].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[6].getEquipoPerdedor().getNombre(),
  	    		partidosOctavosFinalTemp[6].getPuntajeEquipo1(), partidosOctavosFinalTemp[6].getPuntajeEquipo2(), 8, nombreMundial);
  	    		
  	    new MultiPartidos().crearSegundaFase(partidosOctavosFinalTemp[7].getEquipo1().getNombre(),partidosOctavosFinalTemp[7].getEquipo2().getNombre(),
  	    		partidosOctavosFinalTemp[7].getEquipoGanador().getNombre(),partidosOctavosFinalTemp[7].getEquipoPerdedor().getNombre(),
  	    		partidosOctavosFinalTemp[7].getPuntajeEquipo1(), partidosOctavosFinalTemp[7].getPuntajeEquipo2(), 8, nombreMundial);
    	
    	
    	return partidosOctavosFinalTemp;
    	
    }
    
    
    public Partido[] guardarPartidosCuartosFinal(Equipo[] ganadores) {
    	
    	Partido[] partidosCuartosFinalTemp = new Partido[4];
    	
    	partidosCuartosFinalTemp[0] = new Partido(ganadores[0], ganadores[1]);
    	partidosCuartosFinalTemp[1] = new Partido(ganadores[2], ganadores[3]);
    	partidosCuartosFinalTemp[2] = new Partido(ganadores[4], ganadores[5]);
    	partidosCuartosFinalTemp[3] = new Partido(ganadores[6], ganadores[7]);
    	
		new MultiPartidos().crearSegundaFase(partidosCuartosFinalTemp[0].getEquipo1().getNombre(),partidosCuartosFinalTemp[0].getEquipo2().getNombre(),
				partidosCuartosFinalTemp[0].getEquipoGanador().getNombre(),partidosCuartosFinalTemp[0].getEquipoPerdedor().getNombre(),
				partidosCuartosFinalTemp[0].getPuntajeEquipo1(), partidosCuartosFinalTemp[0].getPuntajeEquipo2(),4, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(partidosCuartosFinalTemp[1].getEquipo1().getNombre(),partidosCuartosFinalTemp[1].getEquipo2().getNombre(),
				partidosCuartosFinalTemp[1].getEquipoGanador().getNombre(),partidosCuartosFinalTemp[1].getEquipoPerdedor().getNombre(),
				partidosCuartosFinalTemp[1].getPuntajeEquipo1(), partidosCuartosFinalTemp[1].getPuntajeEquipo2(), 4, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(partidosCuartosFinalTemp[2].getEquipo1().getNombre(),partidosCuartosFinalTemp[2].getEquipo2().getNombre(),
				partidosCuartosFinalTemp[2].getEquipoGanador().getNombre(),partidosCuartosFinalTemp[2].getEquipoPerdedor().getNombre(),
				partidosCuartosFinalTemp[2].getPuntajeEquipo1(), partidosCuartosFinalTemp[2].getPuntajeEquipo2(), 4, nombreMundial);
		
  		new MultiPartidos().crearSegundaFase(partidosCuartosFinalTemp[3].getEquipo1().getNombre(),partidosCuartosFinalTemp[3].getEquipo2().getNombre(),
  				partidosCuartosFinalTemp[3].getEquipoGanador().getNombre(),partidosCuartosFinalTemp[3].getEquipoPerdedor().getNombre(),
  				partidosCuartosFinalTemp[3].getPuntajeEquipo1(), partidosCuartosFinalTemp[3].getPuntajeEquipo2(), 4, nombreMundial);
    	
    	return partidosCuartosFinalTemp;
    	
    }
    
    
    public Equipo[] guardarGanadoresOctavosFinal(Partido[] partidos) {
    	
    	Equipo[] ganadoresTemp = new Equipo[8];
    	
    	ganadoresTemp[0] = partidos[0].getEquipoGanador();
    	ganadoresTemp[1] = partidos[1].getEquipoGanador();
    	ganadoresTemp[2] = partidos[2].getEquipoGanador();
    	ganadoresTemp[3] = partidos[3].getEquipoGanador();
    	ganadoresTemp[4] = partidos[4].getEquipoGanador();
    	ganadoresTemp[5] = partidos[5].getEquipoGanador();
    	ganadoresTemp[6] = partidos[6].getEquipoGanador();
    	ganadoresTemp[7] = partidos[7].getEquipoGanador();
    	
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[0].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[1].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[2].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[3].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[4].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[5].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[6].getNombre(), this.nombreMundial, 8);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[7].getNombre(), this.nombreMundial, 8);
    	
    	return ganadoresTemp;
    	
    }
    
    public Equipo[] guardarGanadoresCuartosFinal(Partido[] partidos) {
    	
    	Equipo[] ganadoresTemp = new Equipo[4];
    	
    	ganadoresTemp[0] = partidos[0].getEquipoGanador();
    	ganadoresTemp[1] = partidos[1].getEquipoGanador();
    	ganadoresTemp[2] = partidos[2].getEquipoGanador();
    	ganadoresTemp[3] = partidos[3].getEquipoGanador();
    	
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[0].getNombre(), this.nombreMundial, 4);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[1].getNombre(), this.nombreMundial, 4);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[2].getNombre(), this.nombreMundial, 4);
    	new MultiEquipos().registrarEquipoGanadorSegundaFase(ganadoresTemp[3].getNombre(), this.nombreMundial, 4);
    	
    	return ganadoresTemp;
    	
    }
    
    public Partido[] guardarSemifinales(Equipo[] ganadoresCuartosFinal) {
    	
    	Partido[] semifinales = new Partido[2];
    	semifinales[0] = new Partido(ganadoresCuartosFinal[0], ganadoresCuartosFinal[1]);
    	semifinales[1] = new Partido(ganadoresCuartosFinal[2], ganadoresCuartosFinal[3]);
    	
		new MultiPartidos().crearSegundaFase(semifinales[0].getEquipo1().getNombre(),semifinales[0].getEquipo2().getNombre(),
				semifinales[0].getEquipoGanador().getNombre(),semifinales[0].getEquipoPerdedor().getNombre(),
				semifinales[0].getPuntajeEquipo1(), semifinales[0].getPuntajeEquipo2(),2, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(semifinales[1].getEquipo1().getNombre(),semifinales[1].getEquipo2().getNombre(),
				semifinales[1].getEquipoGanador().getNombre(),semifinales[1].getEquipoPerdedor().getNombre(),
				semifinales[1].getPuntajeEquipo1(), semifinales[1].getPuntajeEquipo2(), 2, nombreMundial);
    	
    	return semifinales;
    }
    
    
    
    
    public Partido[] guardarFinales(Partido[] partido) {
    	
    	Partido[] finales = new Partido[2];
    	finales[0] = new Partido(partido[0].getEquipoGanador(), partido[1].getEquipoGanador());
    	finales[1] = new Partido(partido[0].getEquipoPerdedor(), partido[1].getEquipoPerdedor());
  	
		new MultiPartidos().crearSegundaFase(finales[0].getEquipo1().getNombre(),finales[0].getEquipo2().getNombre(),
				finales[0].getEquipoGanador().getNombre(),finales[0].getEquipoPerdedor().getNombre(),
				finales[0].getPuntajeEquipo1(), finales[0].getPuntajeEquipo2(),1, nombreMundial);
		
		new MultiPartidos().crearSegundaFase(finales[1].getEquipo1().getNombre(),finales[1].getEquipo2().getNombre(),
				finales[1].getEquipoGanador().getNombre(),finales[1].getEquipoPerdedor().getNombre(),
				finales[1].getPuntajeEquipo1(), finales[1].getPuntajeEquipo2(), 1, nombreMundial);
    	
    	
    	System.out.println();
    	System.out.println("El ganador de la copa es: " + finales[0].getEquipoGanador().getNombre());
    	System.out.println("Segundo lugar: " + finales[0].getEquipoPerdedor().getNombre());
    	System.out.println("Tercer lugar: " + finales[1].getEquipoGanador().getNombre());
    	System.out.println("Cuarto lugar: " + finales[1].getEquipoPerdedor().getNombre());
    	System.out.println();
   	
		return finales;
    	
    }
    
    public void ganadoresPrimerafase() {
    	
    	ganadoresPrimeraFase[0] = partidosOctavosFinal[0].getEquipo1();
    	ganadoresPrimeraFase[1] = partidosOctavosFinal[0].getEquipo2();
    	ganadoresPrimeraFase[2] = partidosOctavosFinal[1].getEquipo1();
    	ganadoresPrimeraFase[3] = partidosOctavosFinal[1].getEquipo2();
    	ganadoresPrimeraFase[4] = partidosOctavosFinal[2].getEquipo1();
    	ganadoresPrimeraFase[5] = partidosOctavosFinal[2].getEquipo2();
    	ganadoresPrimeraFase[6] = partidosOctavosFinal[3].getEquipo1();
    	ganadoresPrimeraFase[7] = partidosOctavosFinal[3].getEquipo2();
    	ganadoresPrimeraFase[8] = partidosOctavosFinal[4].getEquipo1();
    	ganadoresPrimeraFase[9] = partidosOctavosFinal[4].getEquipo2();
    	ganadoresPrimeraFase[10] = partidosOctavosFinal[5].getEquipo1();
    	ganadoresPrimeraFase[11] = partidosOctavosFinal[5].getEquipo2();
    	ganadoresPrimeraFase[12] = partidosOctavosFinal[6].getEquipo1();
    	ganadoresPrimeraFase[13] = partidosOctavosFinal[6].getEquipo2();
    	ganadoresPrimeraFase[14] = partidosOctavosFinal[7].getEquipo1();
    	ganadoresPrimeraFase[15] = partidosOctavosFinal[7].getEquipo2();
    	
    }

}
