package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter1 {

	FileWriter1(String str , String output){
		Writer( str ,  output);
	}
	
	public void Writer(String str , String output){
		try {  
			FileWriter fw = new FileWriter(output); 
			PrintWriter writer=new PrintWriter(fw);
			writer.println(str);
			
			

			writer.close();
			fw.close();   
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}
	}
}
