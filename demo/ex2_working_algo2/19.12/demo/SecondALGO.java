package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class SecondALGO extends FirstALGO {
	/**
	 * this class gets input file of combo/united file -- test file(missing cord) -- and output path
	 *  runs algo 1 to get data of wifi locations and the restore the points data of the location of the user in the test files
	 *  
	 *  this algo 2 // uses algo 1 wifi locations and restores the locations 
	 *  if there r no inputs the algo will return the orginal line 
	 * @param path combo,united 
	 * @param test   missing data cord file
	 * @param output path of output
	 */

	public SecondALGO(String path,String test, String output) {
		/**
		 * constractor
		 */
		super(path, "",2);
		String ss=readTestcomb(test);
		FileWriter1 z=new FileWriter1(ss,output);
		//System.out.println(abc);
		// TODO Auto-generated constructor stub
	}
	
	public void algo2TEST() {
		
		for (int i = 0; i < tREAD.size(); i++) {
			
		}
		
	}
	
	
	public String temp(String str,int i,int type) {
		String[] x;
		LineRead3 temp=new LineRead3(str ,i,4);
		tREAD.add(temp);
		ArrayList<Read> sam=temp.sampels;
		//System.out.println(sampels);
	    LinkedList<Vector> list = new LinkedList<Vector>();
//System.out.println(abc.get(i));
		for (int j = 0; j < sam.size(); j++) {
			String mac=sam.get(j).mac;
			for (int k = 0; k < abc.size(); k++) {
				if(abc.get(k).get(1).equals(mac)) {
					list.add(abc.get(k));
					sam.get(j).lat=(double) abc.get(k).get(3);
					sam.get(j).lon=(double) abc.get(k).get(2);
					sam.get(j).high=(double) abc.get(k).get(4);
					
				}
				
			}
		}
		
		double []arr=pointSum2(sam);
		System.out.println(Arrays.toString(arr));
		if(list.size()==0) {
			System.out.println("this macs not found in this combo file \n"+sam);
		return str;
		}
		else  {
			String out="";
			x=str.split(",");
			x[2]=""+arr[1];
			x[3]=""+arr[0];
			x[4]=""+arr[2];
			for (int j = 0; j < x.length; j++) {
				out+=x[j]+",";
			}
			return out;
					}
		
		//else return str;
	}
	
	public double [] pointSum2(ArrayList<Read> Top4sampels) {
		//double []output= {0,0,0};
		double wlat=0,wlon=0,wH=0,Wegt=0,temp=0;
		for (int i = 0; i < Top4sampels.size(); i++) {
			double out[]={0,0,0};
			Read xz=Top4sampels.get(i);
			
		if(((xz.lat==0)||(xz.lon==0)||(xz.high==0))  ==false) {
			temp=1/(Math.pow(xz.signlPower, 2));
		
			wlat+=xz.lat*temp;
			wlon+=xz.lon*temp;
			wH+=xz.high*temp;
			Wegt+=temp;}
			
		}
	double[]	output= {wlat/Wegt,wlon/Wegt,wH/Wegt};
		
		
		return output;
	}
	/*
	private void reduce2Four(LinkedList<Vector> list) {
		// TODO Auto-generated method stub
		ArrayList<Read> out=new ArrayList<Read>();
		int count=0;
		while (count<4) {
			Read max=sampels.get(0);
			for (int i = 1; i < sampels.size(); i++) {
				Read temp=sampels.get(i);
				if(sampels.get(i).signlPower<max.signlPower)
					max=sampels.get(i);
			}
			count ++;
			out.add(max);
			sampels.remove(max);
		}
		this.sampels=out;
	}
	*/
	public String readTestcomb(String csv){
		/**
		 * reads the test file and send it for cord restore 
		 */
		String ss="";
		try { 	
			FileReader fr = new FileReader(csv);  
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			str = br.readLine();

			int i=0;	
			while(str!=null){
				if(str!=null)
			ss+=	temp(str,i,4)+"\n";
				
				i++;
				str = br.readLine();
			
				}
			br.close();        
			}
			
	
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}
return ss;
	 
	}// end read
	
	
	public static void main(String[] args) {
		SecondALGO x=new SecondALGO("c:\\knew\\testing\\_comb_all_BM2_.csv","c:\\knew\\testing\\_comb_no_gps_ts1.csv","c:\\knew\\testing\\algo2_check.csv");
		

		
		
	}// end main

}// end class
