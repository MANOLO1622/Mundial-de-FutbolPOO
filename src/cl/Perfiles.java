package cl;

public enum Perfiles {
	
	ADMIN,
	PLAYER,
	VIEWER;	

	
	public static Perfiles retornarTipoPerfil(String lectura) {
		
		if(lectura.equals("ADMIN")) {
			
			return Perfiles.ADMIN;
			
		}else if(lectura.equals("PLAYER")) {
			
			return Perfiles.PLAYER;
			
		} else {
			
			return Perfiles.VIEWER;
			
		}

	}
	
	
	
	
}
