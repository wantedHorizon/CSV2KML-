package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class LineRead3 extends LineRead {

	public LineRead3(String line, int num,int type) {
		super();
		// TODO Auto-generated constructor stub

		//System.out.println(num+") "+line);
		String []str=line.split(",");

		if (line.contains(",,,")){
			String []ltr=line.split(",,,");
			line=ltr[0];


		}

		this.lineNumber=num;
		this.Time=str[0];
		this.ID=str[1];
		if(type!=4) {
			this.lat=Double.parseDouble(str[2]);
			this.lon=Double.parseDouble(str[3]);
			this.high=Double.parseDouble(str[4]);
		}
		int count=0;

		if((line.contains(",,"))) {
			String []ltr=line.split(",,");
			//	System.out.println(Arrays.toString(ltr));
			for (int i = 1; i < ltr.length; i++) {
				String[] temp1=ltr[i].split(",");
				Read temp=new Read(count,lineNumber,temp1[0],temp1[1],temp1[3],temp1[2],this.lat,this.lon,this.high);
				sampels.add(temp);
				//System.out.println(temp);
			}
			this.readnumber=sampels.size();
		}



		else {
			for (int i =6; i+3 < str.length; i+=4,count++) {
				//System.out.println(count+" ,"+lineNumber+" ,"+str[i]+" ,"+str[i+1]+" ,"+str[i+3]+" ,"+str[i+2]);

				Read temp=new Read(count,lineNumber,str[i],str[i+1],str[i+3],str[i+2],this.lat,this.lon,this.high);
				sampels.add(temp);
			}
			this.readnumber=sampels.size();
		}
		//System.out.println(sampels);
		//System.out.println(sampels);

		if(type==4&&sampels.size()>4) {
			reduce2Four();
		}
		//System.out.println(sampels);

	}

	private void reduce2Four() {
		// TODO Auto-generated method stub
		ArrayList<Read> out=new ArrayList<Read>();
		int count=0;
		while (count<4) {
			Read max=sampels.get(0);
			for (int i = 1; i < sampels.size(); i++) {
				Read temp=sampels.get(i);
				if(sampels.get(i).signlPower>max.signlPower)
					max=sampels.get(i);
			}
			count ++;
			out.add(max);
			sampels.remove(max);
		}
		this.sampels=out;
	}


}
