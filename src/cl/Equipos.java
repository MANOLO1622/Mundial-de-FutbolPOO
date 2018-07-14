package cl;

public class Equipos {

    private String codigoIso;
    private String nombrePais;
    private String rankingFifa;
    private String bandera;

    public Equipos() {
    }

    public Equipos(String codigoIso, String nombrePais, String rankingFifa, String bandera) {
        this.codigoIso = codigoIso;
        this.nombrePais = nombrePais;
        this.rankingFifa = rankingFifa;
        this.bandera = bandera;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getRankingFifa() {
        return rankingFifa;
    }

    public String getBandera() {
        return bandera;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setRankingFifa(String rankingFifa) {
        this.rankingFifa = rankingFifa;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @Override
    public String toString() {
        return "Equipos{" + "codigoIso=" + codigoIso + ", nombrePais=" + nombrePais + ", rankingFifa=" + rankingFifa + ", bandera=" + bandera + '}';
    }
    
    
    
    
}
