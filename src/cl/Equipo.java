package cl;

/**
 * Esta clase tiene unos metodos basicos su constructor su get y set y ademas su ToString
 * @author DELL
 *
 */
public class Equipo {
	
	private ISOPaises iso;// esto es una variable tipo ISOPaises que almacena el "iso del pais "
	private String nombre;// esto es una variable tipo String que almacena el "Nombre del equipo"
	private int ranking;// esto es una variable tipo int que almacena el "ranking del equipo"
	private String bandera;//http://flagpedia.net/index // esto es una variable tipo String que almacena el "la imagen de la bandera"
	
	
	/**
	 * Este es el constructor principal de la clase equipo
	 * @param nombre
	 * @param ranking
	 * @param bandera
	 * @param iso
	 */
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
