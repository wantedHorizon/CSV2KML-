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

		boolean check=false,check2=true,check3=true,check4=true,check5=true;
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








				System.out.println("do you want to filter by time?  yes- enter 1\n no- enter 2 ");
				while(check3){
					int input2 =s.nextInt();
					if(input2==1){
						System.out.println("please enter start time");
						String start = s.next()+" "+s.next();
						System.out.println("please enter end time");
						String end = s.next()+" "+s.next();
						FilterByTime x = new FilterByTime(start, end);
						System.out.println("please enter name fille");
						String name = s.next();
						x.Filter(output+"\\unitedCsv.csv",name);

						check3=false;
					}
					else if (input2==2) {
						System.out.println("ok");
						check3=false;
					}
					else
						System.out.println("error input incorrect try again");
				}//end while

				System.out.println("do you want to fiter by ID? yes- enter 1\n no- enter 2 ");
				while(check4){
					int input3=s.nextInt();
					if(input3==1){
						System.out.println("please enter ID:");
						String ID=s.next();
						FilterByID x = new FilterByID(ID);
						//System.out.println("please enter name fille");
						//String name = s.next();
						x.Filter(output+"\\unitedCsv.csv",output+"\\filterBY"+ID);
						check4=false;
					}
					else if (input3==2) {
						System.out.println("ok");
						check4=false;
					}
					else
						System.out.println("error input incorrect try again");

				}//end while

				System.out.println("do you want to filter by Lat, Lon and Alt? yes- enter 1\n no- enter 2");
				while(check5){
					int input4=s.nextInt();
					if(input4==1){
						System.out.println("please enter Lat");
						String Lat=s.next();
						System.out.println("please enter Lon");
						String Lon=s.next();
						System.out.println("please enter Alt");
						String Alt=s.next();
						FilterByLatLonAlt x = new  FilterByLatLonAlt(Lat,Lon,Alt);
						System.out.println("please enter name fille");
						String name = s.next();
						x.Filter(output+"\\unitedCsv.csv",name);
						check5=false;
					}
					else if (input4==2) {
						System.out.println("ok");
						check5=false;
					}
					else
						System.out.println("error input incorrect try again");
				}//end while










				System.out.println("do u want to convert united file to .KML \n enter 1\n enter 2 to exit");
				while(check2) {
					int input1=s.nextInt();
					if(input1==1) {
						//System.out.println("output:"+output);
						Csv2Kml mim1=new Csv2Kml(output+"\\unitedCsv.csv",output+"\\convertedKML.kml");
						check2=false;
					}
					else if (input1==2) {
						System.out.println("ok");
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



	public  void UnitedCsv(FolderDemo x ,String folderName,String output){
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
			System.out.println("ALL FILES  "+names);
		//	System.out.println("Were united to path "+output);
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}

	}
}
