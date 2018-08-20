package cl;

/**Esta clase contiene los diferentes perfiles del juego
 * @author DELL
 *
 */
public enum Perfiles {
	
	ADMIN,
	PLAYER,
	VIEWER;	

	/**
	 * Este metodo retorna cada perfil respectivo a base de los que se digite en el
	 * login de la app.
	 * @param lectura
	 * @return
	 */
	public static Perfiles retornarTipoPerfil(String lectura) {
		
		if(lectura.equals("ADMIN")) {
			
			return Perfiles.ADMIN;
			
		}else if(lectura.equals("PLAYER")) {
			
			return Perfiles.PLAYER;
			
		} else {
			
			return Perfiles.VIEWER;
			
		}

	}
	
	
	/**
	 * Este metodo retorna cada perfil respectivo a base de los que se digite en el
	 * login de la app.
	 * @param lectura
	 * @return
	 */
	public static int retornarTipoPerfilEntero(Perfiles lectura) {
		
		if(lectura == Perfiles.ADMIN) {
			
			return 1;
			
		}else if(lectura == Perfiles.PLAYER) {
			
			return 2;
			
		} else {
			
			return 3;
			
		}

	}
	
	
	
}
