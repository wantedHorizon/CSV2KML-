package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class united {
	 united() {
		Scanner s = new Scanner(System.in);

		boolean check=false;
		System.out.println("please enter input folder to unite and filter");

		while (check==false) {
		String input=s.next();
		//System.out.println(input);
		FolderDemo z=new FolderDemo(input);
		if(z.check) {
			check=true;
			System.out.println("files found \n please enter requested output");
			String output=s.next();
		UnitedCsv(z, input, output+"\\unitedCsv.csv");
		UnitedOrginizer mim=new UnitedOrginizer(output+"\\unitedCsv.csv");
		}
		else
			System.out.println("please enter again correct input contains only csv files ");
		}

	//	System.out.println(Arrays.toString(mim.getMath1()[0]));
		//String[][] u=mim.getMath1();
		//location zero =new location ("0","0","0",0);
		//ArrayList<location> temp = new ArrayList<location> ();c
		//System.out.println(temp.size());
		//temp=mim.FilterBYlocation(u, temp);
		//UnitedFilterdCsv(u,temp,"C:\\check\\unitedCsv1.csv");
		
		
	}// end constractor
	


	public  void UnitedCsv(FolderDemo x ,String folderName,String output){
		String brr[]=x.getFiles();
		if(output.contains(".csv")==false)
			output+=".csv";
		CsvOrginaizer Semi[]=new CsvOrginaizer[brr.length];
		/*for (int i = 0; i < brr.length; i++) {
			Semi[i]=new CsvOrginaizer(brr[i]);

		}*/

		try {  
			FileWriter fw = new FileWriter(output); 
			//String mat[][];

			PrintWriter writer=new PrintWriter(fw);
			writer.println("WigleWifi-1.4 , appRelease=2.25 , release=6.0.1 ");
			writer.println("Time ,ID, SSID , AuthMode , MAC , Channel , RSSI , Latitude , Longitude , AltitudeMeters , AccuracyMeters , Type");
			for(int i =0; i<brr.length; i++){
				Semi[i]=new CsvOrginaizer(folderName+"\\"+brr[i]);
				String mat[][]=Semi[i].getMath1();
				String line="";
				for (int j = 0; j < mat.length; j++) {
					
					for (int j2 = 0; j2 < mat[j].length; j2++) {
						
							
						line+=mat[j][j2]+",";
						
					}
					//System.out.println(line);
					writer.println(line);
					line="";

				}
/*	
																		FileReader fr = new FileReader(folderName+"\\"+brr[i]);  
																		BufferedReader br = new BufferedReader(fr);
																		String str;
																		str = br.readLine(); 
																		str = br.readLine(); 
																		str = br.readLine();
																		while(str!=null){
																			writer.println(str);
																			str = br.readLine();
																		}//end while

																		br.close();        
																		fr.close();*/
			}//end for

			writer.close();
			fw.close();   
			System.out.println("ALL FILES  "+Arrays.toString(brr));
			System.out.println("Were united to path "+output);
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}

	}
}
