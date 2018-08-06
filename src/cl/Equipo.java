package cl;

/**
 * @author Dennis Ly
 *
 */
public class Equipo {
	
	private ISOPaises iso;
	private String nombre;
	private int ranking;
	private String bandera;//http://flagpedia.net/index
	
	
	
	public Equipo(String nombre, int ranking, String bandera, ISOPaises iso) {
		this.iso = iso;
		this.nombre = nombre;
		this.ranking = ranking;
		this.bandera = bandera;
		
	}
	
	
	public ISOPaises getIso() {
		return iso;
	}
	
	public void setIso(ISOPaises iso) {
		this.iso = iso;
	}
	
	public String getNombre(){
		return nombre;
	}
	

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public String getBandera() {
		return bandera;
	}
	
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	


	@Override
	public String toString() {
		return "Equipo: nombre="+ nombre + ", ranking=" + ranking + ", bandera=" + bandera;
	}
	
	
	
	

}
