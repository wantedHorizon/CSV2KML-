package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class guiUnited {
	public int filenum;
	public int linesnum;
	guiUnited(String folder,String ftime1,String ftime2,String lat, String lon, String alt,String device) {

		boolean check=false,check2=true,check3=true,check4=true,check5=true;
		//System.out.println("please enter input folder to unite and filter");

		while (check==false) {
			String input= folder;
			FolderDemo z=new FolderDemo(input);
			filenum = z.fileNum;
			if(z.check) {
				check=true;
				//System.out.println("files found \n please enter requested output");
				String output=folder;
				linesnum = UnitedCsv(z, input, output+"\\filters\\unitedCsv.csv");
				UnitedOrginizer mim=new UnitedOrginizer(output+"\\filters\\unitedCsv.csv");








				//System.out.println("do you want to filter by time?  yes- enter 1\n no- enter 2 ");
				while(check3){
					int input2 = 2;
					if (ftime1.length() != 1)
						input2 = 1;
					if(input2==1){
						String start = ftime1;
						String end = ftime2;
						FilterByTime x = new FilterByTime(start, end);
						//System.out.println("please enter name fille");
						String name = "filtertest";
						String tout=name+"_"+start+"_To_"+end+"_";
						tout=tout.replaceAll(" ", "--");
						tout=tout.replaceAll(":", ".");
					//	tout=tout.replaceAll("-", ".");
						//2017-10-27 16:27:53
						new File(output+"\\"+"filters").mkdir();
						linesnum = x.Filter(output+"\\filters\\unitedCsv.csv",output+"\\"+"filters\\filter.csv");
						check3=false;
					}
					else if (input2==2) {
						
						check3=false;
					}
					else
						System.out.println("error input incorrect try again");
				}//end while

				//System.out.println("do you want to fiter by ID? yes- enter 1\n no- enter 2 ");
				while(check4){
					int input3=2;
					if (device.length() != 1)
						input3 = 1;
					if(input3==1){
						String ID=device;
						//System.out.println(ID);
						FilterByID x = new FilterByID(ID);
						//System.out.println("please enter name fille");
						//String name = s.next();
						new File(output+"\\"+"filters").mkdir();
						linesnum = x.Filter(output+"\\filters\\unitedCsv.csv",output+"\\"+"filters\\filter.csv");
						check4=false;
					}
					else if (input3==2) {
						
						check4=false;
					}
					else
						System.out.println("error input incorrect try again");

				}//end while

				//System.out.println("do you want to filter by Lat, Lon and Alt? yes- enter 1\n no- enter 2");
				while(check5){
					int input4=2;
					if (lat.length() != 1)
						input4 = 1;
					if(input4==1){
						String Lat=lat;
						String Lon=lon;
						String Alt=alt;
						FilterByLatLonAlt x = new  FilterByLatLonAlt(Lat,Lon,Alt);
						new File(output+"\\"+"filters").mkdir();
						linesnum = x.Filter(output+"\\filters\\unitedCsv.csv",output+"\\"+"filters\\filter.csv");
						check5=false;
					}
					else if (input4==2) {
						
						check5=false;
					}
					else
						System.out.println("error input incorrect try again");
				}//end while










				//System.out.println("do u want to convert united file to .KML \n enter 1\n enter 2 to exit");
				while(check2) {
					int input1=2;
					if(input1==1) {
						//System.out.println("output:"+output);
						Csv2Kml mim1=new Csv2Kml(output+"\\filters\\unitedCsv.csv",output+"\\convertedKML.kml");
						check2=false;
					}
					else if (input1==2) {
						
						check2=false;
					}
					else
						System.out.println("error input incorrect try again");
				}//end while
			}//end if z/check
			else
				System.out.println("please enter again correct input contains only csv files ");
		}// end while







	}// end constractor


	public Vector algo1(String path,String mac) {
		//double []x = new double [3];
		Vector x=new Vector();
		
		
		FirstALGO algo=new FirstALGO(path,"",2);
		ArrayList<Vector> abc=algo.getAbc();
		for (int i = 0; i < abc.size(); i++) {
			//System.out.println(abc.get(i).get(1));
			if (abc.get(i).get(1).equals(mac)) {
				return abc.get(i);
			}
		}
		
		return x;
	}
	public  int UnitedCsv(FolderDemo x ,String folderName,String output){
		int countlines = 0;
		ArrayList<String> names=x.requestedfiles(x.files, 1, folderName);

		if(output.contains(".csv")==false)
			output+=".csv";
		CsvOrginaizer Semi[]=new CsvOrginaizer[names.size()];


		try {  
			FileWriter fw = new FileWriter(output); 

			PrintWriter writer=new PrintWriter(fw);
			writer.println("WigleWifi-1.4 , appRelease=2.25 , release=6.0.1 ");
			writer.println("Time ,ID, SSID , AuthMode , MAC , Channel , RSSI , Latitude , Longitude , AltitudeMeters , AccuracyMeters , Type");
			
			for(int i =0; i<names.size(); i++){
				Semi[i]=new CsvOrginaizer(folderName+"\\"+names.get(i));
				String mat[][]=Semi[i].getMath1();
				countlines += mat.length;
				String line="";
				for (int j = 0; j < mat.length; j++) {

					for (int j2 = 0; j2 < mat[j].length; j2++) {


						line+=mat[j][j2]+",";

					}
					writer.println(line);
					line="";

				}


			}//end for

			writer.close();
			fw.close();   
			//System.out.println("ALL FILES  "+names);
		//	System.out.println("Were united to path "+output);
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}
		return countlines;
	}
}
