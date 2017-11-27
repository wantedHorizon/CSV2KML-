package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Csv2Kml {
	Csv2Kml(String path,String output){
	   
		Converter( path, output);
		
		
		
		
		
	}
	
	Csv2Kml(){
		
	}
	
	public String Timecorrect(String time) {
	
		if(time.contains("#"))
			return "";
		//System.out.println(time);
		
		time+="Z";
		time=time.replace(" ", "T");

		//System.out.println(Arrays.toString(date));
		String output="<TimeStamp>"+ 
				"<when>"+time+"</when> </TimeStamp>";
		//System.out.println(output);	      
		return output;
	}
	
	
	public void Converter(String path,String output ) {
		/**
		 * coverting csv to kml to an output requested 
		 */
		if(output.contains(".kml")==false)
			output+=".kml";
		try {  
			FileWriter fw = new FileWriter(output); 
			PrintWriter writer=new PrintWriter(fw);
			writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
			writer.println("<Document>");


			try { 
				FileReader fr = new FileReader(path);  
				BufferedReader br = new BufferedReader(fr);
				String str;    
				str = br.readLine(); 
				str = br.readLine(); 
				//str = br.readLine();
				


				String arr[];
				str = br.readLine();

				while((str!=null)&&(str.contains(",")) ){ 
					arr=str.split(",");
					String time=arr[0];
					//syso
				//	System.out.println(time);
					time=Timecorrect(time);
					//System.out.println(time);
					writer.println("<Placemark>"+time);
					String t=arr[1].replaceAll("&", "");
					t=t.replaceAll("model=", "");
					arr[1]=t;

					//String time="";
					writer.println("<name>"+arr[1]+"</name>");

					writer.println("<description>"+/*this point was created at:"+arr[0]+"*/"</description>");
					writer.print("<Point>");
					writer.println("<coordinates>"+arr[3]+","+arr[2]+"</coordinates></Point>");
					writer.println("</Placemark>");
					str = br.readLine();



				}
				writer.println("</Document>");
				writer.println("</kml>");
				System.out.println("file converted succesfuly");
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
	}//end converter


	

}
