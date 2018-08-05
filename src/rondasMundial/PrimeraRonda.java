package rondasMundial;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import cl.Equipo;

public class PrimeraRonda {
	
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
    
	//---------------------------------------------------------------------------------------Constructor.
    
    public PrimeraRonda(ArrayList<Equipo> equiposMundial) {
    	
    	int contador = 0;
    	
    	//-----------------------------------------------------Primero
    	
    	for(int i=0; i<4;i++) {
    		
    		primerCuadro[i] = equiposMundial.get(i);
    		contador = i;
    		
    	}
    	contador++;
    	
    	//-----------------------------------------------------Segundo
    	
    	for(int i=0; i<4;i++) {
    		
    		segundoCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}
    	
    	
    	//-----------------------------------------------------Tercero
    	
    	for(int i=0; i<4;i++) {
    		
    		tercerCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}

    	
    	//-----------------------------------------------------Cuarto

    	for(int i=0; i<4;i++) {
    		
    		cuartoCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}
 	
    	//-----------------------------------------------------Quinto

    	for(int i=0; i<4;i++) {
    		
    		quintoCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}
    	
    	//-----------------------------------------------------Sexto

    	for(int i=0; i<4;i++) {
    		
    		sextoCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}

    	//-----------------------------------------------------Septimo

    	for(int i=0; i<4;i++) {
    		
    		septimoCuadro[i] = equiposMundial.get(contador);
    		contador++;
    		
    	}

    	//-----------------------------------------------------Octavo

    	for(int i=0; i<4;i++) {
    		
    		octavoCuadro[i] = equiposMundial.get(contador);
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

	//---------------------------------------------------------------------------------------metodo to String
	
	@Override
	public String toString() {
		return "PrimeraRonda: primerCuadro= " + Arrays.toString(primerCuadro) + ", segundoCuadro= "
				+ Arrays.toString(segundoCuadro) + ", tercerCuadro= " + Arrays.toString(tercerCuadro) + ", cuartoCuadro= "
				+ Arrays.toString(cuartoCuadro) + ", quintoCuadro " + Arrays.toString(quintoCuadro) + ", sextoCuadro= "
				+ Arrays.toString(sextoCuadro) + ", septimoCuadro= " + Arrays.toString(septimoCuadro) + ", octavoCuadro= "
				+ Arrays.toString(octavoCuadro);
	}
    
    
	//---------------------------------------------------------------------------------------puntaje de partidos
    
    public void generarJuegos() {
    	
    	System.out.println("Primer cuadro: ");
        partidosPrimerCuadro = organizarCuadroJuego(primerCuadro);
        System.out.println("");
     
        System.out.println("Segundo cuadro: ");
        partidosSegundoCuadro = organizarCuadroJuego(segundoCuadro);
        System.out.println("");
 
        System.out.println("Tercer cuadro: ");
        partidosTercerCuadro = organizarCuadroJuego(tercerCuadro);
        System.out.println("");

        System.out.println("Cuarto cuadro: ");
        partidosCuartoCuadro = organizarCuadroJuego(cuartoCuadro);
        System.out.println("");

        System.out.println("Quinto cuadro: ");
        partidosQuintoCuadro = organizarCuadroJuego(quintoCuadro);
        System.out.println("");

        System.out.println("Sexto cuadro: ");
        partidosSextoCuadro = organizarCuadroJuego(sextoCuadro);
        System.out.println("");

        System.out.println("Septimo cuadro: ");
        partidosSeptimoCuadro = organizarCuadroJuego(septimoCuadro);
        System.out.println("");
      
        System.out.println("Octavo cuadro: ");
        partidosOctavoCuadro = organizarCuadroJuego(octavoCuadro);
        System.out.println(""); 
        
        
        
    }
    
    public Partido[] organizarCuadroJuego(Equipo[] cuadroJuego) {
		
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
    		
    		
    		System.out.println(partidosCuadroTemp[0].toString());
    		System.out.println(partidosCuadroTemp[1].toString());
    		System.out.println(partidosCuadroTemp[2].toString());
    		System.out.println(partidosCuadroTemp[3].toString());
    		System.out.println(partidosCuadroTemp[4].toString());
    		System.out.println(partidosCuadroTemp[5].toString());
    		
    		break;
    		
    	case 1:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		
    		System.out.println(partidosCuadroTemp[0].toString());
    		System.out.println(partidosCuadroTemp[1].toString());
    		System.out.println(partidosCuadroTemp[2].toString());
    		System.out.println(partidosCuadroTemp[3].toString());
    		System.out.println(partidosCuadroTemp[4].toString());
    		System.out.println(partidosCuadroTemp[5].toString());
    		
    		break;
    		
    	case 2:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		
    		System.out.println(partidosCuadroTemp[0].toString());
    		System.out.println(partidosCuadroTemp[1].toString());
    		System.out.println(partidosCuadroTemp[2].toString());
    		System.out.println(partidosCuadroTemp[3].toString());
    		System.out.println(partidosCuadroTemp[4].toString());
    		System.out.println(partidosCuadroTemp[5].toString());
    		
    		break;
    		
    	default:
    		
    		partidosCuadroTemp[0] = new Partido(cuadroJuego[3],cuadroJuego[2]);
    		partidosCuadroTemp[1] = new Partido(cuadroJuego[0],cuadroJuego[3]);
    		partidosCuadroTemp[2] = new Partido(cuadroJuego[1],cuadroJuego[2]);
    		partidosCuadroTemp[3] = new Partido(cuadroJuego[2],cuadroJuego[0]);
    		partidosCuadroTemp[4] = new Partido(cuadroJuego[3],cuadroJuego[1]);
    		partidosCuadroTemp[5] = new Partido(cuadroJuego[0],cuadroJuego[1]);
    		
    		System.out.println(partidosCuadroTemp[0].toString());
    		System.out.println(partidosCuadroTemp[1].toString());
    		System.out.println(partidosCuadroTemp[2].toString());
    		System.out.println(partidosCuadroTemp[3].toString());
    		System.out.println(partidosCuadroTemp[4].toString());
    		System.out.println(partidosCuadroTemp[5].toString());
    		
    		break;    	
    	
    	}
    	return partidosCuadroTemp;
    }
    
    
    
    
    
    
    
    

}
