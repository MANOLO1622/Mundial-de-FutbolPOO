
package cl;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mundiales {
    
	private String nombreMundial;
    private LocalDate ano;
    private String paisOrganizador;
    private ArrayList<Equipo> equiposMundial;
    private boolean estado;

    public Mundiales() {
    }

    public Mundiales( String nombreMundial, LocalDate ano, String paisOrganizador,  boolean estado) {
        this.nombreMundial = nombreMundial;
    	this.ano = ano;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
    }

    public LocalDate getAno() {
        return ano;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }
    
    

    public boolean getEstado() {
        return estado;
    }

    public void setAno(LocalDate ano) {
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

	@Override
	public String toString() {
		return "Mundiales [ano=" + ano + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + "]";
	}


   
    
    
    
}
