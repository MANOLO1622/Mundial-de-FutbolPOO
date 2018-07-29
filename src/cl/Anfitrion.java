package cl;

public class Anfitrion {

	private String nombre;

	public Anfitrion(String nombre) {
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Anfitrion: nombre =\" + nombre + ";
	}

	
}
