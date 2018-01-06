package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class UnitedOrginizer extends CsvOrginaizer {
	/**
	 * this Class takes the already united file and withraw the informtion for forther filtering by methods
	 * @param path csv file path
	 */
	//private String path=null;

	public   ArrayList<location> points = new ArrayList<location>();
	public ArrayList<LineRead> xRead=new ArrayList<LineRead>();
	
	
	
	public void Line2read(String line,int num) {
		//System.out.println(num+") "+Arrays.toString(line.split(",")));
		LineRead temp=new LineRead(line ,num);
		xRead.add(temp);
		
			
			
		}
	


	public UnitedOrginizer(String path) {
		super(path);
		// TODO Auto-generated constructor stub
		this.path=path;
		this.header=headerFind(path);
		this.order=OrderFind(path);
		this.Math1=MathFind(this.header,path);
		this.points=FilterBYlocation(Math1, points);
		UnitedFilterdCsv(this.Math1,this.points,path);
	
	}// end constractor





	public ArrayList<location> reduceTo10(String math[][],ArrayList<location> points){
		location temp =new location();
		for (int i = 0; i < points.size(); i++) {
			temp=points.get(i);
			Vector u=temp.getVec();
			if(u.size()>10) {
				u=sortBYindex(u, math);

			}
			temp.setVec(u);
			points.set(i, temp);
		}


		return points;
	}// end reduce to 10


	public  Vector  sortBYindex(Vector top,String math[][]) {
		/**
		 * sorting the  array of temporary strongest reads
		 */
		int now=Math.abs(Integer.parseInt(math[(int) top.get(10)][5]));
		int cur=0,now1=0,temp=0;
		for (int j = 0; j < top.size(); j++) {

			for (int j2 = 0; j2 < top.size()-1; j2++) {
				now1=Math.abs(Integer.parseInt(math[(int) top.get(j2)][5]));

				cur=Math.abs(Integer.parseInt(math[(int) top.get(j)][5]));
				if(cur>now1) {
					temp=(int) top.get(j2+1);
					top.set(j2+1,top.get(j2));
					top.set(j2, temp);

				}


			}

		}//end for
		Vector vec=new Vector();
		for (int i = 0; i < 10; i++) {
			vec.add(top.get(i));
		}





		return  vec;
	}

	public  ArrayList<location> FilterBYlocation(String math[][],ArrayList<location> points) {
		boolean check=false;

		for (int i  = 0; i < math.length; i++) {
			//int line =i;
			check =false;
			location temp =new location (math[i][7],math[i][8],math[i][9],i);
			for (int j = 0; check==false&&j < points.size(); j++) {
				location t= points.get(j);
				check=t.CheckEqual(temp, i);


			}
			if(check==false)
				points.add(temp);

		}
		;
		return reduceTo10(math, points);

	}//end filter by locations

	public  void UnitedFilterdCsv(String[][]mat ,ArrayList<location> points,String output){
		if(output.contains(".csv")==false)
			output+=".csv";
	

		try {  
			FileWriter fw = new FileWriter(output); 

			PrintWriter writer=new PrintWriter(fw);
			writer.println("unitedcsv file oop -project , appRelease=2.25 , release=6.0.1 ");
			writer.println("Time, ID, Lat, Lon, Alt, SSID1, MAC1, Signal1, Frequncy1"
					+", SSID2, MAC2, Signal, Frequncy2"+", SSID3, MAC3, Signal, Frequncy3"+", SSID4, MAC4, Signal, Frequncy4"+
					", SSID5, MAC5, Signal, Frequncy5"+", SSID6, MAC6, Signal, Frequncy6"+", SSID7, MAC7, Signal, Frequncy7"+", SSID8, MAC8, Signal, Frequncy8"+", SSID9, MAC9, Signal, Frequncy9"+", SSID10, MAC10, Signal, Frequncy10");

			location temp =new location();
			
			String line="";
			for(int i =0; i<points.size(); i++){
				temp=points.get(i);
				
				Vector vec=temp.getVec();
				int numLine=(int) vec.get(0);
				line+=mat[numLine][0]+","+mat[numLine][1]+","+mat[numLine][7]+","+mat[numLine][8]+","+mat[numLine][9];
				for (int j = 0; j < vec.size(); j++) {
					numLine=(int) vec.get(j);
					line+=","+mat[numLine][2]+","+mat[numLine][4]+","+mat[numLine][6]+","+mat[numLine][5];
				}
				Line2read(line,i);
				writer.println(line);

					line="";

				
				
																	
			}//end for

			writer.close();
			fw.close();   
			System.out.println("Were reduced to path "+output);
		}
		catch(IOException ex) {   
			System.out.print("Error writing file\n" + ex); 
		}

	}



}
