package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class FirstALGO  {
	//private double alt =0,lon=0,high=0;
	//private String mac="";
	public ArrayList<LineRead> xRead=new ArrayList<LineRead>();// only full combo /united lines
	public ArrayList<LineRead> tREAD=new ArrayList<LineRead>();// test file lines for algo 2
	public  ArrayList<String> ALLmac=new  ArrayList<String> ();// list of all the macs in full files 
	public  ArrayList<Vector> abc=new  ArrayList<Vector> ();//vectors of mac + locations 

	public void macList() {
		for (int i = 0; i < xRead.size(); i++) {
			
			for (int j = 0; j < xRead.get(i).sampels.size(); j++) {
				String mac= xRead.get(i).sampels.get(j).mac;
				if(ALLmac.contains(mac)==false)
					ALLmac.add(mac);
				
			}
			
		}
	}
	
	public FirstALGO(String path,String output) {
		FolderDemo s=new FolderDemo();
		//System.out.println(s.TypeCSVcheck(path));
		if(s.TypeCSVcheck(path)==2) {
		readFile(path);
		macList();
		String str="algo 1 results\n num,MAC,LAT,LON,ALT \n";
		for (int i = 0; i < ALLmac.size(); i++) {
			Macfiltering temp=new Macfiltering(xRead,ALLmac.get(i));		
			double []arr=pointSum1(temp.getTop4sampels());
			//System.out.println( i +Arrays.toString(arr));
			str+=i+","+ALLmac.get(i)+","+arr[0]+","+arr[1]+","+arr[2]+"\n";
			Vector aa= new Vector();
			aa.add(i);
			aa.add(ALLmac.get(i));aa.add(arr[0]);aa.add(arr[1]);aa.add(arr[2]);
			this.abc.add(aa);
		}
		FileWriter1 x=new  FileWriter1(str,output);
		System.out.println("file writen to "+output+" \nby algo1");

		
		}
		else if(s.TypeCSVcheck(path)==3) {
			readFile(path,3);
			macList();
			String str="algo 1 results\n num,MAC,LAT,LON,ALT \n";
			for (int i = 0; i < ALLmac.size(); i++) {
				Macfiltering temp=new Macfiltering(xRead,ALLmac.get(i));		
				double []arr=pointSum1(temp.getTop4sampels());
				//System.out.println( i +Arrays.toString(arr));
				str+=i+","+ALLmac.get(i)+","+arr[0]+","+arr[1]+","+arr[2]+"\n";
				Vector aa= new Vector();
				aa.add(i);
				aa.add(ALLmac.get(i));aa.add(arr[0]);aa.add(arr[1]);aa.add(arr[2]);
				this.abc.add(aa);
			}
			FileWriter1 x=new  FileWriter1(str,output);
			System.out.println("file writen to "+output+"\n by algo1");
		}
		
		
		
	}//end constractor
	
	public double [] pointSum1(ArrayList<Read> Top4sampels) {
		//double []output= {0,0,0};
		double wlat=0,wlon=0,wH=0,Wegt=0,temp=0;
		for (int i = 0; i < Top4sampels.size(); i++) {
			Read xz=Top4sampels.get(i);
			temp=1/(Math.pow(xz.signlPower, 2));
		
			wlat+=xz.lat*temp;
			wlon+=xz.lon*temp;
			wH+=xz.high*temp;
			Wegt+=temp;
			
		}
	double[]	output= {wlat/Wegt,wlon/Wegt,wH/Wegt};
		
		
		return output;
	}
	public void Line2read(String line,int num) {
		//System.out.println(num+") "+Arrays.toString(line.split(",")));
		LineRead temp=new LineRead(line ,num);
		xRead.add(temp);
		
			
			
		}
	
	public void Line2read(String line,int num,int type) {
		//System.out.println(num+") "+Arrays.toString(line.split(",")));
		if(type==2) {
		LineRead temp=new LineRead(line ,num);
		xRead.add(temp);
		}
		else if(type==3) {
			LineRead3 temp=new LineRead3(line ,num,3);
			xRead.add(temp);
			
		}
		else if(type==4) {
			LineRead3 temp=new LineRead3(line ,num,4);
			tREAD.add(temp);	
			
		}
	}
	public void readFile(String csv ,int type){
		
		try { 	
			FileReader fr = new FileReader(csv);  
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			if(type==2) {
			str = br.readLine(); 
			str = br.readLine();
			}
			str = br.readLine(); 
			int i=0;	
			while(str!=null&&str.length()>8){
				
				//System.out.println(i+") "+str);
				if(str.length()>8)
				Line2read(str,i,type);
				i++;
				str = br.readLine();
			
				}
			br.close();        

			}
			
	
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}

	 
	}
	
	public void readFile(String csv){
	
			try { 	
				FileReader fr = new FileReader(csv);  
				BufferedReader br = new BufferedReader(fr);
				String str = "";
				
				str = br.readLine(); 
				str = br.readLine(); 
				

				int i=2;	
				while(str!=null){
					str = br.readLine();
					//System.out.println(str);
					if(str!=null)
					Line2read(str,i);
					i++;

				
					}
				br.close();        

				}
				
		
			catch(IOException ex) {  
				System.out.print("Error reading file\n" + ex); 
				System.exit(2);   
			}

		 
		}
	/*
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}*/
	public ArrayList<LineRead> getxRead() {
		return xRead;
	}
	public void setxRead(ArrayList<LineRead> xRead) {
		this.xRead = xRead;
	}
	
	

}
