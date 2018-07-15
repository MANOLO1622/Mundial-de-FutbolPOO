package cl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileIO {

private String file;
	

	public TextFileIO( String file) {

	this.file= file;
	
	}//Fin del constructor.
	
	
	public void setFile(String file) {
		this.file = file;
	}//Fin del metodo setFile.
	
	
	public void setData(String data) throws IOException {
		
		try {
			
			FileWriter writer = new FileWriter(this.file, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			
			buffer.write(data);
			buffer.newLine();
			buffer.close();
			
		}catch(IOException e) {
			
			throw e;
			
		}//Fin del catch.
		
	}//Fin del metodo setData
	
	
	public ArrayList<String> getData() throws java.io.IOException{
		
		ArrayList<String> data = new ArrayList<>();
		
		try {
			
			FileReader reader = new FileReader(this.file);
			BufferedReader buffer = new BufferedReader(reader);
			String datos;
			
			while((datos = buffer.readLine()) != null) {
				
				data.add(datos);
				
			}//Fin del ciclo while.
			
			reader.close();
			return data;
			
		}//Fin del try
		
		catch(IOException e){
			
			throw e;
			
		}//Fin del catch
		
	}
	
	
}