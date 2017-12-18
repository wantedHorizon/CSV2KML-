package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SecondALGO extends FirstALGO {

	public SecondALGO(String path,String test, String output) {
		super(path, output);
		readTestcomb(test);
	//	System.out.println(tREAD);
		// TODO Auto-generated constructor stub
	}
	
	public void algo2TEST() {
		
		for (int i = 0; i < tREAD.size(); i++) {
			
		}
		
	}
	public static void main(String[] args) {
		SecondALGO x=new SecondALGO("c:\\knew\\testing\\_comb_all_BM3_.csv","c:\\knew\\testing\\_comb_no_gps_ts1.csv","c:\\knew\\testing\\algo1_check.csv");
		

		
		
	}
	
	public String temp(String str,int i,int type) {
		String x="";
		LineRead3 temp=new LineRead3(str ,i,4);
		tREAD.add(temp);
		ArrayList<Read> sampels=temp.sampels;
		System.out.println(sampels.size());
		for (int j = 0; j < sampels.size(); j++) {
			
		}
		
		
		return x;
	}
	
	public void readTestcomb(String csv){
		
		try { 	
			FileReader fr = new FileReader(csv);  
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			//String gg="";
			str = br.readLine();

			int i=0;	
			while(str!=null){
				//gg+=i+" "+str+"\n";
				if(str!=null)
				temp(str,i,4);
				
				i++;
				str = br.readLine();
			
				}
			br.close();        
			//System.out.println(gg);
			}
			
	
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}

	 
	}

}
