package cl;

public enum ISOPaises {
	
	DE,BR,BE,PT,AR,CH,FR,PL,CL,ES,PE,DK,CUSTOM;
	
	//https://www.fifa.com/fifa-world-ranking/ranking-table/men/index.html
	//https://www.worldatlas.com/aatlas/ctycodes.htm
	

	public static ISOPaises retornarISOPais(String iso) {
		
		if(iso.equals("DE")) {
			
			return ISOPaises.DE;
			
		}else if(iso.equals("BR")) {
			
			return ISOPaises.BR;
			
		}else if(iso.equals("BE")) {
			
			return ISOPaises.BE;
			
		}else if(iso.equals("PT")) {
			
			return ISOPaises.PT;
			
		}else if(iso.equals("AR")) {
			
			return ISOPaises.AR;
			
		}else if(iso.equals("CH")) {
			
			return ISOPaises.CH;
			
		}else if(iso.equals("FR")) {
			
			return ISOPaises.FR;
			
		}else if(iso.equals("PL")) {
			
			return ISOPaises.PL;
			
		}else if(iso.equals("CL")) {
			
			return ISOPaises.CL;
			
		}else if(iso.equals("ES")) {
			
			return ISOPaises.ES;
			
		}else if(iso.equals("PE")) {
			
			return ISOPaises.PE;
			
		}else if(iso.equals("DK")) {
			
			return ISOPaises.DK;
			
		}else {
			
			return ISOPaises.CUSTOM;
		}
		
		
	}
	
}
