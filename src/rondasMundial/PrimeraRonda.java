package rondasMundial;

import java.util.ArrayList;
import java.util.Arrays;

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
    
	//---------------------------------------------------------------------------------------Constructor.
    
    public PrimeraRonda(ArrayList<Equipo> equiposMundial) {
    	
    	int contador = 0;
    	
    	//-----------------------------------------------------Primero
    	
    	System.out.println("Primer cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		primerCuadro[i] = equiposMundial.get(i);
    		System.out.println(primerCuadro[i]);
    		contador = i;
    		
    	}
    	contador++;
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Segundo
    	
    	System.out.println("Segundo cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		segundoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(segundoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Tercero
    	
    	System.out.println("Tercer cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		tercerCuadro[i] = equiposMundial.get(contador);
    		System.out.println(tercerCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Cuarto
    	
    	System.out.println("Cuarto cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		cuartoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(cuartoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Quinto
    	
    	System.out.println("Quinto cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		quintoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(quintoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Sexto
    	
    	System.out.println("Sexto cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		sextoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(sextoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	//-----------------------------------------------------Septimo
    	
    	System.out.println("Septimo cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		septimoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(septimoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	
    	//-----------------------------------------------------Octavo
    	
    	System.out.println("Octavo cuadro de juego:");
    	System.out.println("");
    	
    	for(int i=0; i<4;i++) {
    		
    		octavoCuadro[i] = equiposMundial.get(contador);
    		System.out.println(octavoCuadro[i]);
    		contador++;
    		
    	}
    	
    	System.out.println("");
    	
    	
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


	//---------------------------------------------------------------------------------------metodo to String
	
	@Override
	public String toString() {
		return "PrimeraRonda: primerCuadro= " + Arrays.toString(primerCuadro) + ", segundoCuadro= "
				+ Arrays.toString(segundoCuadro) + ", tercerCuadro= " + Arrays.toString(tercerCuadro) + ", cuartoCuadro= "
				+ Arrays.toString(cuartoCuadro) + ", quintoCuadro " + Arrays.toString(quintoCuadro) + ", sextoCuadro= "
				+ Arrays.toString(sextoCuadro) + ", septimoCuadro= " + Arrays.toString(septimoCuadro) + ", octavoCuadro= "
				+ Arrays.toString(octavoCuadro);
	}
    
    
	

}
