package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Compare {
	Vector<String> x=new Vector<String>();
	Vector<String> y=new Vector<String>();


	public static void main(String[] args) {
		Compare z=new Compare(   "C:\\knew\\testing\\out\\algo2_check__all_BM3_no_gps_ts2.csv"
				, "C:\\knew\\testing\\output\\Algo2_BM3_TS2_4.csv",
				"C:\\knew\\testing\\output\\compare_Algo2_BM3_TS2.csv" );
	}

	public Compare(String out1,String out2,String out3) {
		// TODO Auto-generated constructor stub
		read(out1,1);read(out2,2);
		String str=""; 
		System.out.println(x.size()+" "+y.size());
		for (int i = 0; i < x.size(); i++) {
			str+="My results:\n"+x.get(i)+"\n algo2 results\n"+y.get(i)+"\n\n";
			
		}
		/*
		System.out.println(this.x.size()+"\n\n"+this.y.size());
	
		for (int i = 0; i < y.size(); i++) {
			String []temp=y.get(i).split(",");
			System.out.println(temp[1]);
			for (int j = 0; j <x.size(); j++) {
				
				
				
				if(x.get(j).contains(temp[1])) {
					String []temp2=x.get(j).split(",");
					double a=Math.abs(Double.parseDouble(temp[5])-Double.parseDouble(temp2[2]))
							,b=Math.abs(Double.parseDouble(temp[6])-Double.parseDouble(temp2[3])),
							c=Math.abs(Double.parseDouble(temp[7])-Double.parseDouble(temp2[4]));
					temp2[1]+=",,,";
					String f="";
					for (int k = 0; k < temp2.length; k++) {
						f+=temp2[k]+",";
						
					}
					x.set(j, f);
					str+=y.get(i)+",,,***org algo 1 results\n "+x.get(j)+",***my algo1 results\n"
							+",,,,,Diff="+a+","+b+","+c+",\n\n";
					System.out.println("found");
				}
			}

		}
*/
		FileWriter1 s=new FileWriter1(str,out3);
	}
	public void read(String csv,int i){

		try { 	
			FileReader fr = new FileReader(csv);  
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			str = br.readLine();

			



			while(str!=null){
				
				if(str.length()>5) {
					if(i==1)
						x.add(str);
					else if(i==2)
						y.add(str);


				}

				str = br.readLine();
			}
			br.close();        

		}


		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex); 
			System.exit(2);   
		}


	}
}
