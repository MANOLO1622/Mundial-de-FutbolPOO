
package cl;

import java.time.LocalDate;

public class Mundiales {
    
	private String nombreMundial;
    private LocalDate ano;
    private String paisOrganizador;
   
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
    
    

    public boolean isEstado() {
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

	@Override
	public String toString() {
		return "Mundiales [ano=" + ano + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + "]";
	}


   
    
    
    
}
