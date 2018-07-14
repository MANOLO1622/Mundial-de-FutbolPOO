
package cl;

public class Mundiales {
    
    private int ano;
    private String paisOrganizador;
    private boolean estado;

    public Mundiales() {
    }

    public Mundiales(int ano, String paisOrganizador, boolean estado) {
        this.ano = ano;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
    }

    public int getAno() {
        return ano;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPaisOrganizador(String paisOrganizador) {
        this.paisOrganizador = paisOrganizador;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mundiales{" + "ano=" + ano + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + '}';
    }
    
    
    
}
