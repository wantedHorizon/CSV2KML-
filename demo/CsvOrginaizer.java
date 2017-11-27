package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

public class CsvOrginaizer {
	public String ID=null;
	public String path;
	public  String Math1[][]=new String [1][1];
	public int header[]= {0,0};
	public String [] order= {null,null};//current order
	public final String  [] RightOrder= {"Time","ID","CurrentLatitude",
			"CurrentLatitude","CurrentLongitude","AltitudeMeters","SSID", "MAC","Channel","RSSI"};

	public int Long=0,wide=0;//mat long and mat how wide 


	public CsvOrginaizer(String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
		this.header=headerFind(path);
		this.order=OrderFind(path);
		this.Math1=MathFind(this.header,path);
	    this.Math1=	SwitchColum(Math1, 0, 3);
	
		this.ID=idReciver(path);
		this.Math1=addingID(this.ID, Math1);
		/**
		 * currently the order of math is :
		 * MAC || ID || SSID || AuthMode || FirstSeen/	Time||
		 *
		 */
		//	orginize(path, this.Math1, this.order, this.RightOrder);
	}
	public  String [][]addingID(String IDname,String mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			mat[i][0]+=	","+IDname;
		}
		return mat;

	}
	public  int[] top10read(String path) throws IOException {
		/**
		 * limit to 10 strongest reads line numbers
		 */
		int arr[]= new int [10];
		int top[]=new int[11];
		int power=0,lower=0;
		//int []as=new int [5000];
		int x=0;
		String math[][]=MathFind(headerFind(path), path);/*
		for (int i = 0; i < math.length-1; i++) {
			x=math.length-i;
			//System.out.print(Integer.parseInt(math[x][5])+","+i+"||");
			System.out.print(math[i][5].contains("-")+" "+i+"||");
		}*/
		for (int i = 0; i < 10; i++) {
			top[i]=	i;


		}
		for (int i = 10; i < math.length; i++) {
			if( math[i][5].contains("-") )
			{
				power=Math.abs(Integer.parseInt(math[i][5]));
				lower=Math.abs(Integer.parseInt(math[top[10]] [5]));
				//System.out.print(i+"||");
				if(power>lower){
					top[10]=i;
					top=sortBYindex(top, math);
				}
			}
		}

		return top;
	}// end top 10
	public static int [] sortBYindex(int top[],String math[][]) {
		/**
		 * sorting the  array of temporary strongest reads
		 */
		int now=Math.abs(Integer.parseInt(math[top[10]][5]));
		int cur=0,now1=0,temp=0;
		//	cur=Math.abs(Integer.parseInt(math[top[i]][5]));
		for (int j = 0; j < top.length; j++) {
			//	now1=Math.abs(Integer.parseInt(math[top[j]][5]));

			for (int j2 = j; j2 < top.length-1; j2++) {
				now1=Math.abs(Integer.parseInt(math[top[j2]][5]));

				cur=Math.abs(Integer.parseInt(math[top[j2+1]][5]));
				if(cur>now1) {
					temp=top[j2+1];
					top[j2+1]=top[j2];
					top[j2]=temp;

				}


			}

		}





		return top;
	}

	public  String idReciver(String path) {
		/**
		 * finding the id from csv file --first line with model 
		 */
		String x="not found";
		try { 
			FileReader fr = new FileReader(path);  
			BufferedReader br = new BufferedReader(fr);
			String str="";

			String arr[];//splot 
			str = br.readLine(); 


			arr=str.split(",");
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].contains("model")) {
					return arr[i];
				}

			}

		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}
		return x;

	}// end id reciver

	public static void correctName(String[]order) {
		/**
		 * correcting TITLES 
		 */
		for (int i = 0; i < order.length; i++) {
			if(order[i].equalsIgnoreCase("FirstSeen"))
				order[i]="Time";


		}
	}






	public  String[][] MathFind(int[]header,String path){
		/**
		 * creating math [][] and filing it from csv file 
		 */
		String brr[][]=new String[10][11];

		try { 
			FileReader fr = new FileReader(path);  
			BufferedReader br = new BufferedReader(fr);
			String crr[][]=new String[header[1]][header[0]];
			String str="";
			str = br.readLine(); 
			str = br.readLine(); 
			int y=0;

			String arr[];
			while(str!=null&&y<header[1]){
				str = br.readLine(); 
				arr=str.split(",");
				//System.out.println(Arrays.toString(arr));

				for(int i = 0; i<arr.length;i++){
					crr[y][i]=arr[i];

				}
				//System.out.println(Arrays.toString(crr[y])+y);
				y++;

			}
			return crr;



		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2); 
		}
		return brr;

	}

	public  String [] OrderFind(String path){
		/**
		 * finding the order currently 
		 */

		String brr[]={null};
		try { 
			FileReader fr = new FileReader(path);  
			BufferedReader br = new BufferedReader(fr);
			String str="";

			String arr[];//splot 
			str = br.readLine(); 
			str = br.readLine(); 
			arr=str.split(",");
			return arr;
		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2); 
		}
		return brr;

	}

	
	public   int[] headerFind(String path ){
		/**
		 * finding the size of the math [][] to be used 
		 */
		// TODO Auto-generated method stub
		int h[]= {0,0};
		try { 
			FileReader fr = new FileReader(path);  
			BufferedReader br = new BufferedReader(fr);
			String str="";

			String arr[];//splot 
			str = br.readLine(); 
		//	System.out.println(str);
			str = br.readLine(); 
			str = br.readLine(); 

			arr=str.split(",");
			//	System.out.println(str);
			int w=0;
			while(w<arr.length) {
				//	System.out.print(arr[w]+"|");
				w++;

			}

			//	System.out.println(arr.length);

			int count =0;
			while(str!=null){
				count++; 
				str = br.readLine(); 


				//System.out.println(str);
			}
		//	System.out.println(count);
			int []h1= {w,count};
			return h1;

		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}
		return h;
	}//end header find 



	//**********************************gett && setters***************************************************************************			
	public String[][] getMath1() {
		return Math1;
	}

	public void setMath1(String[][] math1) {
		Math1 = math1;
	}

	public int[] getHeader() {
		return header;
	}

	public void setHeader(int[] header) {
		this.header = header;
	}

	public String[] getOrder() {
		return order;
	}

	public void setOrder(String[] order) {
		this.order = order;
	}

	public int getLong() {
		return Long;
	}

	public void setLong(int l) {
		Long = l;
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}
	
	//***********************************************************************************************
	public  int searchIndex(String name,String order[]) {
		/**
		 * searhing for title name location 
		 */

		for (int i = 0; i < order.length; i++) {
			if(order[i].contains(name)) {
				System.out.println("found");

				return i;
			}

		}
		System.out.println("not found");
		return -1;// if -1 not found title
	}

	public  String[][] SwitchColum(String [][]arr,int orginal,int target) {

		for (int i = 0; i < arr.length; i++) {
			//System.out.println(Arrays.toString(x[i])+" "+i);
			String temp=arr[i][orginal];
			arr[i][orginal]=arr[i][target];
			arr[i][target]=temp;


		}
		return arr;

	}


	/*public void Csv2kml(String path,String output) {
		/*
		 * coverting csv to kml to an output requested 
		 
		try {  
			FileWriter fw = new FileWriter(output+".kml"); 
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
				str = br.readLine();


				String arr[];
				str = br.readLine();

				while((str!=null)&&(str.length()>10)){ 
					arr=str.split(",");
					writer.println("<Placemark>");
					String t=arr[1].replaceAll("&", "");
					arr[1]=t;


					writer.println("<name>"+arr[1]+"</name>");

					writer.println("<description>b</description>");
					writer.print("<Point>");
					writer.println("<coordinates>"+arr[7]+","+arr[6]+"</coordinates></Point>");
					writer.println("</Placemark>");


				}
				writer.println("</Document>");
				writer.println("</kml>");
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
/*






/*
	public static String[][] orginize(String path,String [][]mat,String Corder[],String Rorder[]) {

		for (int i =1; i < Rorder.length&&i!=1; i++) {
			if((Rorder[i].equalsIgnoreCase(Corder[i])) ==false){
				int adres=searchIndex(Rorder[i], Corder);//finding target colum
				if(adres!=-1) {//if found suppuse to be diff from -1 
					mat=SwitchColum(mat,i,adres );
					Corder[i]=Rorder[i];
					//setOrder(Corder);
					System.out.println(Arrays.toString(Corder));
				}
			}

		}
		return mat;



	}//end org*/





/*
	public static void main(String[] args) throws IOException{
		String path="c:\\new\\a.csv";
		int arr[]=new int [10];
		String[][]u =MathFind(headerFind(path),path);

		//	arr=top10read(path);
		//System.out.println(Arrays.toString(arr));
		for (int i = 0; i < u.length; i++) {

			System.out.println(Arrays.toString(u[i]));

		}
		u=addingID(idReciver(path), u);
		for (int i = 0; i < u.length; i++) {

			System.out.println(Arrays.toString(u[i]));

		}



				//String x=idReciver(path);
				//String  [] RightOrder= {"Time","ID","CurrentLatitude",
				//		"CurrentLatitude","CurrentLongitude","AltitudeMeters","SSID", "MAC","Channel","RSSI"};
				/*
		//System.out.println(x);
		int size[]=	headerFind(path);
		//System.out.println(Arrays.toString(size));
		String[][]u =MathFind(headerFind(path),path);
		/*
		for (int i = 0; i < 5; i++) {
			System.out.println((u[i][5]));
			int i
		}
		int Y=Integer.parseInt(u[4][5]);
		System.out.println(Y+" "+u[4][5]);
		//u=orginize(path, u, OrderFind(path), RightOrder);
		//u=SwitchColum(u, 0, 10);
		/*
		for (int i = 0; i < 30; i++) {
			System.out.println(Arrays.toString(u[i]));

		}




	}//END MAIN*/

}//END CLASS
