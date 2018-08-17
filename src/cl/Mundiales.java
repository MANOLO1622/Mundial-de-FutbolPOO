
package cl;

import java.time.LocalDate;
import java.util.ArrayList;
import rondasMundial.*;
import java.util.Date;


public class Mundiales {
    
	private String nombreMundial;
    private LocalDate fechaInicio;
    private String paisOrganizador;
    private boolean estado;
    private ArrayList<Equipo> equiposMundial;
    
    private Resultados resultadosMundial;
    
    private String EquipoPrimerLugar;
    private String EquipoSegundoLugar;
    private String EquipoTercerLugar;

    public Mundiales() {
    }

    public Mundiales( String nombreMundial, LocalDate fechaInicio, String paisOrganizador,  boolean estado) {
        this.equiposMundial = new ArrayList();
    	this.nombreMundial = nombreMundial;
    	this.fechaInicio = fechaInicio;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
        
    }

    public LocalDate getAno() {
        return fechaInicio;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }
    
    

    public boolean getEstado() {
        return estado;
    }

    public void setAno(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPaisOrganizador(String paisOrganizador) {
        this.paisOrganizador = paisOrganizador;
    }
    
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

	public String getNombreMundial() {
		return nombreMundial;
	}

	public void setNombreMundial(String nombreMundial) {
		this.nombreMundial = nombreMundial;
	}


	
	public ArrayList<Equipo> getEquiposMundial() {
		return equiposMundial;
	}

	public void setEquiposMundial(ArrayList<Equipo> equiposMundial) {
		this.equiposMundial = equiposMundial;
	}
	
	
	public String getEquipoPrimerLugar() {
		return EquipoPrimerLugar;
	}

	public void setEquipoPrimerLugar(String equipoPrimerLugar) {
		EquipoPrimerLugar = equipoPrimerLugar;
	}

	public String getEquipoSegundoLugar() {
		return EquipoSegundoLugar;
	}

	public void setEquipoSegundoLugar(String equipoSegundoLugar) {
		EquipoSegundoLugar = equipoSegundoLugar;
	}

	public String getEquipoTercerLugar() {
		return EquipoTercerLugar;
	}

	public void setEquipoTercerLugar(String equipoTercerLugar) {
		EquipoTercerLugar = equipoTercerLugar;
		
	}
	
	public Resultados getResultadosMundial() {
		return resultadosMundial;
	}

	public void setResultadosMundial(Resultados ronda1) {
		this.resultadosMundial = ronda1;
	}

	@Override
	public String toString() {
		return "Mundiales: ano=" + fechaInicio + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + " ,Resultados Mundial= " + resultadosMundial;
	}

	
	//---------------------------------------------------------------------------------------------------
	
   public void generarCuadrosJuego() {
	   
	   this.resultadosMundial = new Resultados(this.equiposMundial);
	   
   }
    
    
    
}
