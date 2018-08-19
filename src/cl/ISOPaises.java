package cl;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**Esta clase tiene los isos de los paises guardados en un metodo de  tipo Enum
 * @author DELL
 *
 */
public enum ISOPaises {
	
	DE,BR,BE,PT,AR,CH,FR,PL,CL,ES,PE,DK,DM,EN,UY,MX,CO,NL,GL,IT,HR,TN,IS,CR,SE,US,AU,SN,SK,IE,RO,RI,PY,CUSTOM;
	;
	
	//https://www.fifa.com/fifa-world-ranking/ranking-table/men/index.html
	//https://www.worldatlas.com/aatlas/ctycodes.htm
	

	/**El metodo se utiliza para retorna el iso de cada pais 
	 * @param iso
	 * @return
	 */
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
			
		}
		else if(iso.equals("DM")) {
			
			return ISOPaises.DM;
			
		}
		else if(iso.equals("EN")) {
			
			return ISOPaises.EN;
			
		}
		else if(iso.equals("UY")) {
			
			return ISOPaises.UY;
			
		}
		else if(iso.equals("MX")) {
			
			return ISOPaises.MX;
			
		}
		else if(iso.equals("CO")) {
			
			return ISOPaises.CO;
			
		}
		else if(iso.equals("NL")) {
			
			return ISOPaises.NL;
			
		}
		else if(iso.equals("GL")) {
			
			return ISOPaises.GL;
			
		}
		else if(iso.equals("IT")) {
			
			return ISOPaises.IT;
			
		}
		else if(iso.equals("HR")) {
			
			return ISOPaises.HR;
			
		}
		else if(iso.equals("TN")) {
			
			return ISOPaises.TN;
			
		}
		else if(iso.equals("IS")) {
			
			return ISOPaises.IS;
			
		}
		else if(iso.equals("CR")) {
			
			return ISOPaises.CR;
			
		}
		else if(iso.equals("SE")) {
			
			return ISOPaises.SE;
			
		}
		else if(iso.equals("US")) {
			
			return ISOPaises.US;
			
		}
		else if(iso.equals("AU")) {
			
			return ISOPaises.AU;
			
		}
		else if(iso.equals("SN")) {
			
			return ISOPaises.SN;
			
		}
		else if(iso.equals("SK")) {
			
			return ISOPaises.SK;
			
		}
		else if(iso.equals("IE")) {
			
			return ISOPaises.IE;
			
		}
		else if(iso.equals("RO")) {
			
			return ISOPaises.RO;
			
		}
		else if(iso.equals("RI")) {
			
			return ISOPaises.RI;
			
		}
		else if(iso.equals("PY")) {
			
			return ISOPaises.PY;
			
		}else {
			
			return ISOPaises.CUSTOM;
		}
		
		
	}
	
	/**
	 * Este metodo Retorna la lista de los iso en String para que sean mostrados
	 * en un combo box
	 * @return
	 */
	public  static ArrayList<String> retornarIsos() {
		
		ArrayList<String> listaIsos = new ArrayList<String>();
		
		listaIsos.add("DE");
		listaIsos.add("BR");
		listaIsos.add("BE");
		listaIsos.add("PT");
		listaIsos.add("AR");
		listaIsos.add("CH");
		listaIsos.add("FR");
		listaIsos.add("PL");
		listaIsos.add("CL");
		listaIsos.add("ES");
		listaIsos.add("PE");
		listaIsos.add("DK");
		listaIsos.add("DM");
		listaIsos.add("EN");
		listaIsos.add("UY");
		listaIsos.add("MX");
		listaIsos.add("CO");
		listaIsos.add("NL");
		listaIsos.add("GL");
		listaIsos.add("IT");
		listaIsos.add("HR");
		listaIsos.add("TN");
		listaIsos.add("IS");
		listaIsos.add("CR");
		listaIsos.add("US");
		listaIsos.add("AU");
		listaIsos.add("SN");
		listaIsos.add("SK");
		listaIsos.add("IE");
		listaIsos.add("RO");
		listaIsos.add("RI");
		listaIsos.add("PY");
		listaIsos.add("CUSTOM");
	
		
		
		return listaIsos;
	}
	
	
	
	
}
