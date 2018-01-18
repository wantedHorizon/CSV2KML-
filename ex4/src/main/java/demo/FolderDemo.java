package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FolderDemo {
	//public String files[] ={null};
	public ArrayList<String> files=new ArrayList<String>();

	boolean check=false;
	String Fpath="";
	public int fileNum=0;
	
	public ArrayList<String> requestedfiles(ArrayList<String> files,int x,String folder){
		ArrayList<String> y=new ArrayList<String>();
		
			for (int i = 0; i < files.size(); i++) 
				if(TypeCSVcheck(folder+"\\"+files.get(i))  ==x)
					y.add(files.get(i));
				
			
	
		
		
		
		return y;
	}
	public int TypeCSVcheck(String path) {
		
		if(path.toLowerCase().contains("comb")&&path.toLowerCase().contains(".csv"))
			return 3;
		try { 	
			FileReader fr = new FileReader(path);  
			BufferedReader br = new BufferedReader(fr);
			String str=br.readLine();
			
			if(str.contains("WigleWifi"))
				return 1;
			else if (str.contains("unitedcsv"))
				return 2;
			
		}
			catch(IOException ex) {  
				System.out.print("Error reading file\n" + ex); 
				System.exit(2);   
			}
			return 0 ;
		}

	
	
	
	//*********************************************gett&sett********************************

	
	//**************************************************************
	
	public FolderDemo(String path) {
		// TODO Auto-generated constructor stub
		path=pathCorrection(path);
		this.Fpath=path;
		this.files=fileNames(fileNum, path);

		this.fileNum=files.size();
		if (this.fileNum>0) {
			this.check=true;
			
			
	
		
		}
		else {
			this.check=false;
			System.out.println("error csv files not found");

		}
		
	}
	
	
	FolderDemo(){
		
	}
	public boolean checkExsitaence(String path) {
		boolean check=false;
		
		
		return check;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FolderDemo x= new FolderDemo("c:\\knew");
		Scanner z=new Scanner(System.in);
		String path=z.next();
			System.out.println(x.pathCorrection(path));

		
	}

	
	public  ArrayList<String> fileNames(int count,String directoryName) {
		File directory = new File(directoryName);
		ArrayList<String> names=new ArrayList<String>();
		//get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList){
			if (file.isFile()){
				if(file.getName().contains(".csv")) {
					names.add(file.getName());
					
				}
			}
		}
		return names;

	}// end list
	
	public String pathCorrection(String path) {
		path=path.replace("//","*")	;
		path=path.replace("/","*")	;	


path=path.replace("\\\\","*")	;
path=path.replace("\\","*")	;	
path=path.replace("*", "\\\\");

		/*
	String[]	x=path.split("\\");
	String out="";
	for (int i = 0; i < x.length; i++) {
		out+=x[i].replaceAll("\\", replacement)
		
	}
		*/
		return path;
	}

}//end class
