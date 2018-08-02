
package cl;

import java.time.LocalDate;
import java.util.ArrayList;
import rondasMundial.*;
import java.util.Date;


public class Mundiales {
    
	private String nombreMundial;
    private Date ano;
    private String paisOrganizador;
    private boolean estado;
    private ArrayList<Equipo> equiposMundial;
    
    private PrimeraRonda ronda1;
    
    private String EquipoPrimerLugar;
    private String EquipoSegundoLugar;
    private String EquipoTercerLugar;

    public Mundiales() {
    }

    public Mundiales( String nombreMundial, Date ano, String paisOrganizador,  boolean estado) {
        this.equiposMundial = new ArrayList();
    	this.nombreMundial = nombreMundial;
    	this.ano = ano;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
        
    }

    public Date getAno() {
        return ano;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }
    
    

    public boolean getEstado() {
        return estado;
    }

    public void setAno(Date ano) {
        this.ano = ano;
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
	
	public PrimeraRonda getRonda1() {
		return ronda1;
	}

	public void setRonda1(PrimeraRonda ronda1) {
		this.ronda1 = ronda1;
	}

	@Override
	public String toString() {
		return "Mundiales: ano=" + ano + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + " ,PrimeraRonda= " + ronda1;
	}

	
	//---------------------------------------------------------------------------------------------------
	
   public void generarCuadrosJuego() {
	   
	   this.ronda1 = new PrimeraRonda(this.equiposMundial);
	   
   }
    
    
    
}
