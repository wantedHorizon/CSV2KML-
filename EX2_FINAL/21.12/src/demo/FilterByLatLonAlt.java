package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FilterByLatLonAlt {
	String Lat;
	String Lon;
	String Alt;

	public  FilterByLatLonAlt(String Lat,String Lon,String Alt){
		this.Lat=Lat;
		this.Lon=Lon;
		this.Alt=Alt;
	}
	public void Filter(String csv, String output){

		try {  
			FileWriter fw = new FileWriter(output+".csv"); 
			PrintWriter writer=new PrintWriter(fw);
			try { 	
				FileReader fr = new FileReader(csv);  
				BufferedReader br = new BufferedReader(fr);
				String brr[];
				
				String str;
				str = br.readLine(); 
				str = br.readLine(); 
				str = br.readLine();
				while(str!=null){
					brr=str.split(",");
				//System.out.println(Arrays.toString(brr));
					if(brr[2].contains(Lat)&&brr[3].contains(Lon)&&brr[4].equals(Alt)){
						writer.println(str);
					}
					str = br.readLine();
				}
				br.close();        
				fr.close();
			}
			catch(IOException ex) {  
				System.out.print("Error reading file\n" + ex); 
				System.exit(2);   
			}

			writer.close();
			fw.close();   
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}
		
	}



}
